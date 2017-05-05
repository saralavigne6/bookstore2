package com.oracle.dao;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.oracle.entity.goods;
import com.oracle.entity.sales;

public class EmployeeSales {
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	private boolean tag = false;

	public boolean insertCheckData(String username, float totalMoney) {
		try {
			factory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(sales.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			sales sale = new sales();
			sale.setUsername(username);
			sale.setSalesmoney(totalMoney);
			// Calendar cal = new Calendar(); //构造方法为protected
			Date da = new Date();
			Format mat = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
			String time = mat.format(da);
			sale.setDates(time);
			session.save(sale);
			tx.commit();
			tag = true;
			session.close();
		} catch (Exception e) {

		}
		return tag;
	}
	
	
	public List<sales> searchSalesOrderPage(int page,String username){
		List<sales> list = new ArrayList<sales>();
		try{
		factory = new AnnotationConfiguration().configure().addAnnotatedClass(sales.class).buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		String hql = "";
		if(username.equals("")){
			hql="FROM sales";
		}else{
			hql="FROM sales as sale where sale.username =:name";
		}
		Query query = session.createQuery(hql);
		if(username.equals("") == false){
			query.setString("name", username);
		}
		query.setFirstResult(page*10);
		query.setMaxResults(10);
		list = query.list();
		session.close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}
	
	
	public boolean serachEmployeeSalesExit(String username){     //查找员工是否存在销售记录
		try{

		factory =  new AnnotationConfiguration().configure().addAnnotatedClass(sales.class).buildSessionFactory();
		session =  factory.openSession();
		tx = session.beginTransaction();
		List<sales> list = new ArrayList<sales>();
		Query query = session.createQuery("FROM sales as sale where sale.username =:name");
		query.setString("name", username);
		list = query.list();
		Iterator iterator = list.iterator();
		if(iterator.hasNext() == true){    //该员工销售存在销售记录
			tag = true;
		}else{
			tag = false;
		}
		session.close();
		}catch(Exception e){
			
		}
		return tag;
	}
	
	public float SubEmployeeSales(String username){    //获取员工销售金额
		float total = 0;
		try{
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(sales.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM sales as sale where sale.username =:name");
			query.setString("name", username);
			List<sales> list = new ArrayList<sales>();
			list = query.list();
			for (sales sa : list) {
				total+=sa.getSalesmoney();
			}
			session.close();
		}catch(Exception e){
			
		}
		return total;
	}
	
}
