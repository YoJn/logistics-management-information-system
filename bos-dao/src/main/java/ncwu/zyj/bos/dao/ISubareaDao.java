package ncwu.zyj.bos.dao;

import java.util.List;

import ncwu.zyj.bos.domain.Subarea;

public interface ISubareaDao extends IBaseDao<Subarea> {

	List<Object> findSubareasGroupByProvince();

}
