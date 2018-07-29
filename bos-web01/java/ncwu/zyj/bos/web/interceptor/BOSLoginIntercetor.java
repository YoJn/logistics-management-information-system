package ncwu.zyj.bos.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import ncwu.zyj.bos.domain.User;
import ncwu.zyj.bos.utils.BOSutils;

public class BOSLoginIntercetor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = BOSutils.getLoginUser(); 
		if(user == null) {
			return "login";
		}
		return invocation.invoke();
	}

}
