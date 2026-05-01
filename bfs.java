import java.util.*;

class BFS{
    public static void main(String[] args){
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no of vertices:-");
        n=sc.nextInt();
        int[] vis=new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++)
           adj.add(new ArrayList<>());
           
          
           Queue<Integer> q=new LinkedList<>();
         System.out.println("enter the adj matrix:-");
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 int x=sc.nextInt();
                 if(x==1){
                     adj.get(i).add(j);
                 }
             }
         }
         q.add(0);
         vis[0]=1;
           System.out.println("BFS traversal:- ");
         while(!q.isEmpty()){
             int x=q.poll();
               System.out.println(x);
             for(Integer it:adj.get(x)){
                 if(vis[it]==0){
                     vis[it]=1;
                     q.add(it);
                 }
             }
         }
           
           
    }
}
