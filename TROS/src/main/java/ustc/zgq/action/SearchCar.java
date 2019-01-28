package ustc.zgq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import ustc.zgq.dao.CarManager;
import ustc.zgq.entity.Car;

/**
*@author created by zgq
*@date 2019年1月25日--下午10:24:12
*/
public class SearchCar extends ActionSupport {
	private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpSession session=request.getSession();
	private CarManager cm = new CarManager();
	private Car car= new Car();
	private List<Car> cars = new ArrayList<>();
	private int pageNum=Integer.parseInt(request.getParameter("pageNum"));
	
	/**
	 * 查询数据库中的车辆信息
	 * @return
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		cars=(cm.allCars(pageNum));
		HttpSession session=request.getSession();
		session.setAttribute("cars", cars);
	    return SUCCESS;
	}
	
	public String SearchCar() {
		car=cm.getCar(request.getParameter("carId"));
		cars.clear();
		cars.add(car);
		session.setAttribute("cars", cars);
		return SUCCESS;
	}
}

