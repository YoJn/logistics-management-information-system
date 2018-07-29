package ncwu.zyj.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ncwu.zyj.bos.dao.IFunctionDao;
import ncwu.zyj.bos.domain.Function;
@Repository
@Transactional
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao{
	@Override
	public List<Function> findAll(){
		String hql = "FROM Function f WHERE f.parentFunction IS NULL";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<Function> findFunctionByUserId(String id) {
		String hql = "select distinct f FROM Function f LEFT outer join f.roles r left outer join r.users u where u.id = ?";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql, id);
		return list;
	}

	@Override
	public List<Function> findAllMenu() {
		String hql = "FROM Function f WHERE f.generatemenu = '1' order by f.zindex desc";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<Function> findMenuByUserId(String id) {
		String hql = "select distinct f FROM Function f LEFT outer join f.roles r"
						+" left outer join r.users u where u.id = ? and f.generatemenu = '1'"
						+" order by f.zindex desc";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql, id);
		return list;
	}
}
