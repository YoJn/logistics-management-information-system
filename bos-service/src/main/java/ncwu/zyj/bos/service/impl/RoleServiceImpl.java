package ncwu.zyj.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ncwu.zyj.bos.dao.IRoleDao;
import ncwu.zyj.bos.domain.Function;
import ncwu.zyj.bos.domain.Role;
import ncwu.zyj.bos.service.IRoleService;
import ncwu.zyj.bos.utils.PageBean;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private IRoleDao ird;
	
	@Override
	public void save(Role model, String functionIds) {
		ird.save(model);
		if(StringUtils.isNotBlank(functionIds)) {
			String[] fIds = functionIds.split(",");
			for (String functionId : fIds) {
				Function function = new Function(functionId);
				model.getFunctions().add(function);
			}
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		ird.pageQuery(pageBean);
	}

	@Override
	public List<Role> findAlll() {
		return ird.findAll();
	}

}
