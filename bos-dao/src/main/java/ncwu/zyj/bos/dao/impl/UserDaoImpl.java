package ncwu.zyj.bos.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;
import ncwu.zyj.bos.dao.IUserDao;
import ncwu.zyj.bos.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	@Override
	public User findUserByUsernameAndPassword(String string, String pw) {
		String hql = "from User u where u.username = ? and u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, string,pw);
		if(list != null && list.size()>0) {
			return list.get(0);
		}
		else 
			return null;
		
	}

	@Override
	public User findUserByUsername(String username) {
		String hql = "from User u where u.username = ? ";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if(list != null && list.size()>0) {
			return list.get(0);
		}
		else 
			return null;
	}

}
