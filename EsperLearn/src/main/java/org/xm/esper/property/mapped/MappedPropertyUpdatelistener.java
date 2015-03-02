package org.xm.esper.property.mapped;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class MappedPropertyUpdatelistener  implements UpdateListener{

	public void update(EventBean[] newEvents, EventBean[] arg1) {

		EventBean eventBean = newEvents[0];
		
		System.out.println(eventBean.get("age") +" <-> "+eventBean.get("name"));
		
	}
	
	

}
