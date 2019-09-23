package jupiterpapi.famcoins;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    public Transaction findTransactionById(String id);
}
