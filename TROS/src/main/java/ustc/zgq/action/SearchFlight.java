package ustc.zgq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ustc.zgq.dao.FlightManager;
import ustc.zgq.entity.Flight;
import ustc.zgq.entity.Seat;
import ustc.zgq.entity.SeatInfo;
import ustc.zgq.mytype.Trace;

/**
*@author created by zgq
*@date 2019年1月25日--下午5:58:19
*/
public class SearchFlight extends ActionSupport{
	private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpSession session=request.getSession();
	private Trace trace=new Trace();
	private FlightManager fm = new FlightManager();
	private Flight flight= new Flight();
	private List<Flight> flights = new ArrayList<>();
	
	private SeatInfo info = new SeatInfo();
	private List<SeatInfo> infos=new ArrayList<>();
	
	private Seat seat =new Seat();
	private List<Seat> seats =new ArrayList<>();

	/**
	 * 查询数据库中的航班信息
	 * @return
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		flights=(fm.allFlights(pageNum));
		session.setAttribute("flights", flights);
	    return SUCCESS;
	}
	
	/**
	 * 查看所有航班详情
	 * @return
	 */
	public String SearchSeatInfos() {
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		infos=fm.allSeatInfo(pageNum);
		session.setAttribute("allstInfos", infos);
		return SUCCESS;
	}
	
	/**
	 * 根据航班号查询航班详情
	 * @return
	 */
	public String getSeatInfo() {
		infos=fm.getSeatInfos(request.getParameter("flightNum"));	
		session.setAttribute("stInfos", infos);
		return SUCCESS;
	}
	
	
	/**
	 * 根据航班号查询座位
	 * @return
	 */
	public String getSeats() {
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		seats=fm.getSeats(request.getParameter("flightNum"),request.getParameter("seatType"),pageNum);
		session.setAttribute("seats", seats);
		return SUCCESS;
	}
	
}

