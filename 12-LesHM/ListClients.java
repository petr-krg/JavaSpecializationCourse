package krg.petr.otusjava;

import java.util.*;

public class ListClients {
    private List<BankClient> listClients;

    private Map<Integer, List<BankClient>> clientsByAccount;

    public ListClients() {

        this.listClients = new ArrayList<>();
        this.clientsByAccount = new HashMap<>();
    }

    public void fillClientsByAccountID(List<BankAccount> bankAccounts) {
        List<BankClient> listClient;

        for (BankAccount account : bankAccounts) {
            listClient = this.clientsByAccount.get(account.getAccountID());
            if (listClient == null) {
                listClient = new ArrayList<>();
            }
            listClient.add(getClient(account.getClientID()));
            this.clientsByAccount.put(account.getAccountID(), listClient);
        }

        System.out.println("hashMap clientsByAccount: " + this.clientsByAccount);
    }

    public void findClientByAccount(BankAccount account) {
        List<BankClient> findClient = new ArrayList<BankClient>();
        String title = "[HashMap] Для акаунта c номером: " + account.getAccountID();
        findClient = this.clientsByAccount.get(account.getClientID());
        showHashAccounts(title, findClient);
    }

    public void add(BankClient client) {

        this.listClients.add(client);
    }

    public void updateClient() {

    }

    public void deleteClient() {

    }

    public int getClientID(int elementIndex) {

        return this.listClients.get(elementIndex).getClientID();
    }

    public BankClient getClient(int elementIndex) {
        return this.listClients.get(elementIndex);
    }

    public void showHashAccounts(String title, List<BankClient> fClient){

        if ((this.listClients == null) || this.listClients.isEmpty()) {
            return;
        }

        System.out.printf("%n%s%n", title);

        String formatAlign = "| %-4d | %-32s | %-4d |%n";

        System.out.format("+------+----------------------------------+------+%n");
        System.out.format("| ID   | Client name                      | Age  |%n");
        System.out.format("+------+----------------------------------+------+%n");
        System.out.format(formatAlign, fClient.get(0).getClientID(), fClient.get(0).getClientName(), fClient.get(0).getClientAge());
        System.out.format("+------+----------------------------------+------+%n%n");
    }

    public void showAllClients(String title) {
        if ((this.listClients == null) || this.listClients.isEmpty()) {
            return;
        }

        System.out.printf("%n%s%n", title);

        String formatAlign = "| %-4d | %-32s | %-4d |%n";

        System.out.format("+------+----------------------------------+------+%n");
        System.out.format("| ID   | Client name                      | Age  |%n");
        System.out.format("+------+----------------------------------+------+%n");

        Iterator<BankClient> iterator = listClients.iterator();
        while (iterator.hasNext()) {
            BankClient item = iterator.next();
            System.out.format(formatAlign, item.getClientID(), item.getClientName(), item.getClientAge());
        }

        System.out.format("+------+----------------------------------+------+%n%n");
    }

}
