//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Sol obj = new Sol();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
       HashMap<Integer,Integer> hs = new HashMap<>();
        Node temp=head1;
        int cnt=0;
        while(temp!=null){
           hs.put(temp.data,hs.getOrDefault(temp.data,0)+1);
           temp=temp.next;
           cnt++;
        }
        temp=head2;
        Node ans=new Node(-1);
        Node res=ans;
        while(temp!=null &&cnt>0 ){
            if(hs.containsKey(temp.data) && hs.get(temp.data)>0){
                Node nn=new Node(temp.data);
                res.next=nn;
                res=nn;
                hs.put(temp.data,hs.get(temp.data)-1);
                
            }
            temp=temp.next;
        }
        return ans.next;
    }
}