package krg.petr.otusjava;

public class SortBubble {
    public static void sortBubble (int[] array) {
        for (int k = array.length - 1; k > 0; k--) {
             for (int i = 0; i < k; i++) {
                  if (array[i] > array[i+1]) {
                      int temp = array[i];
                      array[i] = array[i+1];
                      array[i+1] = temp;
                  }
             }
        }
    }
}
