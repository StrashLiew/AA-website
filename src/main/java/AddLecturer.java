

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.dao.LecturerDAO;
import com.dao.StudentDAO;
import com.dao.bean.Lecturer;
import com.dao.bean.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLecturer
 */
@WebServlet("/AddLecturer")
public class AddLecturer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLecturer() {
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
		int departmentid = Integer.parseInt(request.getParameter("department"));
		String intake = request.getParameter("intake");
		
		Lecturer newLecturer = new Lecturer(userid, name, email, departmentid, intake);
		
		LecturerDAO.create(newLecturer);
		
		response.sendRedirect("viewlecturer.jsp");
	}

}
