package org.xm.demofromweb;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class OutputOrderItemListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		// TODO Auto-generated method stub
		EventBean eventBean = newEvents[0];
		
		System.out.println(eventBean.get("itemName"));

	}

}
