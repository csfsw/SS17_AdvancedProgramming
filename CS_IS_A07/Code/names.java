package entertainment;

import java.util.Scanner;

public class names {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner h = new Scanner(System.in);
		System.out.println("Enter number of  names.");
		int N =h.nextInt();
	System.out.println("Enter list of yur names.");
	String names[] = new String[N];
		int i;
		for(i = 0; i < N;i++)
		{
		   names[i] = h.next();
			
			}
	  System.out.println("Enter name for searsh in our memory");
	   String search = h.next();
 	   boolean find = false;
 	   int v = 0;
	   for(int b = 0; b<N; b++ ){
	   if(search.equals(names[b])){
	   System.out.println("your name is find------->"+ (v+1));
		   find = true;
		   break;
	      }
	   v++;
	    }
	   
	   if(!find){
		   System.out.println("your name is not find");
	  
	   }
      }
	
	}
