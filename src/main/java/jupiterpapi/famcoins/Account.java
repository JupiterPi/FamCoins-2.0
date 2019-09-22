package jupiterpapi.famcoins;

import org.springframework.data.annotation.Id;

public class Account {
    @Id private String id;
    private String userId;
    private String currency;
    private float amount;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getCurrency() {
        return currency;
    }

    public float getAmount() {
        return amount;
    }

    public void add(float amount) {
        this.amount -= amount;
    }
}
