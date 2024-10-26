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

@WebServlet("/updateReservationservlet")
public class updateReservationservlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to updateReservation.jsp
        request.getRequestDispatcher("updateReservation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int reservationId = Integer.parseInt(request.getParameter("reservation_id"));
        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        String status = request.getParameter("status");

        // Perform database operation to update reservation
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepu", "root", "webstudent");
            String query = "UPDATE reservation SET start_date = ?, end_date = ?, status = ? WHERE reservation_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, startDate);
            stmt.setString(2, endDate);
            stmt.setString(3, status);
            stmt.setInt(4, reservationId);
            int rowsAffected = stmt.executeUpdate();
            
            // Optionally, you can redirect to a success page after updating the reservation
            response.sendRedirect("updateSuccess.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
            // Optionally, you can forward to an error page if the update fails
            request.getRequestDispatcher("updateError.jsp").forward(request, response);
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
