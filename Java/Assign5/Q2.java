
import java.util.Random;

 public class Q2  {

    private static final int ARRAY_SIZE = 1000;
    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        int[] data = new int[ARRAY_SIZE];
        // Generate random integers between 0 and 999
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            data[i] = random.nextInt(1000); 
        }

        // Create and start threads
        Thread[] threads = new Thread[THREAD_COUNT];
        int chunkSize = ARRAY_SIZE / THREAD_COUNT;
        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * chunkSize;
            int end = Math.min((i + 1) * chunkSize, ARRAY_SIZE);
            threads[i] = new SumThread(data, start, end);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            SumThread sumThread = (SumThread) threads[i];
            System.out.println("Thread " + (i + 1) + " sum: " + sumThread.getSum());
        }

        // Calculate total sum
        int totalSum = 0;
        for (Thread thread : threads) {
            SumThread sumThread = (SumThread) thread;
            totalSum += sumThread.getSum();
        }

        // Calculate average
        double average = (double) totalSum / ARRAY_SIZE;

        System.out.println("Sum of the array: " + totalSum);
        System.out.println("Average of the array: " + average);
    }
}

class SumThread extends Thread {

    private final int[] data;
    private final int start;
    private final int end;
    private int sum;

    public SumThread(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += data[i];
        }
    }

    public int getSum() {
        return sum;
    }
}


