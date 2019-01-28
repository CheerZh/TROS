package ustc.zgq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import ustc.zgq.dao.CustomerManager;
import ustc.zgq.entity.Customer;


/**
*@author created by zgq
*@date 2019年1月28日--上午1:56:06
*/
public class SearchCusts extends ActionSupport{
	
	private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpSession session=request.getSession();
	private CustomerManager cm = new CustomerManager();
	private Customer cust=new Customer();
	private List<Customer> custs=new ArrayList<>();
	
	public String execute() {		
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		System.out.println(pageNum);
		custs = cm.allCustomers(pageNum);
		session.setAttribute("custs", custs);
		return SUCCESS;
	}

}

