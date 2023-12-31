

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.dao.UserDAO;
import com.dao.bean.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String inputUsername = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		int inputRoleId = Integer.parseInt(request.getParameter("roleID"));
		String profileImage = request.getParameter("profileImage");
		
		User newUser = new User(inputUsername, inputPassword, inputRoleId, profileImage);
		
		UserDAO.create(newUser);
		
		response.sendRedirect("userList.jsp");
	}

}
