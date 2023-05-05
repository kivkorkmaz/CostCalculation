package CostCalculation.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CostCalculation.Model.CostCalculate;

/**
 * Servlet implementation class CostCalculationServlet
 */
@WebServlet("/CostCalculationServlet")
public class CostCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CostCalculationServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] costNo = request.getParameterValues("CostNo");
		String name = request.getParameter("Name");
		String cost = request.getParameterValues("Cost");
		
		CostCalculate costCalculate = new CostCalculate();
		costCalculate.setCost(costNo);
	}

}
