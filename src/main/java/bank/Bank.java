package bank;


import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accountList = new HashMap<>();


    public Map<String, Account> getAccountList() {
        return accountList;
    }

    public Account createAccount(String clientName, Long sold) {
        Account account = new Account(clientName, sold);
        accountList.put(account.getAccountNumber(), account);
        return account;
    }

    public Account getAccountByAccountNumber(String accountNumber) throws Exception{
        Account account = accountList.get(accountNumber);
        if (account == null)
            throw new Exception("Account not found");
        return account;
    }

    public Operation deposit(String accountNumber, long amount) throws Exception {
        Account account = getAccountByAccountNumber(accountNumber);

        Operation operation = new Operation(amount, OperationType.DEPOSIT);
        account.setBalance(amount + account.getBalance());
        account.getOperations().add(operation);

        return operation;
    }

    public Operation withdraw(String accountNumber, Long amount) throws Exception {
        Account account = getAccountByAccountNumber(accountNumber);

        if (account.getBalance() < amount)
            throw new Exception("Insufficient balance");

        Operation operation = new Operation(amount, OperationType.WITHDRAWAL);
        account.setBalance(amount - account.getBalance());
        account.getOperations().add(operation);

        return operation;
    }
}
