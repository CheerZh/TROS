package ustc.zgq.dao;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ustc.zgq.config.HibernateSessionFactory;
import ustc.zgq.entity.Flight;
import ustc.zgq.entity.Seat;
import ustc.zgq.entity.SeatInfo;
import ustc.zgq.mytype.Trace;

/**
*@author created by zgq
*@date 2019年1月25日--下午3:39:15
*/
public class FlightManager {
	private Session session;
    private Transaction transaction;
    private Query query;
    
    public void saveFlight(Flight flight){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(flight);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();       
        }
        HibernateSessionFactory.closeSession();    
    }
    
    public void updateFlight(Flight flight)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(flight);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
    public void deleteFlight(String  flightNum)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(flightNum);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
  
    public Flight getFlight(String flightNum)
    {
        session=HibernateSessionFactory.getSession();
        Flight fl=(Flight)session.get(Flight.class, flightNum);
        HibernateSessionFactory.closeSession();
        return fl;
    }
    
   /**
    * 查询所有航班信息
    * @param pageNumber
    * @return
    */
    public List<Flight> allFlights(int pageNumber){
        List<Flight> allFlights=new ArrayList<Flight>();
        String hql="from Flight as flights";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allFlights=query.list();
        HibernateSessionFactory.closeSession();
        return allFlights;
    }
   /**
    * 按航班号查询
    * @param flightNum
    * @return
    */
   public Flight findFlight(String flightNum)
   {
       session =  HibernateSessionFactory.getSession();
       Query query = (Query) session.createQuery("from Flight  where flightNum = '"+flightNum+"'");
       Flight flight = (Flight) query.uniqueResult();
       HibernateSessionFactory.closeSession();
       return flight;
   }
   
   /**
    * 按出发地址和达到地址查询航班
    * @param flightNum
    * @return
    */
   public List<Flight> findFlightbyAddress(Trace trace,int pageNum)
   {
	   List<Flight> allFlights=new ArrayList<Flight>();
       session =  HibernateSessionFactory.getSession();
       Query query = (Query) session.createQuery("from Flight where  formCity =  '"+ trace.fromCity 
    		   +"'and arivCity = '"+trace.arivCity+ "' ");
       query.setFirstResult((pageNum-1)*10);
       query.setMaxResults(10);
       allFlights=query.list();
       HibernateSessionFactory.closeSession();
       return allFlights;
   }
   
  /**
   * 插入单条航班信息
   * @param flight
   * @return
   * @throws SQLException
   */
   public boolean InsertFlight(Flight flight) throws SQLException {
       String sql = MessageFormat.format("insert into FLIGHTS "
       		+ "values(''{0}'',''{1}'',''{2}'',{3})",flight.getFlightNum(),
       		flight.getFromCity(),flight.getArivCity(),flight.getNumSeats());
       System.out.println("语句检查："+sql);
       NativeQuery query = session.createSQLQuery(sql); 
       Transaction tx=session.beginTransaction();
       int result=query.executeUpdate(); 
       try{ 
    	   session.flush();
    	   tx.commit();} 
       catch(Exception e) { 
    	 if(tx!=null) tx.rollback(); 
    	 }
       finally { 
    	   session.close (); 
    	   }    
       if (result!=0){
           return true;
       }
       return false;
   }

	/**
	 * 批量插入航班信息
	 * @param flights
	 * @return 插入失败列表
	 */
	public List<Flight> InsertFlights(List<Flight> flights) {
		List<Flight> failed = new ArrayList<>();	
		for (Flight fl : flights) {
			try {
				InsertFlight(fl);
			} catch (SQLException e) {
				failed.add(fl);
				e.printStackTrace();
			}
		}
		return failed; 	
	}
   
    public int getFlightAmount(){
        int FlightAmount=0;
        session=HibernateSessionFactory.getSession();
        String hql="select count(*) from Flight as ft";
        query=session.createQuery(hql);
        long count =(Long) query.uniqueResult();
        FlightAmount=(int)count;
        HibernateSessionFactory.closeSession();
        return FlightAmount;
    }
    
    /*以下为对航班信息的操作*/ 
    public void saveSeatInfo(SeatInfo seatInfo){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(seatInfo);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();       
        }
        HibernateSessionFactory.closeSession();    
    }
    
    public void updateSeatInfo(SeatInfo seatInfo)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(seatInfo);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }

    
    /**
     * 通过航班号得到指定航班的详情
     * @param flightNum
     * @return
     */
    public List<SeatInfo> getSeatInfos(String flightNum){
        List<SeatInfo> allSeatInfo=new ArrayList<>();
        String hql="from SeatInfo where flightNum ='"+flightNum+"'";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        allSeatInfo=query.list();
        HibernateSessionFactory.closeSession();
        return allSeatInfo;
    }
    /**
     * 根据航班号和座位类型查找信息
     * @param flightNum
     * @param seatType
     * @return
     */
    public SeatInfo getSeatInfo(String flightNum,String seatType){
        String hql="from SeatInfo where flightNum ='"+flightNum+"' and seatType ='"+seatType+"'" ;
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        SeatInfo si=(SeatInfo) query.uniqueResult();
        HibernateSessionFactory.closeSession();
        return si;
    }
    
   /**
    * 查询所有航班信息
    * @param pageNumber
    * @return
    */
    public List<SeatInfo> allSeatInfo(int pageNumber){
        List<SeatInfo> allSeatInfo=new ArrayList<>();
        String hql="from SeatInfo as seatInfo";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allSeatInfo=query.list();
        HibernateSessionFactory.closeSession();
        return allSeatInfo;
    }
      
    public void saveSeat(Seat seat){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(seat);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();       
        }
        HibernateSessionFactory.closeSession();    
    }
    
    public void updateSeat(Seat seat)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(seat);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
    public void deleteSeat(String  seatId)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(seatId);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
    /**
     * 查看所有座位信息
     * @param pageNumber
     * @return
     */
    public List<Seat> allSeats(int pageNumber){
        List<Seat> allSeats=new ArrayList<>();
        String hql="from Seat as seats";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allSeats=query.list();
        HibernateSessionFactory.closeSession();
        return allSeats;
    }
    /**
     * 通过航班号和类型查找座位信息
     * @param fltnum
     * @param fltType
     * @param pageNumber
     * @return
     */
    public List<Seat> getSeats(String fltnum,String seatType,int pageNumber){
        List<Seat> seats=new ArrayList<>();
        String hql="from Seat as seats where flightNum='"
        +fltnum+"' and seatType ='"+seatType+"'";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        seats=query.list();
        HibernateSessionFactory.closeSession();
        return seats;
    }
    /**
     * 根据座位号和日期查找
     * @param fltnum
     * @param date
     * @return
     */
    public Seat getSeat(String seatId,String date){
        String hql="from Seat as seat where seatId='"
        +seatId+"' and flydate ='"+date+"'";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        Seat seat=(Seat) query.uniqueResult();
        HibernateSessionFactory.closeSession();
        return seat;
    }
       
}

