package ncwu.zyj.bos.dao;

import java.util.List;

import ncwu.zyj.bos.domain.Function;

public interface IFunctionDao extends IBaseDao<Function> {

	List<Function> findFunctionByUserId(String id);

	List<Function> findAllMenu();

	List<Function> findMenuByUserId(String id);

}
