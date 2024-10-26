<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
   // Don't create if not existing
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("Login.html"); // Redirect to login if not logged in
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome, <%= user %>!</title>
    <style>
        /* Optional: Style your menu bar here */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #555;
        }

        .logout {
            float: right;
        }

        .welcome {
            float: left;
            padding: 14px 16px;
            color: white;
        }
    </style>
</head>
<body>
    <ul>
        <li class="welcome">Welcome, <%= user %>!</li>
        <li><a href="">Home</a></li>
        <li><a href="makeReservation.jsp">Make Reservations</a></li>
        <li><a href="CancelReservation.jsp">Cancel Reservation</a></li>
        <li><a href="updateReservation.jsp">Update Reservation</a></li>
        <li><a href="viewReservation.jsp">View Reservation</a></li>
        <li class="logout"><a href="LogoutServlet">Logout</a></li>
    </ul>
</body>
</html>
