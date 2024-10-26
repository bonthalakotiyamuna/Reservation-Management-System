<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Reservation</title>
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
            max-width: 400px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
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
    <h2>Update Reservation</h2>
    <form action="updateReservationservlet" method="post">
        <label for="reservation_id">Reservation ID:</label><br>
        <input type="text" id="reservation_id" name="reservation_id"><br>
        <label for="start_date">Start Date:</label><br>
        <input type="date" id="start_date" name="start_date"><br>
        <label for="end_date">End Date:</label><br>
        <input type="date" id="end_date" name="end_date"><br>
        <label for="status">Status:</label><br>
        <select id="status" name="status">
            <option value="Pending">Pending</option>
            <option value="Confirmed">Confirmed</option>
            <option value="Cancelled">Cancelled</option>
        </select><br><br>
        <input type="submit" value="Update Reservation">
    </form>
</body>
</html>
