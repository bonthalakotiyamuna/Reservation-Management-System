<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cancel Reservation</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }

    h2 {
        color: #333;
    }

    form {
        margin-top: 20px;
    }

    input[type="text"], input[type="submit"] {
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: white;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <h2>Cancel Reservation</h2>
    
    <%-- Form to enter reservation ID for cancellation --%>
    <form action="CancelReservationservlet" method="post">
        Enter Reservation ID: <input type="text" name="reservation_id"><br>
        <input type="submit" value="Cancel Reservation">
    </form>
    <a href="Welcome.jsp">WELCOME</a>
</body>
</html>
