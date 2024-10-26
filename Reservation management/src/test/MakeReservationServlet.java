package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakeReservationServlet")
public class MakeReservationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to makeReservation.jsp
        request.getRequestDispatcher("makeReservation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int customerId = Integer.parseInt(request.getParameter("customer_id"));
        String reservationDate = request.getParameter("reservation_date");
        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        String status = request.getParameter("status");

        // Perform database operation to insert reservation
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepu", "root", "webstudent");
            String query = "INSERT INTO reservation (customer_id, reservation_date, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, customerId);
            stmt.setString(2, reservationDate);
            stmt.setString(3, startDate);
            stmt.setString(4, endDate);
            stmt.setString(5, status);
            int rowsAffected = stmt.executeUpdate();
            
            // Optionally, you can redirect to a success page after making the reservation
            response.sendRedirect("reservationSuccess.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
            // Optionally, you can forward to an error page if the reservation fails
            request.getRequestDispatcher("reservationError.jsp").forward(request, response);
        } finally {
            // Close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
