// Chris Fietiekiewicz, Case Western Reserve University
public class InsertionSort {
  public static void main(String[] args) {
    int[] a = {5, 4, 3, 2, 1};
    insertionSort(a);
    for(int i:a) {
      System.out.print(i + " ");
    }
    System.out.println();
  }  
  
  public static void insertionSort(int[] data){
    int temp;
    for (int i = 1; i < data.length; i++) {
      for(int j = i ; j > 0 ; j--){
        if(data[j] < data[j-1]){
          temp = data[j];
          data[j] = data[j-1];
          data[j-1] = temp;
        }
      }
    }
  }
}
