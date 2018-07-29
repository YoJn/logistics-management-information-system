package ncwu.zyj.bos.service;

import java.util.List;

import ncwu.zyj.bos.domain.Role;
import ncwu.zyj.bos.utils.PageBean;

public interface IRoleService {

	void save(Role model, String functionIds);

	void pageQuery(PageBean pageBean);

	List<Role> findAlll();

}
