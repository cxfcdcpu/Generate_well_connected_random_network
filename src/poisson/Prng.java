package poisson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prng {

	public static int[][] randomGraph(int n,int eps){
		// TODO Auto-generated method stub
		int[] c=new int[n];
		int[][] aa=new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			Arrays.fill(aa[i], 0);
		}
		
        for (int i=0;i<n;i++)
        {
		 c[i]=getPoisson(eps);
		
        }
		//System.out.println(Arrays.toString(c));
		
		List<Integer> bin=new ArrayList<Integer>();
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=c[i];
		}
		if(sum%2==1)
		{
			c[0]=c[0]+1;
		}
		
		for(int i=0;i<n;i++)
		{
			bin.add(i);
			bin.add(c[i]);
		}
	
		while(!bin.isEmpty())
		{
			//System.out.println(bin);
			int range=bin.size()/2;
			//System.out.println(range);
			int n1=selectOne(0,range)-1;
			int v1=bin.get(2*n1+1)-1;
			int n2=selectOne(0,range)-1;
			//System.out.println("n1"+n1);
			//System.out.println("v1"+v1);
			
			if(bin.size()>2)
			{
			while(n2==n1)
			{
				n2=selectOne(0,range)-1;
			}
			int v2=bin.get(2*n2+1)-1;
			//System.out.println("v2"+v2);
			aa[bin.get(2*n1)][bin.get(2*n2)]=1;
			aa[bin.get(2*n2)][bin.get(2*n1)]=1;
			if(v1==0)
			{
				bin.remove(2*n1);
				bin.remove(2*n1);
				if(n1>n2)
				{
					if(v2==0)
					{
						bin.remove(2*n2);
						bin.remove(2*n2);
						
					}
					else{
						bin.set(2*n2+1, v2);
						}
				}
				else
				{
					if(v2==0)
					{
						bin.remove(2*n2-2);
						bin.remove(2*n2-2);
						
					}
					else{
						bin.set(2*n2-1, v2);
						}
				}
				
			}
			else{
				bin.set(2*n1+1, v1);
				if(v2==0)
				{
					bin.remove(2*n2);
					bin.remove(2*n2);
					
				}
				else{
					bin.set(2*n2+1, v2);
					}
				}
			}
			else
			{
				bin.clear();
			}
			
			
		}
		/*
		for(int i=0;i<n;i++)
		{
			System.out.println(Arrays.toString(aa[i]));
		}
		*/
		System.out.println(Arrays.toString(c));
		return aa;
	}
   
	
	public static int getPoisson(double lambda) {
		  double L = Math.exp(-lambda);
		  double p = 1.0;
		  int k = 0;

		  do {
		    k++;
		    p *= Math.random();
		  } while (p > L);
      if(k<=1)
      {
    	  k=2;
      }
      
		  return k - 1;
		}
	
	public static int selectOne(int a, int b)
	{
		int n=0;
		n=a+(int)(Math.random()*(b-a)+1);
		
		return n;
	}
	
}
