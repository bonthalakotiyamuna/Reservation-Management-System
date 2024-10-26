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

@WebServlet("/CancelReservationservlet")
public class CancelReservationservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int reservationId = Integer.parseInt(request.getParameter("reservation_id"));

        // Perform database operation to cancel reservation
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepu", "root", "webstudent");
            String query = "DELETE FROM reservation WHERE reservation_id=?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, reservationId);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                // Reservation cancelled successfully
                response.sendRedirect("cancellationSuccess.jsp");
            } else {
                // Reservation not found or not cancelled
                response.sendRedirect("cancellationFailure.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
            // Redirect to error page if cancellation fails
            response.sendRedirect("cancellationFailure.jsp");
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the cancelReservation.jsp page
        request.getRequestDispatcher("/cancelReservation.jsp").forward(request, response);
    }
}
