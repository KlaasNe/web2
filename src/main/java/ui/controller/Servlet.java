package ui.controller;

import domain.db.TradeDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/Servlet")
public class Servlet extends HttpServlet {
    private TradeDB tradeDB = new TradeDB();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = "overview.jsp";
        request.setAttribute("allTrades", tradeDB.getAllTrades());
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }
}
