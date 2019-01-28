package ustc.zgq.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import ustc.zgq.dao.UserManager;
import ustc.zgq.entity.User;

/**
*@author created by zgq
*@date 2019年1月24日--下午4:15:46
*/
public class RegisterAction extends ActionSupport{
	private User user=new User();
	private HttpServletRequest request=ServletActionContext.getRequest();
	UserManager um=new UserManager();
	private String[] s = request.getParameterValues("role");
	private String role = s[0];
		
	public String execute() throws SQLException {
		
		user.setUserId(request.getParameter("userid"));
		user.setUserName(request.getParameter("username"));
		user.setPassWord(request.getParameter("password"));
		user.setRole(role);
		if(um.Register(user)) {
	        HttpSession session=request.getSession();
	        session.setAttribute("username",user.getUserName());
	        session.setAttribute("userid", user.getUserId());
	        return SUCCESS;
	    }
		return ERROR;
	}
}

