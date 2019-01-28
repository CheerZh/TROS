package ustc.zgq.dao;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import com.opensymphony.xwork2.ActionSupport;
import ustc.zgq.config.HibernateSessionFactory;
import ustc.zgq.entity.Customer;
import ustc.zgq.entity.Flight;
import ustc.zgq.entity.User;
import ustc.zgq.mytype.Trace;

/**
*@author created by zgq
*@date 2019年1月26日--上午3:16:48
*/
public class CustomerManager extends ActionSupport{
	private Session session;
    private Transaction transaction;
    private Query query;
    public void saveCustomer(Customer customer){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
           
        }
        HibernateSessionFactory.closeSession();    
    }
    public void updateUser(Customer customer)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(customer);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    public void deleteCustomer(String customerId)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(customerId);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    
//    /**
//     * 通过id查找旅客
//     * @param customerId
//     * @return
//     */
//    public Customer getCustomer(String customerId)
//    {
//        session=HibernateSessionFactory.getSession();
//        Customer customer=(Customer)session.get(Customer.class, customerId);
//        HibernateSessionFactory.closeSession();
//        return customer;
//    }
    
    /**
     * 通过id查找旅客
     * @param name
     * @return
     */
    public Customer getCust(String custId)
    {
        session =  HibernateSessionFactory.getSession();
        Query query = (Query) session.createQuery("from Customer as custs where custId =  '"+custId+"'");
        Customer cust = (Customer) query.uniqueResult();
        HibernateSessionFactory.closeSession();
            return cust;
    }
    

    public List<Customer> allCustomers(int pageNum){
        List<Customer> allCustomers=new ArrayList<Customer>();
        String hql="from Customer as customers";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNum-1)*4);
        query.setMaxResults(4);
        allCustomers=query.list();
        HibernateSessionFactory.closeSession();
        return allCustomers;
    }
 
   public Customer getCustomer1(String name)
   {
       session =  HibernateSessionFactory.getSession();
       Query query = (Query) session.createQuery("from Customer as customers where customerName =  '"+name+"'");
       Customer customer = (Customer) query.uniqueResult();
       HibernateSessionFactory.closeSession();
           return customer;
   }
   
   
public boolean InsertCustomer(Customer customer) throws SQLException {
       String sql = MessageFormat.format("insert into USERSACCOUNT "
       		+ "values(''{0}'',''{1}'',''{2}'',''{3}'',{4})",customer.getCustId(),
       		customer.getCustName(),customer.getPhoneNum(),customer.getAge(),customer.getGender());
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
}
