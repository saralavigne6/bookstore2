package com.oracle.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.oracle.entity.books;
import com.oracle.entity.goods;

public class insert_GoodsData {
	private boolean tag = false;
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	public boolean insert_Goods(books book){     //插入数据
		try{
			
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(book);     //保存数据
			tx.commit();
			return tag = true;
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return tag;
	}
	
	public boolean update_Goods(books book){
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			session.update(book);     //保存数据
			tx.commit();
			return tag = true;
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return tag;
	}
	
	public boolean delete_Goods(String booknumber){
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			books book = (books)session.get(books.class, booknumber.trim());
			session.delete(book);
			tx.commit();
			return tag = true;
		}catch(HibernateException e){
			System.out.println("出现异常");
		}finally{
			session.close();
		}
		return tag;
	}
	
}
