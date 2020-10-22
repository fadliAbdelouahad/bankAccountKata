package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private Long balance;
    private String accountNumber;
    private String clientName;
    private List<Operation> operations;

    public Account(){

    }


    public Account(String clientName, Long balance) {
        this.balance = balance == null ? 0 : balance;
        this.clientName = clientName;
        this.accountNumber = UUID.randomUUID().toString();
        this.operations = new ArrayList<>();
    }



    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
