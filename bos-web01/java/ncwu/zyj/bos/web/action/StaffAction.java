package ncwu.zyj.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import ncwu.zyj.bos.domain.Staff;
import ncwu.zyj.bos.service.IStaffService;
import ncwu.zyj.bos.utils.PageBean;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private IStaffService staffService;
	
	public String add() {
		staffService.save(model);
		return LIST;
	}
	
	
	
	public String pageQuery() throws IOException {
		staffService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"currentPage","detachedCriteria","pageSize","decidedzones"});
		return NONE;
	}

	private String ids;
	@RequiresPermissions("staff-delete")//执行这个方法，需要当前用户具有staff-delete权限
	public String deleteBatch() {
		staffService.deletBatch(ids);
		return LIST;
	}
	
	@RequiresPermissions("staff-edit")
	public String edit() {
		Staff staff = staffService.findById(model.getId());
		staff.setName(model.getName()); 
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staffService.update(staff);
		return LIST;
	}
	
	public String listajax() {
		List<Staff> list =  staffService.findListNotDelete(); 
		this.java2Json(list, new String[] {"decidedzones","telephone","deltag","station","standard"});
		return NONE;
	}

	public String getIds() {
		return ids;
	}

}
