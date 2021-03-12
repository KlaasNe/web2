package domain.model;

public class Trade implements Comparable {
    private String nickname;
    private Offer myOffer;
    private Offer myNeed;
    private final int id;

    public Trade(String nickname, Offer myOffer, Offer myNeed) {
        this.nickname = nickname;
        this.myOffer = myOffer;
        this.myNeed = myNeed;
        this.id = hashCode();
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
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

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(Object o) {
        return 0; //TODO
    }
}
