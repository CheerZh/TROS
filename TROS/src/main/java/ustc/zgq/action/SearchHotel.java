package ustc.zgq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import ustc.zgq.dao.HotelManager;
import ustc.zgq.entity.FlightReservation;
import ustc.zgq.entity.Hotel;


/**
*@author created by zgq
*@date 2019年1月26日--上午12:44:51
*/
public class SearchHotel extends ActionSupport{
	private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpSession session=request.getSession();
	private HotelManager hm = new HotelManager();
	private Hotel hotel= new Hotel();
	private List<Hotel> hotels = new ArrayList<>();
	/**
	 * 查询所有的酒店信息
	 * @return
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		hotels= hm.allHotels(pageNum);
		session.setAttribute("hotels", hotels);
	    return SUCCESS;
	}
	/**
	 * 根名称查询酒店
	 * @return
	 */
	public String SearchRoom() {

		hotel=hm.getHotel(request.getParameter("hotelNum"));
		hotels.clear();
		hotels.add(hotel);
		session.setAttribute("hotels", hotels);
		return SUCCESS;
	}
	


}

