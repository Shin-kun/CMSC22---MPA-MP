/**
 * Created by Loewe on 12/5/2016.
 */
import java.util.Scanner;

public class Rule30Tester {
    public static final int THREAD_COUNT = 6;

    public static  void main(String[] args){
        Rule30[] worker = new Rule30[THREAD_COUNT];
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();   //columns and rows
        boolean arr[] = new boolean[x];
        arr[x / 2] = true;
        long startTime = System.currentTimeMillis();
        int celldivide = x / THREAD_COUNT;

        for(int i = 0; i < x; i++){

            int start;
            int end = -1;
            //initializing the threads or building the threads
            for(int j = 0; j < THREAD_COUNT; j++){
                start = end + 1;
                end = start + celldivide - 1;
                if(end > x){
                    end = x - 1;
                }
                worker[j] = new Rule30(start,end, arr);
            }

            //printing the array
            //one of the workers will print the array because each worker shared the same array to read;;
            worker[0].printArr(arr);

            //threads start working
            for(int j = 0; j < THREAD_COUNT; j++){
                worker[j].start();
            }

            //waiting the threads to finish their jobs
            for(int j = 0; j < THREAD_COUNT; j++){
                while (worker[j].isAlive()) {

                    try {
                        worker[j].join();
                    } catch (InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
            }

            //combining the arrays;
            for(int j = 0; j < THREAD_COUNT; j++){
                //System.out.println(worker[j]);
                worker[j].changeArr(arr);
            }
        }
        System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));
    }
}
