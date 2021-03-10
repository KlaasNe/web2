package ui.controller;

import domain.db.TradeDB;
import domain.model.Offer;
import domain.model.Trade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private TradeDB tradeDB = new TradeDB();

    public Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = "home";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        String destination = null;
        switch (command) {
            case "home":
//                destination = home(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "add":
                destination = add(request, response);
                break;
            case "deleteConfirmation":
//                destination = getDeleteConfirmation();
                break;
            case "delete":
                destination = delete(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
//        Trade cheapest = db.getCheapest();
//        request.setAttribute("cheapest", cheapest);
        return "index.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
//        request.setAttribute("trades", tradeDB.getAllTrades());
        return "overview.jsp";
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String nickname = request.getParameter("nickname");
        String want = request.getParameter("want1");
        int wantAmount = Integer.parseInt(request.getParameter("want2"));
        String have = request.getParameter("have1");
        int haveAmount = Integer.parseInt(request.getParameter("have2"));
        Trade trade = new Trade(nickname, new Offer(want, wantAmount), new Offer(have, haveAmount));
        tradeDB.addTrade(trade);
        return "overview.jsp";
    }

    private String delete(HttpServletRequest request, HttpServletResponse response) {
//        String naam = request.getParameter("naam");
//        tradeDB.removeTrade(naam);
//        return overview(request, response);
        return null;
    }
}
