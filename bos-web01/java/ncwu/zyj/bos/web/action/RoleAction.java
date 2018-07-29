package ncwu.zyj.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ncwu.zyj.bos.domain.Role;
import ncwu.zyj.bos.service.IRoleService;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	private String functionIds;
	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}
	@Autowired
	private IRoleService irs;
	
	public String add() {
		irs.save(model,functionIds);
		return LIST;
	}
	
	public String pageQuery() {
		irs.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"functions","users"});
		return 	NONE;
	}
 	
	public String listajax() {
		List<Role> list = irs.findAlll();
		this.java2Json(list, new String[] {"functions","users"});
		return NONE;
	}
}
