package org.xm.esper.context.banktxn;

import java.util.ArrayList;
import java.util.List;

import org.xm.esper.property.mapped.MappedPropertyEvent;
import org.xm.esper.property.mapped.MappedPropertyUpdatelistener;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class TestContextOfBankTxn {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration
				.addEventTypeAutoName(BankTxn.class.getPackage().getName());

		EPServiceProvider epServiceProvider = EPServiceProviderManager
				.getDefaultProvider(configuration);

		// context

		String context1 = "create context SegmentedByCustomer partition by custId from BankTxn";

		// epl

		//String epl1 = "context SegmentedByCustomer select  context.id as id , context.name as cname, context.key1 as custId,  account, sum(amount) as amounts from BankTxn group by custId";

		String epl2 = "context SegmentedByCustomer select custId, sum(amount) as amounts from BankTxn group by custId";
		EPStatement context = epServiceProvider.getEPAdministrator().createEPL(
				context1);

		EPStatement statement = epServiceProvider.getEPAdministrator()
				.createEPL(epl2);

		statement.addListener(new UpdateListener() {

			public void update(EventBean[] newEvents, EventBean[] oldEvents) {
				try {
					EventBean event = newEvents[0];
					//  存在一个很大的问题,就是需要知道  property name.
					// test for epl1
					/* 
					 * System.out.println("context.id: "+ event.get("id") +", cname : "+event.get("cname") +", custId: " + event.get("custId")
							+ ", amounts: " + event.get("amounts"));*/
					// tests for epl2
					System.out.println("custId: " + event.get("custId")	+ ", amounts: " + event.get("amounts"));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		List<BankTxn> bankTxns = getBanktxns();
		for (BankTxn banktxn : bankTxns) {
			epServiceProvider.getEPRuntime().sendEvent(banktxn);

		}

	}

	private static List<BankTxn> getBanktxns() {

		List<BankTxn> results = new ArrayList<BankTxn>();

		results.add(new BankTxn(1, "001", 1));
		results.add(new BankTxn(1, "0011", 1));
		results.add(new BankTxn(2, "004", 1));
		results.add(new BankTxn(3, "003", 1));
		results.add(new BankTxn(6, "006", 1));
		results.add(new BankTxn(8, "0081", 1));

		return results;

	}
}
