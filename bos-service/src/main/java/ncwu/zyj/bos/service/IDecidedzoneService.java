package ncwu.zyj.bos.service;

import ncwu.zyj.bos.domain.Decidedzone;
import ncwu.zyj.bos.utils.PageBean;

public interface IDecidedzoneService {

	void save(Decidedzone model, String[] subareaid);

	void pageQuery(PageBean pageBean);

}
