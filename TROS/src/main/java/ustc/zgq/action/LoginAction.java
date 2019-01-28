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

public class LoginAction extends ActionSupport{
	private User user=new User();
	private HttpServletRequest request=ServletActionContext.getRequest();
	UserManager um=new UserManager();	
	
	public String execute() throws SQLException {	
		user.setUserId(request.getParameter("userid"));
		user.setPassWord(request.getParameter("password"));
		User u=um.Login(user);
		if(u!=null ) {
	        HttpSession session=request.getSession();
	        session.setAttribute("userid", u.getUserId());
	        session.setAttribute("username", u.getUserName());
	        return SUCCESS;
	    }
		return ERROR;
	}
}

  