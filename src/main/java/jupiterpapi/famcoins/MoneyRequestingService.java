package jupiterpapi.famcoins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyRequestingService {
    @Autowired private MoneyRequestRepository requestRepo;

    public void answer(String id, boolean answer) {
        requestRepo.findMoneyRequestById(id).answer(answer);
    }
}
