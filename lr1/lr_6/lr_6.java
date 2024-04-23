
public class lr_6
{
	public static void main(String args[]) 
    {
        /*int in = Integer.parseInt(args[0]);
        int mas[] = new int[in];
	    for(int i = 0; i < in; i++)
        {
            mas[i] = i;
	    }
        in--;
        int m = 2;
        while(m < in)
        {
            if(mas[m] == 0)
            {
                m++;
            }
            else
            {
                int j = m*2;
                while(j < in)
                {
                    mas[j] = 0;
                    j+=m;
                }
                m++;
            }
            //System.out.println(m);
        }

        for(int i = 0; i <= in; i++)
        {
            if(mas[i] != 0) System.out.print(mas[i]+",  ");
	    }*/
        
        int n = Integer.parseInt(args[0]);
        n+=1;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) f[i] = i;
        
        int[] f1 = new int[n];
        f1[0]=0; 
        f1[1]=0;
        for (int i = 2; i < n; i++) f1[i] = 1;
        //System.out.println();
        for (int i = 2; i * i <= n; i++)
        {
            if (f1[i] == 1)
            for (int j = i * i; j < n; j += i)
            {
                f1[j] = 0;
            }
        }
        System.out.println("Преобразованный массив: ");
        for (int i = 2; i < n; i++)
        {
            if (f1[i] == 1)
            System.out.print(f[i] + ", ");    
        } 
        System.out.println();
    }
}
