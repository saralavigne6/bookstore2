package com.oracle.dao;

import java.util.ArrayList;
import java.util.List;

import com.oracle.control.UserRegist;
import com.oracle.entity.ShopCart;
import com.oracle.entity.checks;
import com.oracle.entity.customer;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CustomerDao cus = new CustomerDao();
//		customer cus1 = new customer();
//		cus1.setUsername("王韦力");
//		cus1.setUserpass("w1211");
//		cus1.setTel("15736038709");
//		cus1.setEmail("1211840085@qq.com");
//		System.out.println(cus.userRegist(cus1));
		
/*		System.out.println(cus.searchCusUsernameExit("王韦力"));*/
//		System.out.println(cus.userLogin("wangweili", "w1211"));
//		System.out.println("密码"+cus.backForgetPassword("wangweili", "15736038709"));
//		if(cus.backForgetPassword("fiasf", "fa2348").equals("")){
//			System.out.println("为空");
//		}
		
//		BooksDao book = new BooksDao();
//		System.out.println(book.searchAllBooks().get(0).getBookname());
//		ShopCart cart = new ShopCart();
//		ShopCartDao dao = new ShopCartDao();
//		cart.setBookname("oracle");
//		cart.setBooknumber("b001");
//		cart.setCounts(1);
//		cart.setPrice(23.6f);
//		cart.setUsername("wangweili");
//		System.out.println(dao.addBookToShopCart(cart));
		
		//System.out.println(dao.searchAllShopCartBooks("wangweili").get(0).getBookname());
		ChecksDao dao = new ChecksDao();
		List<checks> list = new ArrayList<checks>();
		list = dao.searchAllChecks("wangweili");
		System.out.println(list.size());
		for (checks ch : list) {
			System.out.println(ch.getAddress());
		}
		
	}

}
