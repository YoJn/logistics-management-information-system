package ncwu.zyj.bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ncwu.zyj.bos.domain.Noticebill;
import ncwu.zyj.bos.service.INoticebillService;
import ncwu.zyj.crm.Customer;
import ncwu.zyj.crm.ICustomerService;
@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill>{
	@Autowired
	private ICustomerService customerService;
	
	public String findCustomerByTelephone() {
		String telephone = model.getTelephone();
		Customer customer = customerService.findCustomerByTelephone(telephone);
		this.java2Json(customer, new String[] {});
		return NONE;
	}
	
	@Autowired
	private INoticebillService noticebillservice;
	
	public String add() throws IOException {
		String f= "1";
		try {
			noticebillservice.save(model);
		} catch (Exception e) {
			e.printStackTrace();
			f="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return "noticebill_add";
	}
}
