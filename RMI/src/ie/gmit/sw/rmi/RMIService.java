package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Order;



public interface RMIService extends Remote {
	public List<Order> read() throws RemoteException, SQLException;

	public void UpdateOrder(int i) throws RemoteException, SQLException;
	
	public void deleteOrder(Order order) throws RemoteException, SQLException;
	

	public void createOrder(Order o) throws Exception, SQLException;

	

}
