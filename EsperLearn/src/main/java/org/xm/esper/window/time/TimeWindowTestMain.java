package org.xm.esper.window.time;

import org.xm.esper.window.length.Student;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class TimeWindowTestMain {
	// ???  is different from pdf ? 
	// why no output ?
	public static void main(String[] args)   {

		Configuration configuration = new Configuration();
		configuration
				.addEventTypeAutoName(Student.class.getPackage().getName());

		final EPServiceProvider epsprovider = EPServiceProviderManager
				.getDefaultProvider(configuration);

		String epl = "select * from Student.win:time_batch(4 sec)";

		EPStatement statement = epsprovider.getEPAdministrator().createEPL(epl);

		statement.addListener(new UpdateListener() {

			public void update(EventBean[] newEvents, EventBean[] oldEvents) {
				System.out.println(Thread.currentThread());
				try{
				System.out
						.println(newEvents.length + " -> " + newEvents[0].getUnderlying()+" -> "+ oldEvents);

				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});

		System.out.println(Thread.currentThread());
		new Thread(new Runnable() {
			
			public void run() {
				System.out.println(Thread.currentThread());
				for (int i = 0; i < 100; i++) {
					
					System.out.println("......");
					
					
					epsprovider.getEPRuntime().sendEvent(
							new Student(19 + i, "name _" + i));
					
				}
				
			}
		}).start();
	

	}

}
