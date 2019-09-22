package jupiterpapi.famcoins;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id private String id;
    private float amount;
    private Date createdAt;
    private String fromId;
    private String toId;

    public String getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }
}
