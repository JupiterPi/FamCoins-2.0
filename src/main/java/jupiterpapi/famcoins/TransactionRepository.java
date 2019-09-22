package jupiterpapi.famcoins;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    public Transaction findTransactionById(String id);
    public List<Transaction> findTransactionByAccountId(String accountId);
}
