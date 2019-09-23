package jupiterpapi.famcoins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TransactingService {
    @Autowired private AccountRepository accountRepo;
    @Autowired private TransactionRepository transRepo;

    public Transaction createTransaction(Transaction trans) {
        Account from = accountRepo.findAccountById(trans.getFromId());
        Account to = accountRepo.findAccountById(trans.getToId());
        float amount = trans.getAmount();

        from.subtract(amount);
        to.add(amount);
        transRepo.save(trans);
        //accountRepo.save(from); 
        //accountRepo.save(to);
        return trans;
    }

    public List<Transaction> getTransactionsByAccountId(String accountId) {
        // besser zweimal lesen und dannach zusammenführen
        
        List<Transaction> list = new ArrayList<Transaction>();
        for (Transaction trans : transRepo.findAll()) {
            if (trans.getFromId().equals(accountId) || trans.getToId().equals(accountId)) list.add(trans);
        }
        return list;
    }
}
