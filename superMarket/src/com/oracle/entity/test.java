package com.oracle.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;








import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SessionFactory factory =null;
//		Session session = null;
//		Transaction tx = null;
//		factory = new AnnotationConfiguration().configure().addAnnotatedClass(employee.class).buildSessionFactory();
//		session = factory.openSession();
//		tx = session.beginTransaction();
//		try{
//			session = factory.openSession();
//			tx = session.beginTransaction();
//			List list = session.createQuery("FROM employee").list();
//			for(Iterator iterator = list.iterator();iterator.hasNext();){
//				employee em = (employee)iterator.next();
//				System.out.println(em.getUserpass());
//			}
//			tx.commit();
//		}catch(HibernateException e){
//			e.printStackTrace();
//		}finally{
//			session.close();
//		}
//		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = null;
//		tx = session.beginTransaction();
//		try {
//			tx= session.beginTransaction();
//			String hql = "select * from employee em where em.username= 'wang'";
//			
//			List list=null;
//			list = session.createQuery(hql).list();
//			if(list == null){
//				System.out.println("空");
//			}
//			Iterator iterator = list.iterator();
//			tx.commit();
//			if(iterator.hasNext()){
//				System.out.println("连接查询成功");
//			}else{
//				System.out.println("没有数据");
//			}
//			
//			
//			session.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
		
				
		
		
	}

}
