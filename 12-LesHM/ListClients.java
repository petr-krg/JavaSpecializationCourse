package krg.petr.otusjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListClients {
    private List<BankClient> listClients;

    public ListClients() {

        this.listClients = new ArrayList<>();
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
