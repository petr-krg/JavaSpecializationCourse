package krg.petr.otusjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
    public static void main( String[] args ) {

        final int MAX_CLIENTS = 10;

        ListAccounts accountsList = new ListAccounts();
        ListClients clientsList = new ListClients();

        HelperUtils helper = new HelperUtils(0, 0);

        for (int i = 0; i < MAX_CLIENTS; i++) {
            clientsList.add(new BankClient(helper.generateClientID(),
                                           helper.generateRandomFIO(),
                                           helper.generateClientAge(10, 85)));
        }

        for (int i = 0; i < MAX_CLIENTS; i++) {
            int clientIndex = new Random().nextInt(MAX_CLIENTS);
            accountsList.add(new BankAccount(helper.generateAccountID(),
                                             clientsList.getClientID(clientIndex),
                                             helper.generateBalance()));
        }

        clientsList.showAllClients("Bank clients list");
        accountsList.showAllAccounts("Bank accounts list");

        for (int i = 0; i < 3; i++) {
            int clientIndex = new Random().nextInt(MAX_CLIENTS);
            accountsList.findAccounts(clientsList.getClient(clientIndex));
        }

    }
}

