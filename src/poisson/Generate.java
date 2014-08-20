package poisson;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Generate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		int[][] aa =Prng.randomGraph(800,15);
		List<Integer> G=find_scc.findscc(aa);
		
		System.out.println(G.size());
		int si=G.size();
        int[][] newGraph=new int[si][si];
        int a=0;
        int b=0;
        for(int i:G)
        {
        	 b=0;
        	for(int j:G)
        	{
        		//System.out.println(i);
        		//System.out.println(j);
        		newGraph[a][b]=aa[i][j];
        		b=b+1;
        	}
        	a=a+1;
        }
        PrintWriter writer;
		try {
			writer = new PrintWriter("Graph.txt", "UTF-8");
			
			for(int i=0;i<si;i++)
        {
        	
       writer.println(Arrays.toString(newGraph[i]));
        	//System.out.println(Arrays.toString(newGraph[i]));
        }
        writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        
	}

}
