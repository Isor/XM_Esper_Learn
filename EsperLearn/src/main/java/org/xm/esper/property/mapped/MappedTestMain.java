package org.xm.esper.property.mapped;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class MappedTestMain {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.addEventTypeAutoName(MappedPropertyEvent.class.getPackage().getName());
		
		EPServiceProvider epServiceProvider = EPServiceProviderManager.getDefaultProvider(configuration);
		
		
		EPStatement statement  =  epServiceProvider.getEPAdministrator().createEPL(
				"select value('name') as name , kv('age') as age from MappedPropertyEvent ");
		
		statement.addListener(new MappedPropertyUpdatelistener());
		
		
		epServiceProvider.getEPRuntime().sendEvent(new MappedPropertyEvent());
		
		

	}

}
