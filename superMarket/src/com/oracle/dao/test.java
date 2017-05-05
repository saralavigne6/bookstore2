package com.oracle.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;







import com.oracle.entity.admin;
import com.oracle.entity.employee;
import com.oracle.entity.goods;
import com.oracle.entity.sales;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		admin ad = new admin();
//		ad.setUsername("王韦力");
//		ad.setUserpass("wangweili");
//		search_User search = new search_User();
//		System.out.println(search.search_Admin_Exit(ad));
		
		
//		search_Goods search = new search_Goods();
//		System.out.println(search.search_GoodsName_Exit("苹果"));
		
//		insert_GoodsData insert = new insert_GoodsData();
//		goods good = new goods();
//		good.setGoodsname("橘子");
//		good.setPrice(12.0f);
//		good.setDetail("甜");
//		good.setPicture("www.jpg");
//		System.out.println(insert.insert_Goods(good));
//		
		
//		search_Goods search = new search_Goods();
//		List<goods> list = search.searchAllGoods();
//		Iterator<goods> iterator =list.iterator();
//		if(iterator.hasNext()==false){
//			System.out.println("空");
//		}
//		for (goods goods : list) {
//			System.out.println(goods.getGoodsname());
//		}
		
//		insert_GoodsData update = new insert_GoodsData();
//		goods good = new goods();
//		good.setDetail("大");
//		good.setGoodsname("苹果");
//		System.out.println(update.update_Goods(good));
		
//		insert_GoodsData delete = new insert_GoodsData();
//		System.out.println(delete.delete_Goods("哈密瓜"));
		
//		System.out.println("库存告急商品");
//		search_Goods search = new search_Goods();
//		List<goods> list = new ArrayList<goods>();
//		list = search.search_GoodsNumber_Low(1);
//		for (goods good : list) {
//			System.out.println(good.getGoodsname());
//		}
		
//		
//		List<goods> list = new ArrayList<goods>();
//		search_Goods search = new search_Goods();
//		list = search.fuzzySearchGoods("子");
//		System.out.println(list.size());
//		Iterator iterator = list.iterator();
//		while(iterator.hasNext() == true){
//			goods good = new goods();
//			good = (goods)iterator.next();
//			System.out.println("商品名称:"+good.getGoodsname());
//		}
//		
		/*String str = new String("橘子");
		search_Goods search = new search_Goods();
		System.out.println(search.searchSingleGoods(str).getGoodsname());*/
		
		
//		EmployeeSales em = new EmployeeSales();
//		em.insertCheckData("王韦力", 10000);
		
//		EmployeeSales employ = new EmployeeSales();
//		List<sales> list = new ArrayList<sales>();
//		list = employ.searchSalesOrderPage(0, "wang");
//		for (sales sale : list) {
//			System.out.println(sale.getId());
//		}
		
//		EmployeeSales employ = new EmployeeSales();
//		float total ;
//		total = employ.SubEmployeeSales("wang");
//		System.out.println("销售金额:"+total);
		
//		search_User search = new search_User();
//		List<employee> list = new ArrayList<employee>();
//		list = search.searchEmployee(0, "");
//		for (employee em : list) {
//			System.out.println("用户名:"+em.getUsername());
//		}
		
//		search_User search = new search_User();
//		System.out.println(search.searchEmployeeExit("wang"));
		
//		search_User search = new search_User();
//		List<employee> list = new ArrayList<employee>();
//		list = search.searchEmployee1("wang");
//		for (employee em : list) {
//			System.out.println("用户名:"+em.getUsername());
//		}
		
//		search_User search = new search_User();
//		System.out.println(search.deleteEmployeeMessage("wangweili"));
		
		employee em = new employee();
		em.setUsername("xiaohu");
		em.setUserpass("xiaohu");
		em.setRealname("小虎");
		em.setTel("15736038709");
		em.setId("s018");
		em.setSalary(4000);
		search_User search = new search_User();
		System.out.println(search.insertEmployee(em));
		
		
	}

}
