//package cs220;

import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class OALP {
	
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		new OALP().execute(sc);
	}
	
	public void execute (Scanner iFile) throws IOException
	{
		int n=0;
		String s = "";
		String dsaVal="";
		int[] hashTable = new int[1000];
		for (int a = 0; a < 1000; a++){hashTable[a]=0;}
		ArrayList<String> nodes= new ArrayList<String>();
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		
		
		try
		{
			while((s=iFile.nextLine())!=null){
				
				nodes.clear();
				sorted.clear();
				n=Integer.parseInt(s);
				if(n==0) continue;
				for (int i=0; i < n; i++) { 
					nodes.add(iFile.nextLine()); 
					//System.out.println(nodes.get(i));
				}
				for (int j=0;j < nodes.size();j++){
					if(nodes.get(j).equals("")){
						sorted.add(0);
					}else {
					String[] values = (nodes.get(j)).split(" ");
					sorted.add(values.length);
					}
				}
				
				Collections.sort(sorted);
				Collections.reverse(sorted);
				dsaVal="";
				for(int i=0;i<sorted.size();i++){
					dsaVal = dsaVal + "" +sorted.get(i);
				}
				//System.out.println(dsaVal);
				int midDig = hashKey(dsaVal);
				hashTable = writeToTable(midDig, hashTable);
				dsaVal="";
			}
		}
		
		catch(Exception e){
		}
		
		
		
		
		finally {
			//for(int k=0; k < 1000; k++){
				//System.out.println(hashTable[k]);
			//}
			//System.out.println();
			if (iFile != null) iFile.close();
		}
		
	}
	
	
	
	public int hashKey(String dsaVal) {

		int midDig=0;
		try{
		while(dsaVal.length()<3 || dsaVal.length()%2 == 0) {
			dsaVal = dsaVal + "0";
		}
		
		int n = ((dsaVal.length() +1)/2)-1;
		//System.out.println(dsaVal.length());
		//System.out.println(n);
		String midStr = dsaVal.charAt(n-1)+""+dsaVal.charAt(n)+""+dsaVal.charAt(n+1) +"";
		midDig = Integer.parseInt(midStr);
		midDig = midDig*midDig;
		midStr = midDig +"";
		if (midStr.length()%2==0){midStr = midStr +"0";}
		n = ((midStr.length() +1)/2)-1;
		midStr = midStr.charAt(n-1)+""+midStr.charAt(n)+""+midStr.charAt(n+1) +"";
		midDig = Integer.parseInt(midStr);
		
		
		}
		catch (Exception e){}
		return midDig;
	}
	
	
	
	public int[] writeToTable(int midDig, int[] hashTable ) {
		try{
		while(hashTable[midDig]==1){
			if(midDig==999){
				 	midDig=0;
			}else{
				midDig = midDig+1;
			}
		}
		hashTable[midDig] = 1;
		System.out.println(midDig);
		}
		catch(Exception e){}
		
		return hashTable;
		
	}
	
}