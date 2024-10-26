package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class Loginservlet extends HttpServlet {

    private static final String query = "SELECT * FROM logindetails WHERE roll_number = ? AND password = ?";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollNumber = request.getParameter("rollNumber");
        String password = request.getParameter("password");

        // Validate credentials from database
        boolean isValid = false;
		try {
			isValid = validateCredentials(rollNumber, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (isValid) {
            // Login successful
            HttpSession session = request.getSession(true); // Create session if not existing
            session.setAttribute("user", rollNumber);  // Store roll number in session
            session.setAttribute("user1", password);
            // Redirect to a welcome page or relevant resource
            response.sendRedirect("Welcome.jsp");  // Replace with your desired page
        } else {
            // Login failed
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<h2>Invalid roll number or password</h2>");
            out.println("<a href='Login.html'>Try Again</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private boolean validateCredentials(String rollNumber, String password) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Replace with your actual database connection details
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepu","root", "webstudent");
            stmt = connection.prepareStatement(query);
            stmt.setString(1, rollNumber);
            // Hash password before comparison (replace with your hashing logic)
            stmt.setString(2, password); 
            rs = stmt.executeQuery();

            return rs.next();  // Return true if a matching record is found
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
