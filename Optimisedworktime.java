import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int Day[]= new int[n];
        int Night[]= new int[n];
        for(int i=0;i<n;i++){
            Day[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            Night[i]=sc.nextInt();
        }
        int x=sc.nextInt();
        Arrays.sort(Day);
        Arrays.sort(Night);
        int temp;
        for(int i=0;i<n/2;i++){
            temp=Night[i];
            Night[i]=Night[n-1-i];
            Night[n-1-i]=temp;
            
        }

    
        int totalOvertime = 0;
        for (int i = 0; i < n; i++) {
            int total = Day[i] + Night[i];
            if (total > x) {
                totalOvertime += (total - x);
            }
        }

        System.out.println(totalOvertime * 100);
    }
}

        
    
