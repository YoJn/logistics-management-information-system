package ncwu.zyj.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import ncwu.zyj.bos.domain.User;

public class BOSutils {
  public static HttpSession getSession() {
	  return ServletActionContext.getRequest().getSession();
  }
  public static User getLoginUser() {
	  return (User)getSession().getAttribute("loginUser");
  }
}
