package ncwu.zyj.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ncwu.zyj.bos.domain.Region;
import ncwu.zyj.bos.domain.Subarea;
import ncwu.zyj.bos.service.ISubareaService;
import ncwu.zyj.bos.utils.FileUtils;
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Resource
	private ISubareaService subareaService;
	public String add() {
		subareaService.save(model);
		return LIST;
	}
	
	public String pageQuery() {
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		String addresskey = model.getAddresskey();
		if(StringUtils.isNotBlank(addresskey)) {
			dc.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
		}
		Region region = model.getRegion();
		if(region != null) {
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			dc.createAlias("region", "r");
			if(StringUtils.isNotBlank(province)) {
				dc.add(Restrictions.like("r.province", "%"+province+"%"));
			}
			if(StringUtils.isNotBlank(city)) {
				dc.add(Restrictions.like("r.city", "%"+city+"%"));
			}
			if(StringUtils.isNotBlank(district)) {
				dc.add(Restrictions.like("r.district", "%"+district+"%"));
			}
		}
		
		subareaService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"currentPage","detachedCriteria","pageSize","decidedzone","subareas"});
		return NONE;
	}
	
	public String exportXls() throws Exception {
		List<Subarea> list = subareaService.findAll();
		//内存中创建一个空excel,什么都没有
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("分区数据");
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("分区编号");
		headRow.createCell(1).setCellValue("开始编号");
		headRow.createCell(2).setCellValue("结束编号");
		headRow.createCell(3).setCellValue("位置信息");
		headRow.createCell(4).setCellValue("省市区");
		
		for (Subarea subarea : list) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getStartnum());
			dataRow.createCell(2).setCellValue(subarea.getEndnum());
			dataRow.createCell(3).setCellValue(subarea.getPosition());
			dataRow.createCell(4).setCellValue(subarea.getRegion().getName());
		}
		
		String filename = "分区数据.xls";
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		ServletActionContext.getResponse().setContentType("application/vnd.ms-excel");
		
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename="+filename);
		
		workbook.write(out);
		
		return NONE;
	}
	
	public String listajax() {
		List<Subarea> list = subareaService.findListNotAssociation();
		this.java2Json(list, new String[] {"decidedzone","region"});
		return NONE;
	}
	
	private String decidedzoneId;
	
	public String findListByDecidedzoneId() {
		List<Subarea> list = subareaService.findListByDecidedzoneId(decidedzoneId);
		this.java2Json(list, new String[] {"decidedzone","subareas"});
		return NONE;
	}


	public void setDecidedzoneId(String decidedzoneId) {
		this.decidedzoneId = decidedzoneId;
	}
	
	
	public String findSubareasGroupByProvince() {
		List<Object> list = subareaService.findSubareasGroupByProvince();
		this.java2Json(list, new String[] {});
		return NONE;
	}
}
