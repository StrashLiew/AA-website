

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.dao.StudentDAO;
import com.dao.bean.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
		String name = request.getParameter("name");
		int userid = Integer.parseInt(request.getParameter("userid"));
		String email = request.getParameter("email");
		int programmeid = Integer.parseInt(request.getParameter("programme"));
		String intake = request.getParameter("intake");
		
		Student newStudent = new Student(userid, name, email, programmeid,0, 0, intake);
		
		StudentDAO.create(newStudent);
		
		response.sendRedirect("viewstudent.jsp");
	}

}
