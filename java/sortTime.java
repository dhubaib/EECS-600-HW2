// Cal Al-Dhubaib, CWRU 
// Assignment 2 - 2/1/16 (Modified from Assignment 1)

// Method to measuring performance of sorting algorithms by veco

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class sortTime {
  public static void main(String[] args) {
    
    long startTime, stopTime; // For recording start/stop times
    int baseSize;
    int nTrials = 5;
    
    // Set up sequence starting size
    if (args.length >= 1) {
      baseSize = Integer.parseInt(args[0]);
    } else {
      baseSize = 500000;
    }
    
    // Set up arrays to collect times
    int[] trialSizes = new int[10];
    float[][] sortTimes = new float[10][nTrials]; // Multiple times for each array size
    trialSizes[0] = (int)baseSize;
    
    // Run test case on various-sized arrays
    for (int trial = 0; trial < sortTimes.length; trial++){
      trialSizes[trial] = baseSize*(trial+1); // Fill array of sequence
      
      int maxNum = trialSizes[trial];
      int[] seq = new int[maxNum]; // Initialize the array
      
      // Build various reverse-ordered sequences
      for (int j = 0; j < seq.length; j++){
        seq[j] = maxNum--; // Fill with reverse order        
      }
      
      // Run sort quick sort test on sequence here and collect 5 run-times
      for (int j = 0; j < sortTimes[0].length; j++){
        int[] seq1 = seq.clone();
        
        startTime = System.currentTimeMillis();
        if (args.length == 2){
          InsertionSort.insertionSort(seq1);
        }
        else{ // Use quicksort unless otherwise specified
          QuickSort.quickSort(seq1,0,seq1.length - 1);
        }
        stopTime = System.currentTimeMillis();
      
        sortTimes[trial][j] = (float)(stopTime - startTime);
        if(args.length == 2){
          System.out.print("Insertion Sort ");
        }else{
          System.out.print("Quick Sort ");
        }
        System.out.print("["+trial+", " + j + "]: " + (stopTime - startTime) + "\n");
      }
    }
    
    // Output timing results to file
    File f = null;
    try{
      if(args.length == 2){
        f = new File("sortJavaInsert.csv");
      }else{
        f = new File("sortJavaQuick.csv");
      }
      f.createNewFile();
      
      FileOutputStream fis = new FileOutputStream(f);
      PrintStream out = new PrintStream(fis);
      
      System.out.print("\n");
      
      System.setOut(out);
      
      // First row in each file = sequence length
      for (int j = 0; j < trialSizes.length; j++){
        System.out.print(trialSizes[j]);
        
        if(j < trialSizes.length - 1){
          System.out.print(",");
        }
      }
      
      System.out.print("\n");
      
      // Second row in each file = sorting time
      for (int trial = 0; trial < nTrials; trial++){
        for (int j = 0; j < sortTimes.length; j++){
          System.out.print(sortTimes[j][trial]);
          
          if(j < sortTimes.length - 1){
            System.out.print(",");
          }
        }
        System.out.print("\n");
      }
      
      // Close print streams
      out.close();
      
    }catch(Exception e){
    }
  }
}
