package org.xm.esper.property.indexed;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
/**
 * 测试 Esper 中对Indexed Property的访问
 *
 * @author XM - 2015年2月26日
 *
 */
public class IndexedTestMain {
	public static void main(String[] args) {

		Configuration configure = new Configuration();

		configure.addEventTypeAutoName(IndexedPropertyEvent.class.getPackage()
				.getName());
		EPServiceProvider epsProvider = EPServiceProviderManager
				.getDefaultProvider(configure);

		EPStatement statement = epsProvider
				.getEPAdministrator()
				.createEPL(
						"select name[0] as name1 , names[1] as name2 from IndexedPropertyEvent ");

		statement.addListener(new IndexedpropertyUpdateListener());

		epsProvider.getEPRuntime().sendEvent(new IndexedPropertyEvent());

	}

}
