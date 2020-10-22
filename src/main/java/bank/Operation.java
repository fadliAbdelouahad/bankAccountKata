package bank;

import java.util.Date;
import java.util.UUID;

public class Operation {
    private String idOperation;
    private Long amount;
    private Date date;

    private OperationType operationType;

    public Operation() {
    }

    public Operation(Long amount, OperationType type) {
        this.idOperation = UUID.randomUUID().toString();
        this.amount = amount;
        this.operationType = type;
        this.date = new Date();
    }

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
