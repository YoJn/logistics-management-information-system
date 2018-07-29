package ncwu.zyj.bos.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ncwu.zyj.bos.dao.IDecidedzoneDao;
import ncwu.zyj.bos.dao.INoticebillDao;
import ncwu.zyj.bos.dao.IWorkbillDao;
import ncwu.zyj.bos.domain.Decidedzone;
import ncwu.zyj.bos.domain.Noticebill;
import ncwu.zyj.bos.domain.Staff;
import ncwu.zyj.bos.domain.User;
import ncwu.zyj.bos.domain.Workbill;
import ncwu.zyj.bos.service.INoticebillService;
import ncwu.zyj.bos.utils.BOSutils;
import ncwu.zyj.crm.ICustomerService;

@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService{

	@Autowired
	private INoticebillDao noticebilldao;
	
	@Autowired
	private IDecidedzoneDao decidedzonedao;
	
	@Autowired
	private ICustomerService customerservice;
	
	@Autowired
	private IWorkbillDao workbilldao;
	
	@Override
	public void save(Noticebill model) {
		User user = BOSutils.getLoginUser();
		model.setUser(user);
		noticebilldao.save(model);
		
		String address = model.getPickaddress();
		String decidedzoneId = customerservice.findDecidedzoneIdByAddress(address);
		if(decidedzoneId != null) {
			Decidedzone decidedzone = decidedzonedao.findById(decidedzoneId);
			Staff staff = decidedzone.getStaff();
			model.setStaff(staff);
			model.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			Workbill workbill = new Workbill();
			workbill.setAttachbilltimes(0);//追单词书
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));
			workbill.setNoticebill(model);//关联业务通知单
			workbill.setPickstate(Workbill.PICKSTATE_NO);
			workbill.setRemark(model.getRemark());
			workbill.setStaff(staff);
			workbill.setType(Workbill.TYPE_1);
			
			workbilldao.save(workbill);
			
		}else {
			model.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
	}

}
