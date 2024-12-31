import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int s = Integer.parseInt(br.readLine());
        
        int[] arr = new int[s];
        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        
        PrintArr(InsertionSort(arr));
        
    }
    
    public static int[] InsertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            int j = i-1;
            
            while (j >= 0 && arr[j] > target) {
                arr[j+1] = arr[j]; 
                j--;
            }
            
            arr[j+1] = target;
        }
        
        return arr;
    }
    
    public static void PrintArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
