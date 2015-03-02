package org.xm.esper.window.length;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class LengthWindowTestMain {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration
				.addEventTypeAutoName(Student.class.getPackage().getName());

		EPServiceProvider epServiceProvider = EPServiceProviderManager
				.getDefaultProvider(configuration);

		String epl = " select * from  Student.win:length(5)";

		EPStatement statement = epServiceProvider.getEPAdministrator()
				.createEPL(epl);

		statement.addListener(new UpdateListener() {
			// it will be run when a new event(message) enter.
			public void update(EventBean[] newEvents, EventBean[] oldEvents) {

				EventBean eb = newEvents[0];
				
				System.out.println(eb.getUnderlying());

			}
		});

		for (int i = 0; i < 6; i++) {
			epServiceProvider.getEPRuntime().sendEvent(
					new Student(19 + i, "name" + i));
		}

	}

}
