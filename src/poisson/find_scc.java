package poisson;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class find_scc {

	public static List<Integer> findwcc(int[][] G) {
		// TODO Auto-generated method stub
        int[][] a=G;
      	
		int[][] b= Fun.inv(a);
		/*
		for(int i=0;i<a.length;i++)
		{
			System.out.println(Arrays.toString(a[i]));
		    
		  }
		System.out.println("finish");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(Arrays.toString(b[i]));
		    
		  }
		*/
		int len=a.length;
		int time=0;
		
		int[][] vec=new int[len][2];
		for(int p=0;p<len;p++)
		{
		Arrays.fill(vec[p], 0);
		}
		List<Integer> seq=new ArrayList<Integer>();
		
		for (int i=0;i<len;i++)
		{   
		    if( vec[i][0]==0)
		    { 
		    	seq.clear();
		    	time=Fun.dfs_1(a, i, vec, time, len,seq);		    	
		   
		    //System.out.println(seq);
		   // System.out.println(time);
				 }
		}
		
		/*
		for(int p=0;p<len;p++)
		{
			System.out.println(Arrays.toString(vec[p]));
		}
		
		*/
		
		int[] s=new int[len];
		for(int p=0;p<len;p++)
		{
			s[p]=vec[p][1];
		}
		
		int[][] back=new int[len][2];
		for(int q=0;q<len;q++)
		{
		Arrays.fill(back[q], 0);
		}
		int[] so=Fun.sort(s);
		//System.out.println(Arrays.toString(s));
		//System.out.println(Arrays.toString(so));
	
		Arrays.fill(s, 0);
		List<int[]> r=new ArrayList<int[]>();
		seq.clear();
		List<Integer> tran=new ArrayList<Integer>();
		//System.out.println(Arrays.toString(s));
		int aaa=0;
		for(int q=0;q<len;q++)
		{
			//System.out.println(s[so[q]-1]);
			if(s[so[q]]==0)
			{  
				
				seq.clear();
				tran.clear();
				tran=Fun.dfs_t_1(b, so[q], s,so, len, seq,tran);
				
				
				aaa=tran.size();
				//System.out.println(tran);
				int[] bbb =new int[aaa];
				for (int i=0;i<aaa;i++)
				{
					bbb[i]=tran.get(i);
				}
				r.add(bbb);
				
			}
		
		}
		
		List<Integer> scc=new ArrayList<Integer>();
		
		scc=Fun.find_wcc(r);
		//int number=scc.size();
		return scc;
		
	}
	public static List<Integer> findscc(int[][] G) {
		// TODO Auto-generated method stub
        int[][] a=G;
      	
		int[][] b= Fun.inv(a);
		/*
		for(int i=0;i<a.length;i++)
		{
			System.out.println(Arrays.toString(a[i]));
		    
		  }
		System.out.println("finish");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(Arrays.toString(b[i]));
		    
		  }
		*/
		int len=a.length;
		int time=0;
		
		int[][] vec=new int[len][2];
		for(int p=0;p<len;p++)
		{
		Arrays.fill(vec[p], 0);
		}
		List<Integer> seq=new ArrayList<Integer>();
		
		for (int i=0;i<len;i++)
		{   
		    if( vec[i][0]==0)
		    { 
		    	seq.clear();
		    	time=Fun.dfs_1(a, i, vec, time, len,seq);		    	
		   
		    //System.out.println(seq);
		   // System.out.println(time);
				 }
		}
		
		/*
		for(int p=0;p<len;p++)
		{
			System.out.println(Arrays.toString(vec[p]));
		}
		
		*/
		
		int[] s=new int[len];
		for(int p=0;p<len;p++)
		{
			s[p]=vec[p][1];
		}
		
		int[][] back=new int[len][2];
		for(int q=0;q<len;q++)
		{
		Arrays.fill(back[q], 0);
		}
		int[] so=Fun.sort(s);
		//System.out.println(Arrays.toString(s));
		//System.out.println(Arrays.toString(so));
	
		Arrays.fill(s, 0);
		List<int[]> r=new ArrayList<int[]>();
		seq.clear();
		List<Integer> tran=new ArrayList<Integer>();
		//System.out.println(Arrays.toString(s));
		int aaa=0;
		for(int q=0;q<len;q++)
		{
			//System.out.println(s[so[q]-1]);
			if(s[so[q]]==0)
			{  
				
				seq.clear();
				tran.clear();
				tran=Fun.dfs_t_1(b, so[q], s,so, len, seq,tran);
				
				
				aaa=tran.size();
				//System.out.println(tran);
				int[] bbb =new int[aaa];
				for (int i=0;i<aaa;i++)
				{
					bbb[i]=tran.get(i);
				}
				r.add(bbb);
				
			}
		
		}
		
		List<Integer> scc=new ArrayList<Integer>();
		
		scc=Fun.find_scc(r);
		//int number=scc.size();
		return scc;
	}
}
