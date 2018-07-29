package ncwu.zyj.bos.service;

import java.util.List;

import ncwu.zyj.bos.domain.Function;
import ncwu.zyj.bos.utils.PageBean;

public interface IFunctionService {

	List<Function> findAll();

	void save(Function model);

	void pageQuery(PageBean pageBean);

	List<Function> findMenu();

}
