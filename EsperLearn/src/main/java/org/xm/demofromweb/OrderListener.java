package org.xm.demofromweb;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class OrderListener  implements UpdateListener{

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		
		EventBean  eventBean  = newEvents[0];
		try{
			System.out.println(": "+eventBean.get("avgPrice")); 
			/*
			 *  一个很重要的问题就是, 属性写错误了异常会被吃掉 , 所有你可能需要 认真处理这个问题.
			 */
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
}
