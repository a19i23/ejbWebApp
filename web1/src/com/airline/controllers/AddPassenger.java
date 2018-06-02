package com.airline.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Gender;
import com.airline.models.Passenger;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view  = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Passenger p;
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");		
		String dobString = request.getParameter("dob");
		String gender = request.getParameter("gender");
		
		validateInput(request, firstName, "firstNameError");
		validateInput(request, lastName, "lastNameError");
		validateInput(request, dobString, "dobError");
		
		System.out.println("First name: " + firstName);
		
		if (request.getAttribute("error")!=null && (boolean)request.getAttribute("error")) {
			
		} else {
			p = new Passenger();
			p.setFirstName(firstName);
			p.setLastName(lastName);
			
			Date dob;
			try {
				dob = getDateFromString(dobString);
				p.setDob(dob);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			p.setGender(Gender.valueOf(gender));
		}
		
	}

	private Date getDateFromString(String str) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
		Date date = df.parse(str);
		return date;	
	}

	private void validateInput(HttpServletRequest request, String attributeName, String errorName) {
		if (attributeName.length() == 0 ) {
			System.out.println(errorName.toString());
			request.setAttribute("error", true);
			request.setAttribute(errorName, true);
		}
	}

}
