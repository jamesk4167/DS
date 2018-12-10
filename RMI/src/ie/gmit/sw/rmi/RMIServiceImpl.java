package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class RMIServiceImpl extends UnicastRemoteObject implements RMIService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmnnt;

	protected RMIServiceImpl() throws RemoteException, SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/car?useSSL=false", "root", "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");

		stmnnt = conn.createStatement();

		List<Order> List = new ArrayList<Order>();
		String strSelect = "select * from orders";

		ResultSet rset = stmnnt.executeQuery(strSelect);

		while (rset.next()) { 
			int OrderID = rset.getInt("OrderID");
			int cust = rset.getInt("CustID");
			int car = rset.getInt("CarId");
			
			Order s = new Order(OrderID,cust,car);
			List.add(s);
		}
		return List;
	}
	
	/*
	@Override
	public Order readSpec(int q) throws RemoteException, SQLException {
		System.out.println("In read");
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM orders WHERE OrderID = ?",q);
		stmnnt = conn.createStatement();

		List<Order> List = new ArrayList<Order>();
		//PreparedStatement strSelect = conn.prepareStatement("select * from orders WHERE orderID = ?",q);

		ResultSet rset = stmnnt.executeQuery(statement);

		while (rset.next()) { 
			int OrderID = rset.getInt("OrderID");
			Date Date = rset.getDate("Date");
			int cust = rset.getInt("CustID");
			int car = rset.getInt("CarId");
			
			Order s = new Order(OrderID, Date,cust,car);
			List.add(s);
		}
		return List;
	}*/
	

	@Override
	public void UpdateOrder(int i) throws RemoteException, SQLException {
		PreparedStatement stmnt = null;
		
		
		String sql = ("UPDATE orders" + 
				"SET OrderID = ? , CustID = ?, CarId = ?" + 
				"WHERE OrderID = ?");
		
		stmnt = conn.prepareStatement(sql);
		System.out.println("working");
		stmnt.executeUpdate();

		System.out.println("Record is Updated!");
		
	}

	@Override
	public void createOrder(Order o) throws Exception, SQLException {
		// TODO Auto-generated method stub
		stmnnt = conn.createStatement();
		
		System.out.println("Creating order ");
		
		System.out.println("working");
		String sql = "INSERT into orders (OrderId, CustID, CarId) "
				+ "VALUES('" + o.getOrderID() + "', " + o.getCust() + ", " + o.getCar() +");";
         
		stmnnt.execute(sql);
		
         
         System.out.println("Added to record");
		}

	@Override
	public void deleteOrder(Order o) throws RemoteException, SQLException {
		
		PreparedStatement stmnt = null;
		stmnnt = conn.createStatement();
		
		String sql = "DELETE FROM orders where OrderID = 1";
		
		stmnt = conn.prepareStatement(sql);
		System.out.println("working");
		stmnt.executeUpdate();

		System.out.println("Record is deleted!");
	}

}
