// Chris Fietkiewicz. For HW 2, Problem 1. Added argument passing.
public class Timing2 {
  public static void main(String[] args) {
    long n; // Number of iterations
    if (args.length == 1) {
      n = Long.parseLong(args[0]);
    } else {
      n = 100000000L;
    }
    long startTime, stopTime; // For recording start/stop times
    long x = 0;
    long avgTime = 0;
    int trial;
    for (trial = 0; trial < 5; trial++) {
      startTime = System.currentTimeMillis();
      for (long i = 0; i < n; i++) {
        x = x + 1;
      }
      stopTime = System.currentTimeMillis();
      avgTime += (stopTime-startTime);
      System.out.print(stopTime - startTime + "\t");
    }
    System.out.print("Average: " + (float)avgTime/(float)trial + "\n");
  }
}
