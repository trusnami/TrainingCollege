package base.model;

import java.util.Date;

public class Settlelog extends SettlelogKey {
    private Date time;

    private Double amount;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}