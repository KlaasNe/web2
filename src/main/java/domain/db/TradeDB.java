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

    public void removeTrade(Trade trade) {
        this.getAllTrades().remove(trade);
    }

//    public String getCheapest() {
//        return Collections.sort(this.getAllTrades())[0];
//    }
}
