<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Reservations</title>
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

        input[type="submit"] {
            padding: 10px 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        a {
            display: block;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Reservations</h2>
    <form action="ViewReservationServlet" method="get">
        <input type="submit" value="View Reservations">
    </form>
    <a href="Welcome.jsp">WELCOME</a>
</body>
</html>
