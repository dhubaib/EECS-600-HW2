// Chris Fietiekiewicz, Case Western Reserve University
public class QuickSort {
  public static void main(String[] args) {
    int[] a = {5, 4, 3, 2, 1};
    quickSort(a, 0, a.length - 1);
    for(int i:a) {
      System.out.print(i + " ");
    }
    System.out.println();
  }  
  
  public static void quickSort(int[] array, int lowerIndex, int higherIndex) {
    int i = lowerIndex;
    int j = higherIndex;
    int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
    while (i <= j) {
      while (array[i] < pivot) { i++; }
      while (array[j] > pivot) { j--; }
      if (i <= j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
      }
    }
    if (lowerIndex < j)
      quickSort(array, lowerIndex, j);
    if (i < higherIndex)
      quickSort(array, i, higherIndex);
  }
}
