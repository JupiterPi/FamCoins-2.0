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
        return transRepo.save(trans);
    }

    @GetMapping("/transaction/{accountId}")
    public List<Transaction> getTransactionsByAccountId(@PathVariable String accountId) {
        return transRepo.findTransactionByAccountId(accountId);
    }
}