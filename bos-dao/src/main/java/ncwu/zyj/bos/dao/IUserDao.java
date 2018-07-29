package ncwu.zyj.bos.dao;

import ncwu.zyj.bos.domain.User;

public interface IUserDao extends IBaseDao<User> {

	User findUserByUsernameAndPassword(String string, String pw);


	User findUserByUsername(String username);

}
