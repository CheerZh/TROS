package ustc.zgq.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ustc.zgq.config.HibernateSessionFactory;
import ustc.zgq.entity.Car;


/**
*@author created by zgq
*@date 2019年1月25日--下午4:28:35
*/
public class CarManager {
	private Session session;
    private Transaction transaction;
    private Query query;
    
    public void saveCar(Car car){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(car);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();    
    }
    public void updateCar(Car car)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(car);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    public void deleteCar(String  carid)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(carid);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
  
    public Car getCar(String carid)
    {
        session=HibernateSessionFactory.getSession();
        Car car=(Car)session.get(Car.class, carid);
        HibernateSessionFactory.closeSession();
        return car;
    }
   /**
    * 查询所有车辆信息
    * @param pageNumber
    * @return
    */
    public List<Car> allCars(int pageNumber){
        List<Car> allCars=new ArrayList<Car>();
        String hql="from Car";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*6);
        query.setMaxResults(6);
        allCars=query.list();
        HibernateSessionFactory.closeSession();
        return allCars;
    }
  
    public int getCarAmount(){
        int carAmount=0;
        session=HibernateSessionFactory.getSession();
        String hql="select count(*) from Car as ft";
        query=session.createQuery(hql);
        long count =(Long) query.uniqueResult();
        carAmount=(int)count;
        HibernateSessionFactory.closeSession();
        return carAmount;
    }
}
