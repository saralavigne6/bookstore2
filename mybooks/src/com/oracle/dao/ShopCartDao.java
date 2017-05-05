package com.oracle.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import com.oracle.entity.ShopCart;
import com.oracle.entity.books;

public class ShopCartDao {
	private boolean tag = false;
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	public boolean addBookToShopCart(ShopCart cart){    //商品加入购物车
		try {
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(ShopCart.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(cart);
			tx.commit();
			tag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tag;
	}
	
	public List<ShopCart> searchAllShopCartBooks(String username){   //查看购物车里所有商品
		List<ShopCart> list = new ArrayList<ShopCart>();
		list = null;
		try {
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(ShopCart.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM ShopCart where username =:name";
			Query query = session.createQuery(hql);
			query.setString("name", username);
			list = query.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public boolean updateBooksCount(String booknumber,int counts,int id){
		try {
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(ShopCart.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			ShopCart cart = 
                    (ShopCart)session.get(ShopCart.class, id); 
			cart.setCounts(counts);
			cart.setBooknumber(booknumber);
			session.update(cart);   //更新商品数量
			tx.commit();
			tag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tag;
	}
	
	public boolean updateBooksCount1(String booknumber,int counts,int id){
		try {
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(ShopCart.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			ShopCart cart = 
                    (ShopCart)session.get(ShopCart.class, id); 
			cart.setCounts(counts+cart.getCounts());
			cart.setBooknumber(booknumber);
			session.update(cart);   //更新商品数量
			tx.commit();
			tag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tag;
	}
	
	public int searchShopCartId(String booknumber){
		int id = -1;
		List<ShopCart> list = new ArrayList<ShopCart>();
		try {
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(ShopCart.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM ShopCart where booknumber =:name";
			Query query = session.createQuery(hql);
			query.setString("name", booknumber);
			list = query.list();
			for (ShopCart shop : list) {
				id = shop.getId();
			}
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}
	
	public boolean deleteSingleShopCart(int id){   //删除购物车里的单个商品
		try{
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(ShopCart.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			ShopCart cart = new ShopCart();
			cart = (ShopCart)session.get(ShopCart.class, id);
			session.delete(cart);
			tx.commit();
			tag = true;
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		return tag;
	}
}
