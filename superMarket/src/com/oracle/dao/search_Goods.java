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
import com.oracle.entity.employee;
import com.oracle.entity.goods;

public class search_Goods {
	private boolean tag = false;
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	public boolean search_GoodsName_Exit(String booknumber){
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM books as E where E.booknumber=:name");
			query.setString("name", booknumber);
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
			session.close();
		}
		return tag;
	}
	
	public List<books> searchAllGoods(int page){
		List<books> list=null;
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM books");
			query.setFirstResult(page*5);   //起始位置
			query.setMaxResults(5);    //最大条数
			list = query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	
	public List<goods> searchAllGoods(){    //没有分页
		List<goods> list=null;
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(goods.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM goods");
			list = query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	
	public books searchSingleGoods(String bookname){   //查询单个商品
		//System.out.println("接收的商品名称:"+goodsname);
		List<books> list=null;
		books book = null;
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM books as book where book.booknumber =:name");
			query.setString("name", bookname);
			list = query.list();
			Iterator iterator = list.iterator();
			book = new books();
			if(iterator.hasNext()){
				book =(books)iterator.next();
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return book;
	}
	
	public List<books> search_GoodsNumber_Low(int page){
		List<books> list=null;
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM books as book where book.total <:number");
			query.setInteger("number", 10);
			query.setFirstResult(page*5);
			query.setMaxResults(5);
			list = query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public List<goods> fuzzySearchGoods(String goodsname){     //商品的模糊查询
		List<goods> list=null;
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(goods.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM goods as good where good.goodsname like :name");
			query.setString("name", "%"+goodsname+"%");
			list = query.list();
			System.out.println("查询得到的个数:"+list.size());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public List<goods> placeOrder(String []str){    //下订单
		List<goods> list=null;
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(goods.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			for (String string : str) {
				Query query = session.createQuery("FROM goods as good where good.goodsname =:name");
				query.setString("name", string);
				List<goods> list1=null;
				list1 = query.list();
				goods good = new goods();
				good = (goods)list1.iterator().next();
				System.out.println(good.getGoodsname());
				list.add(good);
			}
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
}
