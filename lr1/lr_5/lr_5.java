public class lr_5
{
	public static void main(String args[]) 
    {
        int in = Integer.parseInt(args[0]);
        long res = 1;
	    for(int i = 1; i <= in; i++)
        {
            res *= i;
	    }
        System.out.println(res);
    }
}