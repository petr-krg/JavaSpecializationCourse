package krg.petr.otusjava;

import java.util.*;

public class ListAccounts {
    private List<BankAccount> listAccounts;
    private Map<Integer, List<BankAccount>> accountsByClientID;
   public ListAccounts() {

        this.listAccounts = new ArrayList<>();
        this.accountsByClientID = new HashMap<>();
    }

    public void add(BankAccount account) {

        this.listAccounts.add(account);
    }

    public void findAccountByHashMap(BankClient client) {

       String title = "[HashMap] Для клиента: " + client.getClientName();
       List<BankAccount> idAccounts = this.accountsByClientID.get(client.getClientID());
       showHashAccounts(title, idAccounts);
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

    public void fillAccountsByClientID() {
       List<BankAccount> idAccounts;

       for (BankAccount account : this.listAccounts) {
           idAccounts = this.accountsByClientID.get(account.getClientID());
           if (idAccounts == null) {
               idAccounts = new ArrayList<>();
               idAccounts.add(account);
           } else {
               idAccounts.add(account);
           }
           this.accountsByClientID.put(account.getClientID(), idAccounts);
       }

        System.out.println("hashMap " + this.accountsByClientID);
/*
       for (BankAccount account : this.listAccounts) {
           this.accountsByClientID.computeIfAbsent(account.getClientID(), k -> new ArrayList<>()).add(account);
       }
*/
    }

    public void updateAccount() {

    }

    public void deleteAccount() {

    }

    public void showHashAccounts(String title, List<BankAccount> foundAccounts) {

        if (foundAccounts == null) {
            System.out.printf("%n%s%n", title + " не найдено счетов!");
            return;
        }

        String alignFormat = "| %-4d | %-4d | %-8d |%n";

        System.out.printf("%n%s%n", title);
        System.out.format("+------+------+----------+%n");
        System.out.format("| ID   | clID | Balance  |%n");
        System.out.format("+------+------+----------+%n");

        Iterator<BankAccount> iterator = foundAccounts.iterator();
        while (iterator.hasNext()) {
            BankAccount accounts = iterator.next();
            for (BankAccount account : this.listAccounts) {
                if (account.equals(accounts)) {
                    System.out.format(alignFormat, account.getAccountID(),
                                                   account.getClientID(),
                                                   account.getAccountBalance());
                }
            }
        }

        System.out.format("+------+------+----------+%n");
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
