

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.dao.CourseLecturerDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReassignLec
 */
@WebServlet("/ReassignLec")
public class ReassignLec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReassignLec() {
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
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		int newlecturerID = Integer.parseInt(request.getParameter("lecturer"));
		int defaultLecID = Integer.parseInt(request.getParameter("defaultLecID"));
		
		if(defaultLecID == 0) {
			int i = CourseLecturerDAO.save(courseID, newlecturerID);
		}
		else {
			CourseLecturerDAO.UpdateCourseLecturer(courseID, defaultLecID, newlecturerID);
		}
		
		response.sendRedirect("admincourse.jsp");
	}

}
