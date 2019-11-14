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

    @GetMapping("/account/{userId}")
    public Account[] getAccountsByUserId(@PathVariable String userId) {
        return accountRepo.findAccountsByUserId(userId);
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

    @GetMapping("/namesMeta/{table}")
    public HeadingNameMetaData[] getHeadingNameMetaData(@PathVariable String table) {
        switch (table) {
            case "user":
                return new HeadingNameMetaData[]{
                        new HeadingNameMetaData("id", "ID"),
                        new HeadingNameMetaData("firstName", "First Name"),
                        new HeadingNameMetaData("lastName", "Last Name"),
                        new HeadingNameMetaData("password", "Password")};
            case "account":
                return new HeadingNameMetaData[]{
                        new HeadingNameMetaData("id", "ID"),
                        new HeadingNameMetaData("userId", "User-ID"),
                        new HeadingNameMetaData("currency", "Currency"),
                        new HeadingNameMetaData("amount", "Amount")
                };
            case "transaction":
                return new HeadingNameMetaData[]{
                        new HeadingNameMetaData("id", "ID"),
                        new HeadingNameMetaData("amount", "Amount"),
                        new HeadingNameMetaData("createdById", "Created by (ID)"),
                        new HeadingNameMetaData("createdAt", "Created at"),
                        new HeadingNameMetaData("fromId", "From (ID)"),
                        new HeadingNameMetaData("toId", "To (ID)")
                };
            case "moneyrequest":
                return new HeadingNameMetaData[]{
                        new HeadingNameMetaData("id", "ID"),
                        new HeadingNameMetaData("amount", "Amount"),
                        new HeadingNameMetaData("createdById", "Created by (ID)"),
                        new HeadingNameMetaData("getMoneyFrom", "Get money from (ID)"),
                        new HeadingNameMetaData("createdAt", "Created at"),
                        new HeadingNameMetaData("answered", "Answered"),
                        new HeadingNameMetaData("answer", "Answer")
                };
            default:
                return null;
        }
    }

    @GetMapping("/removementsMeta/{table}")
    public String[] getRemovementsMetaData(@PathVariable String table) {
        switch (table) {
            case "user": return new String[]{"password"};
            case "account": return new String[]{};
            case "transaction": return new String[]{};
            case "moneyrequest": return new String[]{};
            default: return null;
        }
    }

    @PostMapping("/deleteAll")
    public void deleteAll() {
        userRepo.deleteAll();
        accountRepo.deleteAll();
        transRepo.deleteAll();
        requestRepo.deleteAll();
    }
}