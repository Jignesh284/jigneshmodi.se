package se.jigneshmodi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactForm
 */
@WebServlet("/ContactForm")
public class ContactForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		String contactNo =request.getParameter("contactNo");
		String email= request.getParameter("email");
		String msg= request.getParameter("message");
		String feedbackMsg = "Thank you for contacting us. We will return to you in a short while.You are valuable to us.";
		final String user= "jigneshmodi.developer@gmail.com";
		final String pass = "13@websiteKApassword";
		
		SendMail.send("jignesh.modi13@gmail.com","JigneshModi.se: "+name+" "+company , msg+"_"+contactNo, user, pass);
		SendMail.send(email, "JigneshModi.se: Response", feedbackMsg, user, pass);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("Your message is sucessfully delivered" );
		out.println("</html>");
		System.out.println(name+" - "+company+" - "+contactNo+" - "+email+" - "+msg);
		doGet(request, response);
	}

}
