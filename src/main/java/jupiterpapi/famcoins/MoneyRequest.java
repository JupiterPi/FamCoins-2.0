package jupiterpapi.famcoins;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class MoneyRequest {
    @Id private String id;
    private float amount;
    private String createdById;
    private String getMoneyFromId;
    private Date createdAt;
    private boolean answered;
    private boolean answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getGetMoneyFromId() {
        return getMoneyFromId;
    }

    public void setGetMoneyFromId(String getMoneyFromId) {
        this.getMoneyFromId = getMoneyFromId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void answer(boolean answer) {
        answered = true;
        this.answer = answer;
    }

    public boolean isAnswered() {
        return answered;
    }

    public boolean getAnswer() {
        return answer;
    }
}
