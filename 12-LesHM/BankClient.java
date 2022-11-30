package krg.petr.otusjava;

import java.util.ArrayList;
import java.util.List;

public class BankClient {
    private final int clientID;
    private final String clientName;
    private final int clientAge;

    public BankClient(int cID, String cName, int cAge) {
        this.clientID = cID;
        this.clientName = cName;
        this.clientAge = cAge;
    }

    public int getClientID() {
        return this.clientID;
    }
    public String getClientName() {
        return this.clientName;
    }
    public int getClientAge() {
        return clientAge;
    }

}

