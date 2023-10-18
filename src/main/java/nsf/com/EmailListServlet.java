package nsf.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.Override;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Servlet implementation class EmailListServlet
 */
@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		String url = "/index.jsp";
		//
		GregorianCalendar currentDate = new GregorianCalendar();
		req.setAttribute("currentDate", currentDate);
		int currentYear = currentDate.get(Calendar.YEAR);
		int currentMonth = currentDate.get(Calendar.MONTH) + 1;
		int currentDay = currentDate.get(Calendar.DATE);

		req.setAttribute("currentYear", currentYear);
		req.setAttribute("currentMonth", currentMonth);
		req.setAttribute("currentDay", currentDay);

		//
		String path = getServletContext().getRealPath("/WEB-INF/EmailList.txt");
		ArrayList<User> users = UserIO.getUsers(path);
		HttpSession session = req.getSession();
		session.setAttribute("users", users);
		String message = null;

		if (action == null) {
			action = "join";
		}
		if (action == "join") {
			url = "/index.jsp";
		} else if (action.equals("add")) {
			String email = req.getParameter("email");
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			User user = new User(email, firstName, lastName);
			System.out.println("Test printing EmailListServlet email to console: " + email);
			log("Test printing EmailListServlet email to log file: " + email);
			// Validate the parameters
			if (firstName == null || lastName == null || email == null || firstName.isEmpty() || lastName.isEmpty()
					|| email.isEmpty()) {
				message = "Please fill out all three text boxes.";
				url = "/index.jsp";
			} else {
				message = "";
				url = "/thanks.jsp";
			}
			session.setAttribute("user", user);
			req.setAttribute("user", user);
		}
		req.setAttribute("user", session.getAttribute("user"));
		req.setAttribute("message", message);
		//
		getServletContext().getRequestDispatcher(url).forward(req, res);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
