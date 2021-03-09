package domain.model;

public class Trade {
    private Offer myOffer;
    private Offer myNeed;

    public Trade(Offer myOffer, Offer myNeed) {
        this.myOffer = myOffer;
        this.myNeed = myNeed;
    }

    public Offer getMyOffer() {
        return myOffer;
    }

    public void setMyOffer(Offer myOffer) {
        this.myOffer = myOffer;
    }

    public Offer getMyNeed() {
        return myNeed;
    }

    public void setMyNeed(Offer myNeed) {
        this.myNeed = myNeed;
    }
}
