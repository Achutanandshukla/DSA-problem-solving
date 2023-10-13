//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class GFG {

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) {
            return new Node(val);
        }

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Node root = null;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                root = insert(root, k);
            }

            int s = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.floor(root, s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        ArrayList<Integer>al=new ArrayList<>();
        inorder(al,root);
        if(al.get(0)>x){
            return -1;
        }
        int val=-1;
        
        int min=1000000;
        for(int i=0;i<al.size();i++){
            int d=al.get(i);
            if(d>x){
                return val;
            }
            if(Math.abs(x-d)<min){
                min=Math.abs(x-d);
                val=d;
            }
        }
        return val;
    }
    static void inorder(ArrayList<Integer>al,Node root){
        if(root==null){
            return ;
        }
        inorder(al,root.left);
        al.add(root.data);
        inorder(al,root.right);
    }
}