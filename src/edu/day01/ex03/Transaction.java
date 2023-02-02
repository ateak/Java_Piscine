package edu.day01.ex03;

import java.util.UUID;

public class Transaction {
    private enum TransferCategory {
        DEBITS,
        CREDITS
    }

    private UUID identifier;
    private User recipient;
    private User sender;
    private TransferCategory category;
    private Integer transferAmount;

    public Transaction(User recipient, User sender, Integer transferAmount) {
        this.recipient = recipient;
        this.sender = sender;
        this.identifier = UUID.randomUUID();
        this.transferAmount = transferAmount;

        if (transferAmount < 0) {
            category = TransferCategory.CREDITS;
        } else {
            category = TransferCategory.DEBITS;
        }

        if (sender.getBalance() < transferAmount && category == TransferCategory.DEBITS ||
                recipient.getBalance() < -transferAmount && category == TransferCategory.CREDITS) {
            System.out.println("No money");
            System.exit(0);
        } else {
            sender.setBalance(sender.getBalance() - transferAmount);
            recipient.setBalance(recipient.getBalance() + transferAmount);
        }
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public TransferCategory getCategory() {
        return category;
    }

    public void setCategory(TransferCategory category) {
        this.category = category;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Integer transferAmount) {
        this.transferAmount = transferAmount;
    }

    @Override
    public String toString() {
        return "transaction " + identifier + "\n{" +
                "\n recipient=" + recipient.getName() +
                ",\n Sender=" + sender.getName() +
                ",\n transferAmount=" + transferAmount +
                ",\n transferCategory=" + category +
                "\n balanceRecipient=" + recipient.getBalance() +
                "\n balanceSender=" + sender.getBalance() +
                "\n}";
    }
}