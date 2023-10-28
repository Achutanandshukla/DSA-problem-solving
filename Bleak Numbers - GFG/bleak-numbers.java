//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{   static int count(int n){
    int ct=0;
    
        while(n>0){
            if(n%2==1){
                ct++;
            }
            n/=2;
        }
    return ct;
}
    public int is_bleak(int n)
    {   
        // if(n==1){
        //     return 1;
        // }
        int m=n; 
       while(n-->=m-ciel(m)){
           if(m==n+count(n)){
               return 0;
           }
       }
       return 1;
    }
    int ciel(int n){
        n--;
        int cnt=0;
        while(n>0){
            n=n>>1;
            cnt++;
        }
        return cnt;
}
}