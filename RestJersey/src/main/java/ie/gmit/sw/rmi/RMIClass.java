package ie.gmit.sw.rmi;

import java.rmi.Naming;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class RMIClass {
	
	private RMIService ch;

	public RMIClass() throws Exception {
		ch = (RMIService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");

	}

	// ============== READ ====================
	public List<Order> readData() throws Exception {
		return ch.read();
	}
	
	public void createOrder(Order o) throws Exception {
		ch.createOrder(o);
	}

	public void deleteOrder(Order o) throws Exception {
		ch.deleteOrder(o.getOrderID());
	}
	
	public void UpdateOrder(Order o) throws Exception {
		ch.UpdateOrder(o.getOrderID());
	}
	
}
