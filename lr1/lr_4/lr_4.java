public class lr_4 
{
	public static void main(String args[]) 
    {
        long x = 1,y = 0, z =0;
	    for(int i = 0; i < 100; i++)
        {
            
            System.out.print(x+",  ");
            z=y;
            y=x;
            x=y+z;
            
            
	    }

    }
}