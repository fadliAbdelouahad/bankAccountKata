import bank.Account;
import bank.Bank;
import bank.Operation;
import bank.OperationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class BankTest {

    private Bank bank;
    private Account account;
    private Long amount;
    private String accountNumber;

    @Before
    public void setUp(){
        bank = new Bank();
        account = bank.createAccount("ClientName", 500L);
        accountNumber = account.getAccountNumber();
        amount = 500L;

    }

    @Test
    public void bank_account_creation_with_balance(){

        assertFalse(bank.getAccountList().isEmpty());
        Assert.assertNotNull(account.getAccountNumber());
        assertEquals("ClientName", account.getClientName());
        assertEquals(amount, account.getBalance());

    }

    @Test
    public void bank_account_creation_without_balance(){
        Account newAccount = bank.createAccount("ClientName", null);

        assertFalse(bank.getAccountList().isEmpty());
        Assert.assertNotNull(newAccount.getAccountNumber());
         assertEquals("ClientName", newAccount.getClientName());
        assertEquals((Long)0L, newAccount.getBalance());

    }

    @Test
    public void money_deposit_exception_account_not_found() throws Exception{
        try {
            Operation operation = bank.deposit(null, amount);
        }catch (Exception e){

            assertEquals("Account not found", e.getMessage());
        }
    }

    @Test
    public void money_deposit_success() throws Exception{
        Long oldSold = account.getBalance();

        Operation operation = bank.deposit(accountNumber, amount);

        assertEquals((Long)(oldSold + amount), account.getBalance());
        assertNotNull(operation);
        assertEquals(OperationType.DEPOSIT, operation.getOperationType());
        assertEquals(amount, operation.getAmount());
    }

    @Test
    public void money_withdraw_exception_account_not_found() throws Exception{
        try {
            bank.withdraw(null, amount);
        }catch (Exception e){

            assertEquals("Account not found", e.getMessage());
        }
    }

    @Test
    public void money_withdrawal_success() throws Exception{
        Long oldSold = account.getBalance();
        Operation operation = bank.withdraw(accountNumber, amount);

        assertEquals((Long)(oldSold - amount), account.getBalance());
        assertNotNull(operation);
        assertEquals(OperationType.WITHDRAWAL, operation.getOperationType());
        assertEquals(amount, operation.getAmount());
    }

    @Test
    public void money_withdrawal_exception_insufficient_balance() throws Exception{
        try {
            bank.withdraw(accountNumber, 1000L);
        }catch (Exception e){
            assertEquals("Insufficient balance", e.getMessage());
        }
    }

    @Test
    public void get_operations_account() throws Exception{
        bank.deposit(accountNumber, amount);
        bank.deposit(accountNumber, amount);
        bank.deposit(accountNumber, amount);
        bank.withdraw(accountNumber, amount);

        Account account = bank.getAccountByAccountNumber(accountNumber);
        List<Operation> operations = account.getOperations();

        assertNotNull(account);
        assertFalse(operations.isEmpty());
        assertEquals(4, operations.size());
    }
}
