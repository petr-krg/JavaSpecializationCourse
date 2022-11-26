package krg.petr.otusjava;

import java.util.List;

public class BankAccount {
    private final int accountID;
    private final int clientID;
    private final int accountBalance;


    public BankAccount(int acID, int clID, int acBalance) {
        this.accountID = acID;
        this.clientID = clID;
        this.accountBalance = acBalance;
    }

    public int getAccountID() {
        return this.accountID;
    }
    public int getClientID() {
        return this.clientID;
    }
    public int getAccountBalance() {
        return this.accountBalance;
    }

    public List<BankAccount> findAccount(BankClient client) {
        return null;
    }
}
