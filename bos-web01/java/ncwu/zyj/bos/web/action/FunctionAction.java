package ncwu.zyj.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ncwu.zyj.bos.domain.Function;
import ncwu.zyj.bos.service.IFunctionService;
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function>{
	@Autowired
	private IFunctionService ifs;
	
	public String listajax() {
		List<Function> list =  ifs.findAll();
		this.java2Json(list, new String[] {"parentFunction","roles"});
		return NONE;
	}
	
	public String add() {
		ifs.save(model);
		return LIST;
	}
	
	public String pageQuery() {
		String page = model.getPage();
		pageBean.setCurrentPage(Integer.parseInt(page));
		ifs.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"parentFunction","roles","children"});
		return NONE;
	}
	
	public String findMenu() {
		List<Function> list = ifs.findMenu();
		this.java2Json(list, new String[] {"parentFunction","roles","children"});
		return NONE;
	}
}
