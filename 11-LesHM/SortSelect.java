package krg.petr.otusjava;

public class SortSelect {
    public static void sortSelect (int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
           int minN = i;
           int min  = array[i];
           for (int j = i + 1; j < array.length; j++) {
               if (min > array[j]) {
                   min  = array[j];
                   minN = j;
               }
           }
           array[minN] = array[i];
           array[i]    = min;
        }
    }

}
