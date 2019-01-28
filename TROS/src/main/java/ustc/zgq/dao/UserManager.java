package ustc.zgq.dao;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ustc.zgq.config.HibernateSessionFactory;
import ustc.zgq.entity.User;

/**
*@author created by zgq
*@date 2019��1��24��--����1:14:08
*/
public class UserManager {
	private Session session;
    private Transaction transaction;
    private Query query;
    
    /**
     * ����
     * @param user
     */
    public void saveUser(User user){
        session =HibernateSessionFactory.getSession();
        try{
            transaction =session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();    
        }
        HibernateSessionFactory.closeSession();    
    }
    /**
     * ����
     * @param user
     */
    public void updateUser(User user)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    /**
     * ɾ��
     * @param uid
     */
    public void deleteUser(String  uid)
    {
        session=HibernateSessionFactory.getSession();
        try{
            transaction=session.beginTransaction();
            session.delete(uid);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HibernateSessionFactory.closeSession();
    }
    /**
     * ͨ����ֵ��ȡ�û�
     * @param userId
     * @return
     */
    public User getUser(int userId)
    {
        session=HibernateSessionFactory.getSession();
        User user=(User)session.get(User.class, userId);
        HibernateSessionFactory.closeSession();
        return user;
    }
    /**
     * ��ѯ�����û�
     * @param pageNumber
     * @return
     */
    public List<User> allUsers(int pageNumber){
        List<User> allUsers=new ArrayList<User>();
        String hql="from User as users";
        session=HibernateSessionFactory.getSession();
        query=session.createQuery(hql);
        query.setFirstResult((pageNumber-1)*10);
        query.setMaxResults(10);
        allUsers=query.list();
        HibernateSessionFactory.closeSession();
        return allUsers;
    }
   /**
    * �����û��������û� 
    * @param m
    * @return
    */
   public User getUser1(String name)
   {
       session =  HibernateSessionFactory.getSession();
       Query query = (Query) session.createQuery("from User as users where userName =  '"+name+"'");
       User user = (User) query.uniqueResult();
       HibernateSessionFactory.closeSession();
           return user;
   }
   
   /**
    * ��¼��֤
    * @param user
    * @return
    */
   public User Login(User user){
	   User u=null;
       if(user.getUserId()!=null && user.getPassWord()!=null){
       session =  HibernateSessionFactory.getSession();
       query = (Query) session.createQuery("from User as users where userId = '"+user.getUserId()+"'");
        u= (User) query.uniqueResult();
       }
       return u;
       }
   
   /**
    * �û�ע��
    * @param user
    * @return
 * @throws SQLException 
    */
   public boolean Register(User user) throws SQLException{
    if(user.getUserId()!=null && user.getPassWord()!=null && user.getUserName()!=null){
    session =  HibernateSessionFactory.getSession();
    query = (Query) session.createQuery("from User as users where userId = '"+user.getUserId()+"'");
    User u = (User) query.uniqueResult();
    //�û�Id�����ڣ��������û�
    if (u == null && InsertUser(user)) {
        return true;
    		}
    }
    return false;
    }
   
   /**
    * �������û�
 * @param <T>
    * @param user
    * @return
    * @throws SQLException
    */
public boolean InsertUser(User user) throws SQLException {
	if(user.getRole().equals("ODI")) {
		user.setPermission(1);
	}
	else if(user.getRole().equals("FLDB")) {
		user.setPermission(2);
	}
	else if(user.getRole().equals("HLDB")) {
		user.setPermission(3);
	}
	else  {
		user.setPermission(4);
	}
       String sql = MessageFormat.format("insert into USERSACCOUNT "
       		+ "values(''{0}'',''{1}'',''{2}'',''{3}'',{4})",user.getUserId(),
       		user.getUserName(),user.getPassWord(),user.getRole(),user.getPermission());
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
}

