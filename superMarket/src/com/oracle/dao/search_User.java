package com.oracle.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List; 


import com.oracle.entity.admin;
import com.oracle.entity.employee;
import com.oracle.entity.sales;
import com.oracle.hibernate.hibernate;

public class search_User {
	private SessionFactory factory = null;
	private Session session1 = null;
	private Transaction tx = null;
	private boolean tag=false;
	public boolean search_User_Exit(employee em){    //查找销售员是否存在
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(employee.class).buildSessionFactory();
			session1 = factory.openSession();
			tx = session1.beginTransaction();
			Query query = session1.createQuery("FROM employee as E where E.username=:user and E.userpass=:pass");
			query.setString("user", em.getUsername());
			query.setString("pass", em.getUserpass());
			List list = query.list();
			Iterator iterator = list.iterator();
			if(iterator.hasNext()==true){
				tag=true;
			}else{
				tag=false;
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session1.close();
		}
		return tag;
	}
	
	public boolean search_Admin_Exit(admin ad){     //查找管理员用户是否存在
		try{
			
			System.out.println(ad.getUsername());
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(admin.class).buildSessionFactory();
			session1 = factory.openSession();
			tx = session1.beginTransaction();
			Query query = session1.createQuery("FROM admin as E where E.username=:user and E.userpass=:pass");
			query.setString("user", ad.getUsername());
			query.setString("pass", ad.getUserpass());
			List list = query.list();
			Iterator iterator = list.iterator();
			if(iterator.hasNext()==true){
				tag=true;
			}else{
				tag=false;
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session1.close();
		}
		return tag;
	}
	
	public List<employee> searchEmployee(int page,String username){
		List<employee> list = new ArrayList<employee>();
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(employee.class).buildSessionFactory();
			session1 = factory.openSession();
			tx = session1.beginTransaction();
			String hql = "";
			if(username.equals("")){
				hql="FROM employee";
			}else{
				hql="FROM employee as em where em.username =:name";
			}
			Query query = session1.createQuery(hql);
			if(username.equals("") == false){
				query.setString("name", username);
			}
			query.setFirstResult(page*10);
			query.setMaxResults(10);
			list = query.list();
			session1.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean searchEmployeeExit(String username){
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(employee.class).buildSessionFactory();
			session1 = factory.openSession();
			tx = session1.beginTransaction();
			Query query = session1.createQuery("FROM employee as E where E.username=:user");
			query.setString("user", username);
			List<employee> list = query.list();
			Iterator iterator = list.iterator();
			if(iterator.hasNext()==true){
				tag=true;
			}else{
				tag=false;
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session1.close();
		}
		return tag;
	}
	
	
	public List<employee> searchEmployee1(String username){
		List<employee> list = new ArrayList<employee>();
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(employee.class).buildSessionFactory();
			session1 = factory.openSession();
			tx = session1.beginTransaction();
			String hql = "";
			hql="FROM employee as em where em.username =:name";
			Query query = session1.createQuery(hql);
			query.setString("name", username);
			list = query.list();
			session1.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean updateEmployeeMessage(employee employ){    //更改员工信息
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(employee.class).buildSessionFactory();
			session1 = factory.openSession();
			tx = session1.beginTransaction();
			employee employ1 = (employee)session1.get(employee.class, employ.getUsername()); 
			employ1.setUsername(employ.getUsername());
			employ1.setUserpass(employ.getUserpass());
			employ1.setId(employ.getId());
			employ1.setTel(employ.getTel());
			employ1.setRealname(employ.getRealname());
			employ1.setSalary(employ.getSalary());
			session1.update(employ1);
			tx.commit();
			tag = true;
		}catch(Exception e){
			
		}finally{
			session1.close();
		}
		return tag;
	}
	
	
	public boolean deleteEmployeeMessage(String username){   //解聘员工
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(employee.class).buildSessionFactory();
			session1 = factory.openSession();
			tx = session1.beginTransaction();
			employee employ1 = (employee)session1.get(employee.class,username); 
			session1.delete(employ1);
			tx.commit();
			tag = true;
		}catch(Exception e){
			
		}finally{
			session1.close();
		}
		return tag;
	}
	
	public boolean insertEmployee(employee em){    //新增员工
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(employee.class).buildSessionFactory();
			session1 = factory.openSession();
			tx = session1.beginTransaction();
			session1.save(em);
			tx.commit();
			tag = true;
		}catch(Exception e){
			
		}finally{
			session1.close();
		}
		return tag;
	}
	
}
