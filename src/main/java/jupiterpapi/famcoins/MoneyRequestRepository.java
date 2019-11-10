package jupiterpapi.famcoins;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MoneyRequestRepository extends MongoRepository<MoneyRequest, String> {
    public MoneyRequest findMoneyRequestById(String id);
    public List<MoneyRequest> findMoneyRequestsByCreatedById(String id);
    public List<MoneyRequest> findMoneyRequestsByGetMoneyFromId(String id);
}
