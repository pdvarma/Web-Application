package com.as.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.as.app.extend.ContactInfo;

public class ContactInfoServlet extends HttpServlet {
	public static final String CityNameValidator = "^[a-zA-Z.][a-zA-Z0-9\\w-_.]{1,15}$";
	public static final String PhoneNumberValidator = "^[0-9]{10}";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// step1
		ContactInfo contactInfo = new ContactInfo();
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		contactInfo.setAddress(address);
		contactInfo.setCity(city);
		contactInfo.setState(state);
		contactInfo.setCountry(country);
		contactInfo.setPhone(phone);

		StringBuffer errors = new StringBuffer();
		if (isDataBlank(address)) {
			errors.append("*Address ");
		}
		if (isDataBlank(city)) {
			errors.append("HRMS_R0017: Please specify City.<br/>");
		} else {
			if (city.matches(ContactInfoServlet.CityNameValidator)) {
				System.out.println("Valid");
			} else {
				errors.append(
						"HRMS_R0018: City can contain only letters, numbers, and Spaces, Hyphens (-), Underscores (_). Please enter a valid First Name.<br/>");

			}

		}

		if (isDataBlank(state)) {
			errors.append("HRMS_R0019: State is a required Field.<br/>");
		}
		if (isDataBlank(country)) {
			errors.append("HRMS_R0020: Country is a required Field.<br/>");
		}
		if (isDataBlank(phone)) {
			errors.append("HRMS_R0021: Country is a required Field.<br/>");
		} else {
			if (phone.matches(ContactInfoServlet.PhoneNumberValidator)) {
				System.out.println("Valid");
			} else {
				errors.append("HRMS_R0022: Phoone number comtains 10 digits.Please enter a valid Phone number");

			}

		}
		// 2a.validation
		if (isDataBlank(errors.toString())) {
			HttpSession ses = request.getSession();
			ses.setAttribute("cinfo", contactInfo);
			PrintWriter out = response.getWriter();
			response.sendRedirect("html/bankinfo.html");

		} else {
			request.setAttribute("errors", errors.toString());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/contactinfo.jsp");
			rd.forward(request, response);
		}

	}

	private boolean isDataBlank(String dataValue) {
		return dataValue == null || dataValue.trim().length() == 0;
	}

}
