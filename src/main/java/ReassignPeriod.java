

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.dao.CourseDAO;
import com.dao.CoursePeriodDAO;
import com.dao.PeriodDAO;
import com.dao.bean.Course;
import com.dao.bean.CoursePeriod;
import com.dao.bean.CoursePeriodID;
import com.dao.bean.Period;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReassignPeriod
 */
@WebServlet("/ReassignPeriod")
public class ReassignPeriod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReassignPeriod() {
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
		int newperiodID = Integer.parseInt(request.getParameter("period"));
		int defaultPeriodID = Integer.parseInt(request.getParameter("defaultPeriodID"));
		String location = request.getParameter("location");
		
		if(defaultPeriodID == newperiodID) {
			Course course = CourseDAO.getCourseByID(courseID);
			Period period = PeriodDAO.getPeriodByID(defaultPeriodID);
			CoursePeriodID cpID= new CoursePeriodID(course, period);
			CoursePeriod newCP = new CoursePeriod(cpID, location);
			CoursePeriodDAO.updateCoursePeriod(newCP);
		}		
		else if(defaultPeriodID == 0) {
			int i = CoursePeriodDAO.save(courseID, newperiodID, location);
		}
		else {
			CoursePeriodDAO.deleteCoursePeriod(defaultPeriodID, courseID);
			CoursePeriodDAO.save(courseID, newperiodID, location);
		}
		response.sendRedirect("timet.jsp");
	}

}
