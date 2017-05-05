package com.oracle.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.oracle.entity.checks;

public class ChecksDao {
	private boolean tag = false;
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	public boolean addNewChecks(checks check){   //新增订单
		try{
			factory = new AnnotationConfiguration().configure().
					addAnnotatedClass(checks.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(check);
			tx.commit();
			tag = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return tag;
	}
	
	public List<checks> searchAllChecks(String username){    //查询对应用户的订单
		List<checks> list = new ArrayList<checks>();
		try{
//			if(factory != null){
//				System.out.println("factory不为空");
//			}
//			factory = new AnnotationConfiguration().configure().
//					addAnnotatedClass(checks.class).buildSessionFactory();
			factory = new AnnotationConfiguration().configure().
					addAnnotatedClass(checks.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM checks where username =:names";
			Query query = session.createQuery(hql);
			query.setString("names", username);
			list = (ArrayList)query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public boolean deleteChecksByCheckId(String checkid){
		try{
			factory = new AnnotationConfiguration().configure().
					addAnnotatedClass(checks.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			checks check = new checks();
			check = (checks)session.get(checks.class, checkid);
			session.delete(check);
			tx.commit();
			tag = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return tag;
	}
}
