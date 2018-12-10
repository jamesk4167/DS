<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>Please Enter the Order Id for the Order you would like to delete</p>
<form action="webapi/myresource/deleteOrder" method="POST" >
           OrderID  <input type="number" name="orderID" /><br>
                    <input type="submit" value="Submit" /><br>
                    </form>
</body>
</html>