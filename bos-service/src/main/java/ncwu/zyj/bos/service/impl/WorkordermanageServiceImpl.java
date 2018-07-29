package ncwu.zyj.bos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ncwu.zyj.bos.dao.IWorkordermanageDao;
import ncwu.zyj.bos.domain.Workordermanage;
import ncwu.zyj.bos.service.IWorkordermanageService;
@Service
@Transactional
public class WorkordermanageServiceImpl  implements IWorkordermanageService{
	@Autowired
	private IWorkordermanageDao womd;
	@Override
	public void save(Workordermanage model) {
		womd.save(model);
	}

}
