package museum;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "list":
				listTickets(request, response);
				break;
			case "delete":
				deleteTicket(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			default:
				listTickets(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookingId = request.getParameter("bookingId");
		try {
			if(bookingId==null)
				addBooking(request, response);
			else
				updateBooking(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 1. LIST all bookings
	private void listTickets(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Booking> bookingList = BookingDAO.getAllBookings();
		request.setAttribute("bookings", bookingList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

	// 2. DELETE a booking
	private void deleteTicket(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		BookingDAO.deleteBooking(bookingId);
		System.out.println("Booking deleted successfully.");
		response.sendRedirect("BookingController?action=list");
	}

	// 3. SHOW edit form for a booking
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		Booking existingBooking = BookingDAO.getBookingById(bookingId);
		request.setAttribute("booking", existingBooking);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editBooking.jsp");
		dispatcher.forward(request, response);
	}

	// 4. ADD a new booking
	private void addBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));//
		java.sql.Date date = java.sql.Date.valueOf(request.getParameter("date"));
		String session = request.getParameter("session");
		String guide = request.getParameter("guide");
		int general = Integer.parseInt(request.getParameter("generalQuantity"));
		int student = Integer.parseInt(request.getParameter("studentQuantity"));
		int senior = Integer.parseInt(request.getParameter("seniorQuantity"));
		int audio = Integer.parseInt(request.getParameter("audioQuantity"));
		int cafe = Integer.parseInt(request.getParameter("cafeQuantity"));

		Booking booking = new Booking();
		booking.setUserId(userId);
		booking.setDate(date);
		booking.setSession(session);
		booking.setGuide(guide);
		booking.setGeneralQuantity(general);
		booking.setStudentQuantity(student);
		booking.setSeniorQuantity(senior);
		booking.setAudioQuantity(audio);
		booking.setCafeQuantity(cafe);

		BookingDAO.addBooking(booking);
		System.out.println("Booking added successfully.");
		response.sendRedirect("BookingController?action=list");
	}

	// 5. UPDATE an existing booking
	private void updateBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		java.sql.Date date = java.sql.Date.valueOf(request.getParameter("date"));
		String session = request.getParameter("session");
		String guide = request.getParameter("guide");
		int general = Integer.parseInt(request.getParameter("generalQuantity"));
		int student = Integer.parseInt(request.getParameter("studentQuantity"));
		int senior = Integer.parseInt(request.getParameter("seniorQuantity"));
		int audio = Integer.parseInt(request.getParameter("audioQuantity"));
		int cafe = Integer.parseInt(request.getParameter("cafeQuantity"));

		Booking booking = new Booking();
		booking.setBookingId(bookingId);
		booking.setUserId(userId);
		booking.setDate(date);
		booking.setSession(session);
		booking.setGuide(guide);
		booking.setGeneralQuantity(general);
		booking.setStudentQuantity(student);
		booking.setSeniorQuantity(senior);
		booking.setAudioQuantity(audio);
		booking.setCafeQuantity(cafe);

		BookingDAO.updateBooking(booking);
		System.out.println("Booking updated successfully.");
		response.sendRedirect("BookingController?action=list");
	}
}