package ie.gmit.sw.RestJersey;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.rmi.RMIService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws Exception 
     * @throws RemoteException 
     * @throws MalformedURLException 
     */
	@GET
	@Produces(MediaType.APPLICATION_XML)
    public List<Order> getIt() throws MalformedURLException, RemoteException, Exception {
    	
    	RMIService ds;
    	ds = (RMIService) Naming.lookup("rmi://127.0.0.1:1099/database");

    	
        return ds.read();
    }
	
	
	@POST
	@Path("deleteOrder")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void deleteOrder(@PathParam("orderID") int orderID) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		RMIService ds;
		
		ds = (RMIService) Naming.lookup("rmi://127.0.0.1:1099/database");
		
		ds.deleteOrder(orderID);
	}
	

	@PUT
	@Path("updateOrder")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateOrder(@PathParam("orderID") int orderID) throws MalformedURLException, RemoteException, Exception {
		RMIService ds;
		ds = (RMIService) Naming.lookup("rmi://127.0.0.1:1099/database");
		
		ds.UpdateOrder(orderID);
	}
	
	@POST
	@Path("createOrder")
	@Consumes(MediaType.APPLICATION_XML)
	public void createOrder(Order o) throws SQLException, Exception {
		RMIService ds;
		ds = (RMIService) Naming.lookup("rmi://127.0.0.1:1099/database");
		try {
			ds.createOrder(o);
			
		}catch (RemoteException e){
			System.out.println("error:" + e);
		}
	}
}
