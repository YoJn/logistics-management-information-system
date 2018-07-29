package ncwu.zyj.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ncwu.zyj.bos.dao.IDecidedzoneDao;
import ncwu.zyj.bos.dao.ISubareaDao;
import ncwu.zyj.bos.domain.Decidedzone;
import ncwu.zyj.bos.domain.Subarea;
import ncwu.zyj.bos.service.IDecidedzoneService;
import ncwu.zyj.bos.utils.PageBean;
@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService{

	@Autowired
	private IDecidedzoneDao decidedzonedao;
	@Autowired
	private ISubareaDao subareadao; 
	public void save(Decidedzone model, String[] subareaid) {
		decidedzonedao.save(model);
		for (String id : subareaid) {
			Subarea subarea = subareadao.findById(id);
			subarea.setDecidedzone(model); 
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		decidedzonedao.pageQuery(pageBean);
	}
	
	

}
