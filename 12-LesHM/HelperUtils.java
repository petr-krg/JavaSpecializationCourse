package krg.petr.otusjava;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class HelperUtils {
    private int lastClientID;
    private int lastAccountID;
    private final String[] names = {"Дмитрий", "Максим", "Пётр", "Никита", "Артем", "Иван", "Кирилл", "Егор",
            "Илья", "Андрей"};
    private final String[] middleName = {"Николаевич", "Владимирович", "Александрович", "Иванович", "Васильевич",
            "Сергеевич", "Викторович", "Михайлович", "Артемович", "Петрович"};
    private final String[] surName = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов",
            "Лазарев", "Медведев", "Ершов"};

    public HelperUtils(int startClientID, int startAccountID) {

        this.lastClientID = startClientID;
        this.lastAccountID = startAccountID;
    }

    public String generateRandomFIO() {

        return String.format("%s %s %s",
                generateRandomString(this.names),
                generateRandomString(this.middleName),
                generateRandomString(this.surName));
    }

    private String generateRandomString(String[] stringsArray) {

        final int MAX_INDEX = stringsArray.length;
        int randomIndex = new Random().nextInt(MAX_INDEX);
        return stringsArray[randomIndex];
    }

    public int generateClientID() {

        return ++this.lastClientID;
    }
    public int generateAccountID() {

        return ++this.lastAccountID;
    }

    public int generateBalance() {

        final int MAX_BALANCE = 100;
        return new Random().nextInt(MAX_BALANCE);
    }
    public  int generateClientAge(int minAge, int maxAge) {

        return new Random().nextInt(maxAge - minAge) + minAge;
    }

}

