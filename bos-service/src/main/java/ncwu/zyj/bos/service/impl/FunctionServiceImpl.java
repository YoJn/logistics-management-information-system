package ncwu.zyj.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ncwu.zyj.bos.dao.IFunctionDao;
import ncwu.zyj.bos.domain.Function;
import ncwu.zyj.bos.domain.User;
import ncwu.zyj.bos.service.IFunctionService;
import ncwu.zyj.bos.utils.BOSutils;
import ncwu.zyj.bos.utils.PageBean;
@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService{
	@Autowired
	private IFunctionDao ifd;
	
	@Override
	public List<Function> findAll() {
		return ifd.findAll();
	}

	@Override
	public void save(Function model) {
		Function function = model.getParentFunction();
		if(function != null && function.getId().equals("")) {
			model.setParentFunction(null);
		}
		ifd.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		ifd.pageQuery(pageBean);
	}

	@Override
	public List<Function> findMenu() {
		List<Function> list = null;
		User user = BOSutils.getLoginUser();
		if(user.getUsername().equals("admin")) {
			list = ifd.findAllMenu();
		}else {
			list = ifd.findMenuByUserId(user.getId());
		}
		return list;
	}

}
