package com.oracle.check;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckId {
	private String time;    //��ǰʱ��8λ
	private String randnumber;   //��ˮ��6λ
	private void CreateTime(){
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		time =sdf.format(date);
		
	}
	private void CreateRandNumber(){   //����6λ��ˮ��
		this.randnumber="";
		for(int i=0;i<6;i++){
			int num=(int)(Math.random()*10);
			this.randnumber+=num;
		}
		
	}
	
	public String CreateOrder(){   //��14λ
		this.CreateTime();
		this.CreateRandNumber();
		return (this.time+this.randnumber);
	}
}
