<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Make Reservation</title>
    <style>
        /* General styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        /* Form styling */
        form {
            width: 50%;
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form input[type="text"],
        form input[type="submit"] {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 10px;
            width: 100%;
            box-sizing: border-box;
        }

        form input[type="submit"] {
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }

        form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        form ::-webkit-input-placeholder {
            color: #aaa;
        }

        form :-moz-placeholder { /* Firefox 18- */
            color: #aaa;
        }

        form ::-moz-placeholder {  /* Firefox 19+ */
            color: #aaa;
        }

        form :-ms-input-placeholder {
            color: #aaa;
        }

        /* Footer styling */
        .footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
    </style>
</head>
<body>
    <h2>Make Reservation</h2>
    
    <form action="MakeReservationServlet" method="post">
        Customer ID: <input type="text" name="customer_id"><br>
        Reservation Date: <input type="text" name="reservation_date" placeholder="YYYY-MM-DD"><br>
        Start Date: <input type="text" name="start_date" placeholder="YYYY-MM-DD"><br>
        End Date: <input type="text" name="end_date" placeholder="YYYY-MM-DD"><br>
        Status: <input type="text" name="status"><br>
        
        <input type="submit" value="Submit Reservation">
    </form>
    
    <a href="Welcome.jsp">WELCOME</a>
</body>
</html>
