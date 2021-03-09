package domain.db;

import domain.model.Offer;
import domain.model.Trade;

import java.util.ArrayList;

public class TradeDB {
    private ArrayList<Trade> trades = new ArrayList<>();

    public TradeDB() {
        this.addTrade(new Trade(null, null));
        this.addTrade(new Trade(null, null));
        this.addTrade(new Trade(null, null));
    }

    public ArrayList<Trade> getAllTrades() {
        return trades;
    }

    private void addTrade(Trade trade) {
        if (trade.getMyOffer().getName() == null || trade.getMyOffer().getAmount() == 0) {
            throw new IllegalArgumentException("Don't beg for items >:(");
        } else {
            if (trade.getMyNeed().getName() == null || trade.getMyNeed().getAmount() == 0) {
                trade.setMyNeed(new Offer("", 0));
            }
            trades.add(trade);
        }
    }
}
