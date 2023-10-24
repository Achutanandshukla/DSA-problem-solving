//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {   
        int n=str.length();
        boolean dp[][]=new boolean[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }
                else if(g==1){
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                }
                else{
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=false;
                    }
                }
            }
        }
        int dp2[][]=new int [n][n];
         for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp2[i][j]=0;
                }
                else if(g==1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp2[i][j]=0;
                    }
                    else{
                        dp2[i][j]=1;
                    }
                }
                else{
                    if(dp[i][j]){
                        dp2[i][j]=0;
                    }
                    else{
                    int min=501;
                    for(int k=i;k<j;k++){
                        int l=dp2[i][k];
                        int r=dp2[k+1][j];
                        min=Math.min(l+r+1,min);
                    }
                    dp2[i][j]=min;
                }
                }
            }
         }
         return dp2[0][n-1];
          
    }
}