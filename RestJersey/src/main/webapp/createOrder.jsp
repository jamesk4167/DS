<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Order</title>
</head>
<body>

<form action="webapi/myresource/createOrder" method="POST" >
           OrderID  <input type="number" name="orderID" /><br>
           CustomerID <input type="number" name="custID" /><br>
           Vehicle ID<input type="number" name="CarId" /><br>
                    <input type="submit" value="Submit" /><br>
</form>

</body>
</html>