/**
 * Created by Loewe on 12/5/2016.
 */

public class Rule30 extends Thread {
    private int start;
    private int end;
    private int row;
    private boolean[] arr;  //the array I want to read
    private boolean[] arr2; //the array I want to write

    public Rule30(){ }

    public Rule30(int start, int end, boolean[] arr) {
        this.start = start;
        this.end = end;
        this.arr = arr;
        arr2  = new boolean[(end - start) + 1];
    }

    //running
    public void run() {
        for (int i = start, j = 0; i <= end; i++, j++) {
            boolean m = i - 1 >= 0 ? arr[i - 1] : false;
            boolean n = arr[i];
            boolean o = i + 1 < arr.length - 1 ? arr[i + 1] : false;

            if ((m && n) || (m && o) || (!m && !n && !o)) {
                arr2[j] = false;
            } else {
                arr2[j] = true;
            }
        }
    }

    //overwrites the array to be read
    public void changeArr(boolean[] arr) {
        for (int j = start, i = 0; j <= end; j++, i++) {
            arr[j] = arr2[i];
        }
    }

    //returns to string;;
    public String toString() {
        String cells = "";
        for (int i = start; i <= end; i++) {
            if (arr[i]) {
                cells += "1";
            } else {
                cells += "0";
            }
        }
        return cells;
    }
    //prints the entire array
    public void printArr(boolean[] arr){
        String cells = "";
        for(int m = 0; m < arr.length; m++){
            if(arr[m]){
                cells += "1";
            } else {
                cells += "0";
            }
        }
        System.out.println(cells);
    }
}
