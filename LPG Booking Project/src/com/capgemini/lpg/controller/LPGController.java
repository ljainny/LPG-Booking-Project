package com.capgemini.lpg.controller;

/*
 * LPGController servlet will dispatch control to different pages based upon the action parameter 
 */
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.lpg.dto.LPGStock;
import com.capgemini.lpg.exception.LPGException;
import com.capgemini.lpg.service.LPGService;
import com.capgemini.lpg.service.LPGServiceImpl;

/**
 * 
 * @author Smita Servlet implementation class LPGController
 */
@WebServlet("/LPGController")
public class LPGController extends HttpServlet {
	private static final long serialVersionUID = 6596448156198362042L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, 
		IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//System.out.println("action: "+action);
		RequestDispatcher view = null;
		LPGService service = new LPGServiceImpl();
		// Initial setting the session parameter to false
		HttpSession session = request.getSession(false);
		
		// action to fetch get the jsp page getStock.jsp
		if (action != null && action.equalsIgnoreCase("getStockPage")) {
			view = getServletContext().getRequestDispatcher("/pages/getStock.jsp");
			view.forward(request, response);
		}
		// action to show the list of LPGStock- getStock.jsp
		if (action != null && action.equalsIgnoreCase("getStock")) {
			try {
				String location = request.getParameter("location");
				ArrayList<LPGStock> stockList = service.getLPGStockDetails(location);
				request.setAttribute("stockList", stockList);
				//System.out.println("controller stocklist : "+stockList);
				view = getServletContext().getRequestDispatcher(
						"/pages/getStock.jsp");
				view.forward(request, response);
			} catch (LPGException e) {
				// dispatching control to error page
				request.setAttribute("errMsg", e.getMessage());
				view = getServletContext().getRequestDispatcher(
						"/pages/error.jsp");
				view.forward(request, response);
			}
		}

		// action to consumeNow which delegates to updateStock.jsp
		if (action != null && action.equalsIgnoreCase("consumeNow")) {
			String updatedBy = request.getParameter("updatedBy");
			int avQty = Integer.parseInt(request.getParameter("avQty"));
			// if an existing session is not there, then creating a new one.
			if (session == null) {
				session = request.getSession(true);
			}
			session.setAttribute("updatedBy", updatedBy);
			session.setAttribute("avQty", avQty);
			view = getServletContext().getRequestDispatcher("/pages/updateStock.jsp");
			view.forward(request, response);
		}
		// action to Update Stock which delegates to updateStock.jsp
		if (action != null && action.equalsIgnoreCase("Update Stock")) {
			String updatedBy = request.getParameter("updatedBy");
			int avQty = Integer.parseInt(request.getParameter("avQty"));
			int qtyConsume = Integer.parseInt(request.getParameter("qtyConsume"));
			int updatedQty=avQty-qtyConsume;
			try {
				int result = service.updateLPGStock(updatedBy, updatedQty);
				if(result>0){
					view = getServletContext().getRequestDispatcher(
							"/pages/success.jsp");
				}else{
					// dispatching control to error page
					request.setAttribute("errMsg", "Stock Updation Fail!!");
					view = getServletContext().getRequestDispatcher(
							"/pages/error.jsp");
				}
				view.forward(request, response);
			} catch (LPGException e) {
				// dispatching control to error page
				request.setAttribute("errMsg", e.getMessage());
				view = getServletContext().getRequestDispatcher(
						"/pages/error.jsp");
				view.forward(request, response);
			}
		}		
		
		// action to logout and invalidate the session
		if (action != null && action.equalsIgnoreCase("Logout")) {
			if (session != null) {
				session.invalidate();
				view = getServletContext().getRequestDispatcher("/index.jsp");
				view.forward(request, response);
			} else {
				request.setAttribute("errMsg", "Invalid Request");
				view = getServletContext().getRequestDispatcher(
						"/pages/error.jsp");
				view.forward(request, response);
			}
		}
	}

}
