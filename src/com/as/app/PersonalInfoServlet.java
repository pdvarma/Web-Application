package com.as.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.apex.assignments.Validations;
import com.as.app.extend.PersonalInfo;

//import assign.samples.MYSQLDBAccess;

/**
 * Servlet implementation class PersonalInfoServlet
 */
public class PersonalInfoServlet extends HttpServlet {
	public static final String FirstNameValidator = "^[a-zA-Z.][a-zA-Z0-9\\w-_.]{1,16}$";
	public static final String MiddleNameValidator = "^[a-zA-Z.][a-zA-Z0-9\\w-_.]{1,16}$";
	public static final String LastNameValidator = "^[a-zA-Z.][a-zA-Z0-9\\w-_.]{1,16}$";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// step1
		PersonalInfo personInfo = new PersonalInfo();
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String middleName = request.getParameter("middlename");
		String gender = request.getParameter("gender");
		personInfo.setFirstName(firstName);
		personInfo.setLastName(lastName);
		personInfo.setMiddleName(middleName);
		personInfo.setGender(gender);

		// step2 : validation

		StringBuffer errors = new StringBuffer();

		// First Name
		if (isDataBlank(firstName)) {
			errors.append("HRMS_R0009: Please specify First Name.<br/>");
		} else {
			if (firstName.matches(PersonalInfoServlet.FirstNameValidator)) {
				System.out.println("Valid");
			} else {
				errors.append(
						"HRMS_R0010: First Name must start with a letter. It can contain only letters, numbers, and Spaces, Hyphens (-), Underscores (_). Please enter a valid First Name.<br/>");
				errors.append(
						"HRMS_R0011: The First Name is less than 2 characters. Please Check and enter a valid First Name.<br/>");

			}

		}

		// Last Name
		if (isDataBlank(lastName)) {
			errors.append("HRMS_R0013: Please specify Last Name.");
		} else {
			if (lastName.matches(PersonalInfoServlet.LastNameValidator)) {
				System.out.println("Valid");
			} else {
				errors.append(
						"HRMS_R0014: Last Name must start with a letter. It can contain only letters, numbers, and Spaces, Hyphens (-), Underscores (_). Please enter a valid Last Name.<br/>");
				errors.append(
						"HRMS_R0015: The Last Name is less than 2 characters. Please Check and enter a valid Last Name.<br/>");

			}

		}

		// Middle Name
		if (isDataBlank(middleName)) {
			errors.append("HRMS_R0009: Please specify Middle Name.");
		} else {
			if (middleName.matches(PersonalInfoServlet.MiddleNameValidator)) {
				System.out.println("Valid");
			} else {
				errors.append(
						"HRMS_R0012: Middle Name must start with a letter. It can contain only letters, numbers, and Spaces, Hyphens (-), Underscores (_). Please enter a valid Middle Name.<br/>");
			}

		}

		if (isDataBlank(errors.toString())) {
			HttpSession ses = request.getSession();
			ses.setAttribute("pinfo", personInfo);
			PrintWriter out = response.getWriter();
			// response.sendRedirect("html/contactinfo.html");
			response.sendRedirect("jsp/output.jsp");

		} else {
			request.setAttribute("errors", errors.toString());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/personalinfo.jsp");
			rd.forward(request, response);
		}
	}

	private boolean isDataBlank(String dataValue) {
		return dataValue == null || dataValue.trim().length() == 0;
	}

}
