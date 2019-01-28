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
*@date 2019��1��25��--����3:39:15
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
    * ��ѯ���к�����Ϣ
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
    * ������Ų�ѯ
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
    * ��������ַ�ʹﵽ��ַ��ѯ����
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
   * ���뵥��������Ϣ
   * @param flight
   * @return
   * @throws SQLException
   */
   public boolean InsertFlight(Flight flight) throws SQLException {
       String sql = MessageFormat.format("insert into FLIGHTS "
       		+ "values(''{0}'',''{1}'',''{2}'',{3})",flight.getFlightNum(),
       		flight.getFromCity(),flight.getArivCity(),flight.getNumSeats());
       System.out.println("����飺"+sql);
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
	 * �������뺽����Ϣ
	 * @param flights
	 * @return ����ʧ���б�
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
    
    /*����Ϊ�Ժ�����Ϣ�Ĳ���*/ 
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
     * ͨ������ŵõ�ָ�����������
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
     * ���ݺ���ź���λ���Ͳ�����Ϣ
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
    * ��ѯ���к�����Ϣ
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
     * �鿴������λ��Ϣ
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
     * ͨ������ź����Ͳ�����λ��Ϣ
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
     * ������λ�ź����ڲ���
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

