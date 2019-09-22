package jupiterpapi.famcoins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactingService {
    @Autowired private AccountRepository accountRepo;
    @Autowired private TransactionRepository transRepo;

    public void createTransaction(Transaction trans) {
        Account from = accountRepo.findAccountById(trans.getFromId());
        Account to = accountRepo.findAccountById(trans.getToId());
    }
}
