package org.xm.esper.property.indexed;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
/**
 *
 * @author XM - 2015年2月26日
 *
 */
public class IndexedpropertyUpdateListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] arg1) {

		EventBean eventBean = newEvents[0];

		System.out.println(eventBean.get("name1") + " <-> "
				+ eventBean.get("name2"));

	}

}
