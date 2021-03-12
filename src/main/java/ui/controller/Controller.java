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

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private TradeDB trades = new TradeDB();

    public Controller() {
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
        String destination;
        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "add":
                destination = add(request, response);
                break;
            case "deleteConfirmation":
                destination = getDeleteConfirmation();
                break;
            case "delete":
                destination = delete(request, response);
                break;
            case "search":
                destination = search(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("cheapest", trades.getCheapest());
        request.setAttribute("trades", trades.getAllTrades());
        return "index.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("trades", trades.getAllTrades());
        return "overview.jsp";
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String nickname = request.getParameter("nickname");
        String want = request.getParameter("want1");
        String have = request.getParameter("have1");
        if (have.equals("")) { return "add.jsp"; }
        int wantAmount;
        int haveAmount;
        try {
            wantAmount = Integer.parseInt(request.getParameter("want2"));
            haveAmount = Integer.parseInt(request.getParameter("have2"));
        } catch (NumberFormatException e) {
            if (request.getParameter("have2").equals("")) {
                return "add.jsp";
            } else if (request.getParameter("want2").equals("")) {
                haveAmount = Integer.parseInt(request.getParameter("have2"));
                wantAmount = 0;
            } else {
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
            return "add.jsp";
        }
        Trade trade = new Trade(nickname, new Offer(have, haveAmount), new Offer(want, wantAmount));
        trades.addTrade(trade);
        return overview(request, response);
    }

    private String getDeleteConfirmation() {
        return "deleteConfirmation.jsp";
    }

    private String delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        trades.removeTrade(id);
        return overview(request, response);
    }

    private String search(HttpServletRequest request, HttpServletResponse response) {
        String tradeDir = request.getParameter("search-select");
        String item = request.getParameter("search-bar");
        if (tradeDir.equals("have")) {
            request.setAttribute("trades", trades.findTradesHaving(item));
        } else if (tradeDir.equals("want")) {
            request.setAttribute("trades", trades.findTradesWanting(item));
        }
        return "overview.jsp";
    }
}
