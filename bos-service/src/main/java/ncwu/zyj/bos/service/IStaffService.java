package ncwu.zyj.bos.service;

import java.util.List;

import ncwu.zyj.bos.domain.Staff;
import ncwu.zyj.bos.utils.PageBean;

public interface IStaffService {

	void save(Staff model);

	void pageQuery(PageBean pageBean);

	void deletBatch(String ids);

	Staff findById(String id);

	void update(Staff staff);

	List<Staff> findListNotDelete();
	
}
