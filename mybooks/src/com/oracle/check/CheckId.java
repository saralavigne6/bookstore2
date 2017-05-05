package com.oracle.check;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckId {
	private String time;    //当前时间8位
	private String randnumber;   //流水号6位
	private void CreateTime(){
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		time =sdf.format(date);
		
	}
	private void CreateRandNumber(){   //产生6位流水号
		this.randnumber="";
		for(int i=0;i<6;i++){
			int num=(int)(Math.random()*10);
			this.randnumber+=num;
		}
		
	}
	
	public String CreateOrder(){   //共14位
		this.CreateTime();
		this.CreateRandNumber();
		return (this.time+this.randnumber);
	}
}
