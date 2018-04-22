package com.as.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.as.app.extend.BankInfo;

public class BankInfoServlet extends HttpServlet {
	public static final String SsnNumberValidator = "^[0-9]{9}";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// step1
		BankInfo bankInfo = new BankInfo();
		String bank = request.getParameter("bank");
		String account = request.getParameter("account");
		String ssn = request.getParameter("ssn");
		bankInfo.setAccount(account);
		bankInfo.setBank(bank);
		bankInfo.setSsn(ssn);

		StringBuffer errors = new StringBuffer();
		if (isDataBlank(bank)) {
			errors.append("HRMS_R0022: Bank is a required Field.");
		}

		if (isDataBlank(account)) {
			errors.append("HRMS_R0023: Account is a required Field.");
		}
		if (isDataBlank(ssn)) {
			errors.append("HRMS_R0024: SSN is a required Field.");
		} else {
			if (ssn.matches(BankInfoServlet.SsnNumberValidator)) {
				System.out.println("Valid");
			} else {
				errors.append("HRMS_R0025: SSN should be only number.Please enter a valid SSN.");

			}

		}

		// 2a.validation
		if (isDataBlank(errors.toString())) {
			HttpSession ses = request.getSession();
			ses.setAttribute("binfo", bankInfo);
			PrintWriter out = response.getWriter();
			response.sendRedirect("jsp/output.jsp");

		} else {
			request.setAttribute("errors", errors.toString());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bankinfo.jsp");
			rd.forward(request, response);
		}

	}

	private boolean isDataBlank(String dataValue) {
		return dataValue == null || dataValue.trim().length() == 0;
	}

}
