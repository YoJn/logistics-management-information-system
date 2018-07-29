package ncwu.zyj.bos.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import ncwu.zyj.bos.utils.PageBean;

public interface IBaseDao<T> {
    public void save(T t);
	public void delete(T t);
	public void update(T t);
	public void saveOrUpdate(T t);
	public T findById(Serializable id);
	public List<T> findAll();
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);
	public void executeUpdate(String queryName, Object... objects);
	public void pageQuery(PageBean pageBean);
	
}
