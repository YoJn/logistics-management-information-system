package ncwu.zyj.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ncwu.zyj.bos.dao.IUserDao;
import ncwu.zyj.bos.domain.Role;
import ncwu.zyj.bos.domain.User;
import ncwu.zyj.bos.service.IUserService;
import ncwu.zyj.bos.utils.MD5Utils;
import ncwu.zyj.bos.utils.PageBean;
@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User login(User user) {
		String pw = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(), pw);
	}

	@Override
	public void editPassword(String id, String password) {
		String pw = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword", pw, id);
		
	}

	@Override
	public void save(User model, String[] roleIds) {
		String password = model.getPassword();
		password = MD5Utils.md5(password);
		model.setPassword(password);
		userDao.save(model);
		if(roleIds != null && roleIds.length>0) {
			for (String roleId : roleIds) {
				Role role = new Role(roleId);
				model.getRoles().add(role);
			}
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}

}
