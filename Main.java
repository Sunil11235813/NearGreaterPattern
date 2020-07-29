import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.*;

class Main {
  public static List<Integer> nearGreater(int[] arr){
     List<Integer> v = new LinkedList<>();
     Stack<Integer> s = new Stack<>();
     int n = arr.length;
     for(int i = n-1; i >= 0 ; i--){
       if(s.size() == 0){
         v.add(-1);
       }
       else if(s.size() > 0 && s.peek() > arr[i]){
         v.add(s.peek());
       }
       else if(s.size() > 0 && s.peek() <= arr[i]){
         while(s.size() > 0 && s.peek() <= arr[i]){
           s.pop();
         }
         if(s.size() == 0){
           v.add(-1);
         }else{
           v.add(s.peek());
         }
       }
       s.add(arr[i]);
     }
    return v;
  }
  public static void main(String[] args) {
    int[] arr = {1,3,2,4};
    System.out.println("ANS  :"+nearGreater(arr).toString()); 
    List<Integer> out = nearGreater(arr);
    Collections.reverse(out);
    System.out.println("ANS  :"+out.toString());   
  }
}