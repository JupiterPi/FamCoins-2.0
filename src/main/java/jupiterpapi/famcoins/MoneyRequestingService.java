package jupiterpapi.famcoins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoneyRequestingService {
    @Autowired private MoneyRequestRepository requestRepo;
    @Autowired private TransactionRepository transRepo;
    @Autowired private TransactingService transService;

    public List<MoneyRequest> getMoneyRequestsByAccountId(String accountId) {
        List<MoneyRequest> gotByCreatedById = requestRepo.findMoneyRequestsByCreatedById(accountId);
        List<MoneyRequest> gotByGetMoneyFromId = requestRepo.findMoneyRequestsByCreatedById(accountId);

        List<MoneyRequest> summary = new ArrayList<MoneyRequest>();
        summary.addAll(gotByCreatedById);
        summary.addAll(gotByGetMoneyFromId);

        return summary;
    }

    public void answer(String id, boolean answer) {
        MoneyRequest req = requestRepo.findMoneyRequestById(id);
        req.answer(answer);
        requestRepo.save(req);
        if (answer) {
            transService.createTransaction(new Transaction("0", req.getAmount(), req.getCreatedById(), req.getCreatedAt(), req.getGetMoneyFromId(), req.getCreatedById()));
        }
    }
}
