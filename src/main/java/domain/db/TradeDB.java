package domain.db;

import domain.model.Offer;
import domain.model.Trade;

import java.util.*;

public class TradeDB {
    private ArrayList<Trade> trades = new ArrayList<>();

    public TradeDB() {
        this.trades = new ArrayList<Trade>();
    }

    public ArrayList<Trade> getAllTrades() {
        return trades;
    }

    public void addTrade(Trade trade) {
        if (trade.getMyOffer().getName() == null || trade.getMyOffer().getAmount() == 0) {
            throw new IllegalArgumentException("Don't beg for items >:(");
        } else {
            if (trade.getMyNeed().getName() == null || trade.getMyNeed().getAmount() == 0) {
                trade.setMyNeed(new Offer("", 0));
            }
            trades.add(trade);
        }
    }

    public Trade getTrade(int id) {
        for (Trade trade : this.getAllTrades()) {
            if (trade.getId() == id) {
                return trade;
            }
        }
        return null;
    }

    public void removeTrade(int id) {
        this.getAllTrades().removeIf(trade -> trade.getId() == id);
    }

    public Trade getCheapest() {
        this.getAllTrades().sort(Trade::compareTo);
        try {
            return this.getAllTrades().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public ArrayList<Trade> findTradesHaving(String item) {
        ArrayList<Trade> fTrades = new ArrayList<>();
        for (Trade trade : this.getAllTrades()) {
            System.out.println(trade.getMyNeed().getName());
            if (trade.getMyNeed().getName().toLowerCase().equals(item.toLowerCase())) {
                fTrades.add(trade);
            }
        }
        return fTrades;
    }

    public ArrayList<Trade> findTradesWanting(String item) {
        ArrayList<Trade> fTrades = new ArrayList<>();
        for (Trade trade : this.getAllTrades()) {
            if (trade.getMyOffer().getName().toLowerCase().equals(item.toLowerCase())) {
                fTrades.add(trade);
            }
        }
        return fTrades;
    }
}
