package ustc.zgq.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ustc.zgq.config.HibernateSessionFactory;
import ustc.zgq.entity.CarReservation;
import ustc.zgq.entity.FlightReservation;
import ustc.zgq.entity.HotelReservation;

/**
*@author created by zgq
*@date 2019年1月26日--下午5:10:09
*/
public class ReservationManager {
	
	private Session session;
    private Transaction transaction;
    private Query query;
    
    /**
     * 插入一个新的订单
     * @param fltresv
     */
    public void saveFltResv(FlightReservation fltresv){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(fltresv);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();       
        }
        HibernateSessionFactory.closeSession();    
    }
    
    public void updateFlightReservation(FlightReservation fr)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(fr);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
    public void deleteFlightReservation(FlightReservation  fr)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(fr);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    /**
     * 根据订单号得到订单信息
     * @param rk
     * @return
     */
    
    public FlightReservation getFlightReservation(String rk)
    {
        session=HibernateSessionFactory.getSession();
        FlightReservation fl=(FlightReservation)session.get(FlightReservation.class, rk);
        HibernateSessionFactory.closeSession();
        return fl;
    }
    
    /**
     * 查询所有的航班类订单
     * @param pageNumber
     * @return
     */
    public List<FlightReservation> allFltResv(int pageNumber){
        List<FlightReservation> allRs=new ArrayList<FlightReservation>();
        String hql="from FlightReservation as fr";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allRs=query.list();
        HibernateSessionFactory.closeSession();
        return allRs;
    }
  
    public int getFRVAmount(){
        int frvAmount=0;
        session=HibernateSessionFactory.getSession();
        String hql="select count(*) from FlightReservation as ft";
        query=session.createQuery(hql);
        long count =(Long) query.uniqueResult();
        frvAmount=(int)count;
        HibernateSessionFactory.closeSession();
        return frvAmount;
    }
     
    
    
    
    
    public void saveHtlRsev(HotelReservation hr){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(hr);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
           
        }
        HibernateSessionFactory.closeSession();    
    }
    
    public void updateHtlResv(HotelReservation hr)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(hr);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
    public void deleteHtlResv(HotelReservation  hr)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(hr);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    /**
     * 根据订单号得到订单信息
     * @param hr
     * @return
     */
    public HotelReservation getHtlResv(String hk)
    {
        session=HibernateSessionFactory.getSession();
        HotelReservation hr=(HotelReservation)session.get(HotelReservation.class, hk);
        HibernateSessionFactory.closeSession();
        return hr;
    }
    
    /**
     * 查询所有的酒店类订单
     * @param pageNumber
     * @return
     */
    public List<HotelReservation> allHtlresv(int pageNumber){
        List<HotelReservation> allRs=new ArrayList<HotelReservation>();
        String hql="from HotelReservation as fr";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allRs=query.list();
        HibernateSessionFactory.closeSession();
        return allRs;
    }
  
    public int getHtlresvAmount(){
        int hra=0;
        session=HibernateSessionFactory.getSession();
        String hql="select count(*) from HotelReservation as hra";
        query=session.createQuery(hql);
        long count =(Long) query.uniqueResult();
        hra=(int)count;
        HibernateSessionFactory.closeSession();
        return hra;
    }
    
    
    public void saveCarResv(CarReservation cr){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(cr);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();     
        }
        HibernateSessionFactory.closeSession();    
    }
    
    public void updateCarReservation(CarReservation cr)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(cr);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
    public void deleteCarReservation(CarReservation  cr)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(cr);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    /**
     * 根据订单号得好订单信息
     * @param rk
     * @return
     */
    
    public CarReservation getCarReservation(String rk)
    {
        session=HibernateSessionFactory.getSession();
        CarReservation fl=(CarReservation)session.get(CarReservation.class, rk);
        HibernateSessionFactory.closeSession();
        return fl;
    }
    
    /**
     * 查询所有的车辆类订单
     * @param pageNumber
     * @return
     */
    public List<CarReservation> allCarResv(int pageNumber){
        List<CarReservation> allRs=new ArrayList<CarReservation>();
        String hql="from CarReservation as cr";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allRs=query.list();
        HibernateSessionFactory.closeSession();
        return allRs;
    }
  
    public int getCRVAmount(){
        int frvAmount=0;
        session=HibernateSessionFactory.getSession();
        String hql="select count(*) from CarReservation as ft";
        query=session.createQuery(hql);
        long count =(Long) query.uniqueResult();
        frvAmount=(int)count;
        HibernateSessionFactory.closeSession();
        return frvAmount;
    }
        

}

