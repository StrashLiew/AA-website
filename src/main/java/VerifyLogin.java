

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.dao.UserDAO;
import com.dao.bean.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyLogin
 */
@WebServlet("/VerifyLogin")
public class VerifyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyLogin() {
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
		
		String inputUsername = request.getParameter("inputUsername");
		String inputPassword = request.getParameter("inputPassword");
		int matchingUserID = UserDAO.verifyPassword(inputUsername, inputPassword);
		if(matchingUserID == -1) {
			response.sendRedirect("loginError.html");
			return;
		}
		HttpSession httpSession = request.getSession();
		User user = UserDAO.getUserByID(matchingUserID);
		httpSession.setAttribute("user_id", matchingUserID);
		int roleID = user.getRole_id();
		switch(roleID) {
		case 1:
			response.sendRedirect("student.jsp");
			break;
		case 2:
			response.sendRedirect("lecturer.jsp");
			break;
		case 3:
			response.sendRedirect("admin.jsp");
			break;
			
		}
	}

}
