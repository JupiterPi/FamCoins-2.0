package jupiterpapi.famcoins;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoneyRequestRepository extends MongoRepository<MoneyRequest, String> {
    public MoneyRequest findMoneyRequestById(String id);
    public MoneyRequest findMoneyRequestByCreatedById(String id);
    public MoneyRequest findMoneyRequestByGetMoneyFromId(String id);
}
