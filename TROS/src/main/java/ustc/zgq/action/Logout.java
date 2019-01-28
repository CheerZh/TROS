package ustc.zgq.action;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*@author created by zgq
*@date 2019年1月25日--上午10:44:48
*/
public class Logout extends ActionSupport{
	private HttpServletRequest request=ServletActionContext.getRequest();
	
	public String execute() throws SQLException {	
	        HttpSession session=request.getSession();
	       session.invalidate();
	       return SUCCESS;
	}
}

