package ncwu.zyj.bos.service;

import java.util.List;

import ncwu.zyj.bos.domain.Subarea;
import ncwu.zyj.bos.utils.PageBean;

public interface ISubareaService {

	void save(Subarea model);

	void pageQuery(PageBean pageBean);

	List<Subarea> findAll();

	List<Subarea> findListNotAssociation();

	List<Subarea> findListByDecidedzoneId(String decidedzoneId);

	List<Object> findSubareasGroupByProvince();

}
