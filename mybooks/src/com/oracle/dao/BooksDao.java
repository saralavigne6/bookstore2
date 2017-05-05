package com.oracle.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.oracle.entity.books;

public class BooksDao {
	private boolean tag = false;
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;

	public List<books> searchAllBooks() {    //搜寻所有的书籍
		ArrayList<books> list = null;
		try {
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM books");
			list = (ArrayList) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<books> searchPartBooks(){    //只找寻四个商品
		ArrayList<books> list = null;
		ArrayList<books> listPart = new ArrayList<books>();
		try {
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM books");
			list = (ArrayList) query.list();
			if(list.size() >=4){   //总商品大于4
				int i = 0;
				for (books b : list) {
					if(i == 4)
						break;
					listPart.add(b);
					i++;
				}
			}else{
				Iterator iterator = list.iterator();
				books boo = new books();
				if(iterator.hasNext()){
					System.out.println("有数据");
					boo = (books)iterator.next();
				}
				listPart.add(boo);
				listPart.add(boo);
				listPart.add(boo);
				listPart.add(boo);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listPart;
	}
	
	public books searchSingleBook(String booknumber){   //查询单个商品
		books book = null;
		ArrayList<books> list = null;
		try {
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(books.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM books where booknumber =:number");
			query.setString("number", booknumber);
			list = (ArrayList) query.list();
			for (books bo : list) {
				book = bo;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return book;
	}
	
}
