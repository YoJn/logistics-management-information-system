package ncwu.zyj.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ncwu.zyj.bos.domain.Decidedzone;
import ncwu.zyj.bos.service.IDecidedzoneService;
import ncwu.zyj.crm.Customer;
import ncwu.zyj.crm.ICustomerService;
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone>{
	private String[] subareaid;
	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	
	@Autowired
	private IDecidedzoneService decidedzoneService;
	
	public String add() {
		decidedzoneService.save(model,subareaid);
		return LIST;
	}
	
	public String pageQuery() {
		decidedzoneService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"currentPage","detachedCriteria","pageSize","subareas","decidedzones"});
		return NONE;
		
	}
	
	@Autowired
	private ICustomerService  proxy;
	
	public String findListNotAssociation() {
		List<Customer> list = proxy.findListNotAssociation();
		this.java2Json(list, new String[] {});
		return NONE;
	}
	
	public String findListHasAssociation() {
		String id = model.getId();
		List<Customer> list = proxy.findListHasAssociation(id);
		this.java2Json(list, new String[] {});
		return NONE;
	}
	
	private List<Integer> customerIds;
	
	public String assigncustomerstodecidedzone() {
		proxy.assigncustomerstodecidedzone(model.getId(), customerIds);
		return LIST;
	}



	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}
}
