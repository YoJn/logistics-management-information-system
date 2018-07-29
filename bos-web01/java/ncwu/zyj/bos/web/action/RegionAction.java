package ncwu.zyj.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ncwu.zyj.bos.domain.Region;
import ncwu.zyj.bos.service.IRegionService;
import ncwu.zyj.bos.utils.PageBean;
import ncwu.zyj.bos.utils.PinYin4jUtils;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region>{
	@Autowired
	private IRegionService regionService ;
	
	private File regionFile;
	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}
	
	public String importXls() throws Exception {
		List<Region> list = new ArrayList<Region>();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
		HSSFSheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			int rowNum = row.getRowNum();
			if(rowNum == 0)
				continue;
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			
			Region region = new Region(id, province, city, district, postcode, null, null, null); 
			
			province.substring(0, province.length()-1);
			city.substring(0, city.length()-1);
			district.substring(0, district.length()-1);
			
			String info = province + city + district ;
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);
			String citycode =PinYin4jUtils.hanziToPinyin(city,"");
			
			region.setCitycode(citycode);
			region.setShortcode(shortcode);
			
			list.add(region);
		}
		
		regionService.saveBatch(list);
		return NONE;
	}
	

	public String pageQuery() throws IOException {
		regionService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"currentPage","detachedCriteria","pageSize","subareas"});
		return NONE;
	}
	private String q;
	
	public String listAjax() {
		List<Region> list = null;
		if(StringUtils.isNotBlank(q)) {
			list = regionService.findListByQ(q);
		}else {
			list = regionService.findAll();
		}
		this.java2Json(list, new String[] {"subareas"});
		return NONE;
		
	}


	public void setQ(String q) {
		this.q = q;
	}
}
