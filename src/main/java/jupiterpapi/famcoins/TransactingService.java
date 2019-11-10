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
        accountRepo.save(from);
        accountRepo.save(to);
        return trans;
    }

    public List<Transaction> getTransactionsByAccountId(String accountId) {
        List<Transaction> gotByFromId = transRepo.findTransactionsByFromId(accountId);
        List<Transaction> gotByToId = transRepo.findTransactionsByToId(accountId);

        List<Transaction> summary = new ArrayList<Transaction>();
        summary.addAll(gotByFromId);
        summary.addAll(gotByToId);

        return summary;
    }
}
