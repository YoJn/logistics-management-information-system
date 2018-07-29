package ncwu.zyj.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ncwu.zyj.bos.domain.Workordermanage;
import ncwu.zyj.bos.service.IWorkordermanageService;
@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<Workordermanage> {
	@Autowired
	private IWorkordermanageService woms;
	public String add() {
		woms.save(model);
		return NONE;
	}
}
