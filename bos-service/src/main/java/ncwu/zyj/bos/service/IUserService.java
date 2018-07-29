package ncwu.zyj.bos.service;

import ncwu.zyj.bos.domain.User;
import ncwu.zyj.bos.utils.PageBean;

public interface IUserService {

	User login(User model);

	void editPassword(String id, String password);

	void save(User model, String[] roleIds);

	void pageQuery(PageBean pageBean);

}
