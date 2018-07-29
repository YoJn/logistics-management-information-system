package ncwu.zyj.bos.web.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ncwu.zyj.bos.domain.User;
import ncwu.zyj.bos.service.IUserService;
import ncwu.zyj.bos.utils.BOSutils;
import ncwu.zyj.bos.utils.MD5Utils;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	@Autowired
	private IUserService userService;

	/**
	 * 用户登录
	 */
	public String login() {
		//从Session中获取生成的验证码
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//校验验证码是否输入正确
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
			//使用shiro框架提供的方式进行认证操作
			Subject subject = SecurityUtils.getSubject();//获得当前用户对象,状态为“未认证”
			AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),MD5Utils.md5(model.getPassword()));//创建用户名密码令牌对象
			try{
				subject.login(token);
			}catch(Exception e){
				e.printStackTrace();
				return LOGIN;
			}
			User user = (User) subject.getPrincipal();
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			return HOME;
		}else{
			//输入的验证码错误,设置提示信息，跳转到登录页面
			this.addActionError("输入的验证码错误！");
			return LOGIN;
		}
	}
	/**
	 * 用户注销
	 */
	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	/**
	 * 修改密码
	 * @throws IOException 
	 */
	public String editPassword() throws IOException {
		String f = "1";
		User user = BOSutils.getLoginUser();
		try {
			userService.editPassword(user.getId(),model.getPassword());
		}catch(Exception e) {
			f = "0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	
	private String[] roleIds;
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	public String add() {
		userService.save(model,roleIds);
		return LIST;
	}
	
	public String pageQuery() {
		userService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"noticebills","roles"});
		return NONE;
	}
}
