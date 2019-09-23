package jupiterpapi.famcoins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="")
@RestController
public class Controller {
    @Autowired private UserRepository userRepo;
    @Autowired private AccountRepository accountRepo;
    @Autowired private TransactionRepository transRepo;
    @Autowired private TransactingService transService;
    @Autowired private MoneyRequestRepository requestRepo;
    @Autowired private MoneyRequestingService requestService;

    @GetMapping("/helloworld")
    public String helloworld() {
        return "Server is working well! ;)";
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return accountRepo.save(account);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return userRepo.findUserById(id);
    }

    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestBody Transaction trans) {
        return transService.createTransaction(trans);
    }

    @GetMapping("/transaction/{accountId}")
    public List<Transaction> getTransactionsByAccountId(@PathVariable String accountId) {
        return transService.getTransactionsByAccountId(accountId);
    }

    @PostMapping("/moneyRequest")
    public MoneyRequest createMoneyRequest(@RequestBody MoneyRequest request) {
        return requestRepo.save(request);
    }

    @PostMapping("/answerMoneyRequest/{id}/{answer}")
    public void answerMoneyRequest(@PathVariable String id, @PathVariable String answer) {
        requestService.answer(id, (answer.equals("true")));
    }

    @GetMapping("/moneyRequest/{id}")
    public MoneyRequest getMoneyRequest(@PathVariable String id) {
        return requestRepo.findMoneyRequestById(id);
    }
}