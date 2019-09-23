package jupiterpapi.famcoins;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id private String id;
    private float amount;
    private String createdById;
    private Date createdAt;
    private String fromId;
    private String toId;

    public String getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public String getCreatedById() {
        return createdById;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }
}
