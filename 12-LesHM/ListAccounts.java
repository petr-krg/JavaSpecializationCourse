package krg.petr.otusjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListAccounts {
    private List<BankAccount> listAccounts;

    public ListAccounts() {
        this.listAccounts = new ArrayList<>();
    }

    public void add(BankAccount account) {
        this.listAccounts.add(account);
    }

    public void findAccounts(BankClient client) {

        String title = client.getClientName();
        List<BankAccount> foundList = new ArrayList<>();

        Iterator<BankAccount> iterator = this.listAccounts.iterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            if (account.getClientID() == client.getClientID()) {
                foundList.add(account);
            }
        }

        showAllAccounts(title, foundList);
    }

    public void updateAccount() {

    }

    public void deleteAccount() {

    }

    public void showAllAccounts(String title) {

        String alignFormat = "| %-4d | %-4d | %-8d |%n";

        System.out.printf("%n%s%n", title);
        System.out.format("+------+------+----------+%n");
        System.out.format("| ID   | clID | Balance  |%n");
        System.out.format("+------+------+----------+%n");

        Iterator<BankAccount> iterator = this.listAccounts.iterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            System.out.format(alignFormat, account.getAccountID(), account.getClientID(), account.getAccountBalance());
        }

        System.out.format("+------+------+----------+%n");
    }

    public void showAllAccounts(String title, List<BankAccount> found) {

        if ((found == null) || (found.isEmpty())) {
            System.out.printf("%n%s%n", "Для клиента: " + title + " не найдено счетов!");
            return;
        }

        System.out.printf("%n%s%n", "Для клиента " + title + " найдено счетов: ");
        String alignFormat = "| %-4d | %-4d | %-8d |%n";
        System.out.format("+------+------+----------+%n");
        System.out.format("| ID   | clID | Balance  |%n");
        System.out.format("+------+------+----------+%n");

        Iterator<BankAccount> iterator = found.iterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            System.out.format(alignFormat, account.getAccountID(), account.getClientID(), account.getAccountBalance());
        }

        System.out.format("+------+------+----------+%n");
    }
}
