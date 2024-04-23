 public class lr_3 
 { 
 public static void main(String[] args) 
 { 
    
    for (int i = 0; i < args.length; i++) 
    {
        
        int j = args[i].length()-1;
        while(j >= 0)
        {
            System.out.print(args[i].charAt(j));
            j--;
        }
        System.out.print(" ");
    }
    System.out.println(" ");
 } 
 } 