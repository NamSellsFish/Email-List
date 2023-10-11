package nsf.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.Override;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/index.jsp";
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

            System.out.println("TestServlet Post ");
            log("TestServlet Post");

            // Validate the parameters
            String message;
            if (firstName == null || lastName == null || email == null || firstName.isEmpty() || lastName.isEmpty()
                    || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                url = "/index.jsp";
            } else {
                message = "";
                url = "/thanks.jsp";
            }

            req.setAttribute("user", user);
            req.setAttribute("message", message);

            //
            getServletContext().getRequestDispatcher(url).forward(req, res);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = "/index.jsp";
        System.out.println("TestServlet Get");
        log("TestServlet Get");
        getServletContext().getRequestDispatcher(url).forward(req, res);
    }
}