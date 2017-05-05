package com.oracle.dao;

import java.text.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.oracle.entity.customer;


public class CustomerDao {
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	private boolean tag = false;
	private String userpass = "";
	public boolean userRegist(customer cus){    //新增注册一个客户
		try{
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(customer.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(cus);
			tx.commit();    //提交事务
			tag = true;
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		return tag;
	}
	
	public boolean searchCusUsernameExit(String username){   //检查顾客账号是否已经存在
		try{
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(customer.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM customer as cus where cus.username =:name ";
			Query query = session.createQuery(hql);
			query.setString("name", username);
			ArrayList list = (ArrayList)query.list();
			Iterator iterator = list.iterator();
			if(iterator.hasNext())   //注册的账号已经存在
				tag = true;
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		return tag;
	}
	
	@SuppressWarnings("deprecation")
	public boolean userLogin(String username,String userpass){   //用户登录
		try{
			factory = new AnnotationConfiguration().configure().
					addAnnotatedClass(customer.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql="FROM customer as cus where cus.username =:name and cus.userpass =:pass";
			Query query = session.createQuery(hql);
			query.setString("name", username);
			query.setString("pass", userpass);
			ArrayList list = (ArrayList)query.list();
			Iterator iterator = list.iterator();
			if(iterator.hasNext())   //如果有该账号
				tag = true;
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		return tag;
	}
	
	public String backForgetPassword(String username,String tel){
		try{
			
			factory = new AnnotationConfiguration().configure().
					addAnnotatedClass(customer.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM customer as cus where cus.username =:name and cus.tel =:tels";
			Query query = session.createQuery(hql);
			query.setString("name", username);
			query.setString("tels", tel);
			ArrayList list = (ArrayList)query.list();
			Iterator iterator = list.iterator();
			if(iterator.hasNext()){
				customer cus = (customer)iterator.next();
				userpass = cus.getUserpass();
			}
		}catch(Exception e){
		
		}finally{
			session.close();
	}
		return userpass;
}
}
