package ustc.zgq.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ustc.zgq.dao.CustomerManager;
import ustc.zgq.dao.FlightManager;
import ustc.zgq.dao.ReservationManager;
import ustc.zgq.entity.Customer;
import ustc.zgq.entity.Flight;
import ustc.zgq.entity.FlightReservation;
import ustc.zgq.entity.Seat;
import ustc.zgq.entity.SeatInfo;
import ustc.zgq.mytype.Trace;

/**
*@author created by zgq
*@date 2019年1月27日--上午8:47:43
*/
public class HandleResv extends ActionSupport{
	
	private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpSession session=request.getSession();
	private Trace trace=new Trace();
	private FlightManager fm = new FlightManager();
	private CustomerManager cm = new CustomerManager();
	private ReservationManager rm = new ReservationManager();
	private static FlightReservation fr = new FlightReservation();
	private List<FlightReservation> frs = new ArrayList<>();
	
	private Flight flight= new Flight();
	private List<Flight> flights = new ArrayList<>();
	private SeatInfo info = new SeatInfo();
	private List<SeatInfo> infos=new ArrayList<>();
	private Seat seat =new Seat();
	private List<Seat> seats =new ArrayList<>();
	private Customer cust=new Customer();
	private List<Customer> custs=new ArrayList<>();
	private int pageNum;
	private String nextAction;
	
	private static String resvKey;
	private static long keynum=0;
	
	public String execute() throws SQLException {	
		//no thing
       return SUCCESS;
}
	/**
	 * 填写订单的部分信息
	 * @return
	 */
	public String orderSeat() {
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
		System.out.println(pageNum+1);
		String flightNum= request.getParameter("flightNum");
		String seatType = request.getParameter("seatType");
		String seatId = request.getParameter("seatId");
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//		TemporalType date = formatter.parse(request.getParameter("date"));
		String date=request.getParameter("date");
		flight =fm.getFlight(flightNum);
		info =fm.getSeatInfo(flightNum,seatType);
		System.out.println(date);
		seat = fm.getSeat(seatId,date);
		fr.setSeatId(seatId);
		fr.setOrdDate(date);
		fr.setCustName(cust.getCustName());
		fr.setFlightNum(flight.getFlightNum());
		fr.setFromCity(flight.getFromCity());
		fr.setArivCity(flight.getArivCity());
		fr.setPrice(info.getPrice());
		fr.setSeatType(seatType);
		fr.setResvKey(getResvKey());  //key
		fr.setStatus(0);   //未支付
//		rm.saveFltResv(fr);
//		resvKey=fr.getResvKey();
		custs = cm.allCustomers(pageNum);
		session.setAttribute("custs", custs);
		return INPUT;

//		setNextAction("chooseCust");
//		session.setAttribute("tempt_fr", fr);
//		return "golbal";
	}
	/**
	 * 返回旅客信息供选择
	 * @return
	 */
	public String chooseCust(){	
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
		System.out.println(pageNum);
		custs = cm.allCustomers(pageNum);
		session.setAttribute("custs", custs);
		return INPUT;
	}
	
	/**
	 * 生成订单
	 * @return
	 */
	public String formFltOrd() {
		String custId =request.getParameter("custId");		
		cust = cm.getCust(custId);	
//		fr=rm.getFlightReservation(resvKey);
//		resvKey=null;    //清空
		fr.setCustId(custId);
		fr.setCustName(cust.getCustName());		
		rm.saveFltResv(fr);
		System.out.println(fr.toString());
		frs.add(fr);
		session.setAttribute("fltResv", frs);	
		return SUCCESS;
	}
	
	public String getFltOrds() {
		frs=rm.allFltResv(Integer.parseInt(request.getParameter("pageNum")));
		for(FlightReservation fr:frs) System.out.println(fr.toString());
		session.setAttribute("fltOrds", frs);
		return SUCCESS;
	}
	
	public void setNextAction(String nextAction) {
		this.nextAction=nextAction;
	}
	
	public String getNextAction() {
		return nextAction;
	}
	
	/**
	 * 手动分配Key T_T
	 * @return
	 */
	private String getResvKey () {
		keynum++;
		resvKey="key"+keynum;
		return resvKey;
	}
}

