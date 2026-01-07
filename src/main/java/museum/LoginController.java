package museum;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		try {
		//create user object
		User user = new User();
		//retrieve and set email and password
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		//call login() in UserDAO
		user = UserDAO.login(user);
		//set user session if user is valid
		if (user.isLoggedIn()) {
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("email", user.getEmail());
		// Redirect to avoid resubmission
		response.sendRedirect("index.jsp");
		} else {
		//response.sendRedirect("invalidLogin.jsp");
		// Set error attribute and forward back to login.jsp
		request.setAttribute("errorMessage", "Invalid email or password.Please try again.");
		
		request.getRequestDispatcher("login.jsp").forward(request,
		
		response);
		}
		}
		catch (Throwable ex) {
		ex.printStackTrace();
		}
	}
}
