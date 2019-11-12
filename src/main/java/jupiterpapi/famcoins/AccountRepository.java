package jupiterpapi.famcoins;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    public Account findAccountById(String id);
    public Account[] findAccountsByUserId(String userId);
}
