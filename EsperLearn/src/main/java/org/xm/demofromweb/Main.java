package org.xm.demofromweb;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class Main {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();


		configuration.addEventTypeAutoName("org.xm.demofromweb");

		EPServiceProvider epService = EPServiceProviderManager
				.getDefaultProvider(configuration);


		EPStatement statement = epService.getEPAdministrator().createEPL("Select Avg(price) as avgPrice From OrderEvent.win:time(30 sec)");
		statement.addListener(new OrderListener());
		
		EPStatement statement2 = epService.getEPAdministrator().createEPL(
				"Select itemName? as itemName From OrderEvent");
		
		statement2.addListener(new OutputOrderItemListener());
		
		EPRuntime epRuntime = epService.getEPRuntime();
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			epRuntime.sendEvent(new OrderEvent((i + 1) * 10, "Name" + i));
		}
		
		long t2 = System.currentTimeMillis();
		
		System.out.println((t2-t1) +"ms");

	}

}
