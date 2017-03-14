package base.model;

public class Card {
    private String cardnumber;

    private Integer traineeid;

    private String phonenumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber == null ? null : cardnumber.trim();
    }

    public Integer getTraineeid() {
        return traineeid;
    }

    public void setTraineeid(Integer traineeid) {
        this.traineeid = traineeid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }
}