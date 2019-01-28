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
import ustc.zgq.entity.Hotel;
import ustc.zgq.entity.Room;
import ustc.zgq.entity.RoomInfo;

/**
*@author created by zgq
*@date 2019年1月25日--下午4:20:43
*/
public class HotelManager {
	private Session session;
    private Transaction transaction;
    private Query query;
    
    public void saveHotel(Hotel hotel){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(hotel);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
           
        }
        HibernateSessionFactory.closeSession();    
    }
    public void updateHotel(Hotel hotel)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(hotel);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    public void deleteHotel(String  hotelName)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(hotelName);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
  /**
   * 根据酒店名称查询酒店
   * @param hotelName
   * @return
   */
    public Hotel getHotel(String hotelName)
    {
        session=HibernateSessionFactory.getSession();
        Hotel fl=(Hotel)session.get(Hotel.class, hotelName);
        HibernateSessionFactory.closeSession();
        return fl;
    }
   /**
    * 查询所有的酒店信息
    * @param pageNumber
    * @return
    */
    public List<Hotel> allHotels(int pageNumber){
        List<Hotel> allHotels=new ArrayList<Hotel>();
        String hql="from Hotel as hotel";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allHotels=query.list();
        HibernateSessionFactory.closeSession();
        return allHotels;
    }
  
    public int getHotelAmount(){
        int hotelAmount=0;
        session=HibernateSessionFactory.getSession();
        String hql="select count(*) from Hotel as ht";
        query=session.createQuery(hql);
        long count =(Long) query.uniqueResult();
        hotelAmount=(int)count;
        HibernateSessionFactory.closeSession();
        return hotelAmount;
    }
    
    /*以下为对Room的操作*/
    
    public void saveRoom(Room room){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(room);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
           
        }
        HibernateSessionFactory.closeSession();    
    }
    public void updateRoom(Room room)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(room);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
    public void deleteRoom(String  roomId)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(roomId);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }

    public Room getRoom(String roomId)
    {
        session=HibernateSessionFactory.getSession();
        Room room=(Room)session.get(Room.class, roomId);
        HibernateSessionFactory.closeSession();
        return room;
    }

    public List<Hotel> allRooms(int pageNumber){
        List<Hotel> allHotels=new ArrayList<Hotel>();
        String hql="from Room as room";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allHotels=query.list();
        HibernateSessionFactory.closeSession();
        return allHotels;
    }
  
    public int getRoomAmount(){
        int roomAmount=0;
        session=HibernateSessionFactory.getSession();
        String hql="select count(*) from Room as room";
        query=session.createQuery(hql);
        long count =(Long) query.uniqueResult();
        roomAmount=(int)count;
        HibernateSessionFactory.closeSession();
        return roomAmount;
    }
    
    
    /*以下为对RoomInfo表的相关操作*/ 
    
    public void saveRoomInfo(RoomInfo roomInfo){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(roomInfo);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
           
        }
        HibernateSessionFactory.closeSession();    
    }
    
    public void updateRoomInfo(RoomInfo roomInfo)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(roomInfo);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
    public void deleteRoomInfo(String  roomInfo)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(roomInfo);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
    public RoomInfo getRoomInfo(String hotelName)  //根据酒店名！
    {
        session=HibernateSessionFactory.getSession();
        RoomInfo roomInfo1=(RoomInfo)session.get(RoomInfo.class, hotelName);
        HibernateSessionFactory.closeSession();
        return roomInfo1;
    }
    
    public List<RoomInfo> allRoomInfo(int pageNumber){
        List<RoomInfo> allRoomInfo=new ArrayList<RoomInfo>();
        String hql="from RoomInfo as roomInfo";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allRoomInfo=query.list();
        HibernateSessionFactory.closeSession();
        return allRoomInfo;
    }
  
    public int getRoomInfoAmount(){
        int roomInfoAmount=0;
        session=HibernateSessionFactory.getSession();
        String hql="select count(*) from RoomInfo as ri";
        query=session.createQuery(hql);
        long count =(Long) query.uniqueResult();
        roomInfoAmount=(int)count;
        HibernateSessionFactory.closeSession();
        return roomInfoAmount;
    }
}

