import java.io.*;
import java.util.Scanner;
 
class Bully{
    static int n;
    static boolean status[] = new boolean[100];
    static int co;
     
    public static void main(String args[])throws IOException
    {
    	int choice, process;
    	
        System.out.println("Enter the number of process");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for(int i=0;i<n;i++)
        {
            status[i] = true;
        }
        
        while(true)
        {
		    System.out.println("\n----BULLY ELECTION ALGORITHM----\n");
		    System.out.println("1. Up Process");
		    System.out.println("2. Down Process");
		    System.out.println("3. Start Election");
		    System.out.println("4. Exit");
		    choice = in.nextInt();
		    
		    switch(choice)
		    {
		    	case 1:
		    	{
		    		System.out.println("Enter process number for up process:");
		    		process = in.nextInt();
		    		up(process);
		    		break;
		    	}
		    	case 2:
		    	{
		    		System.out.println("Enter process number for down process:");
		    		process = in.nextInt();
		    		down(process);
		    		break;
		    	}
		    	case 3:
		    	{
		    		System.out.println("Which process will initiate election?");
		    		process = in.nextInt();
		    		elect(process);
		    		System.out.println("Final coordinator is " + co);
		    		break;
		    	}
		    	case 4:
		    		return;
		    }
		}
    }
     
    static void elect(int ele)
    {
        ele = ele - 1;
        co = ele + 1;
        
        for(int i=0;i<n;i++)
        {
            if(ele < i)
            {
                System.out.println("Election message is sent from " + (ele+1) + " to " + (i+1));
                if(status[i]==true)
                    elect(i+1);
            }
        }
    }
    
    static void up(int process)
    {
    	if(status[process-1] == true)
    	{
    		System.out.println("Process " + process + " is already up");
    	} 
    	else
    	{
    		status[process-1] = true;
    		System.out.println("Process " + process + " is up");
    	}
    }
    
    static void down(int process)
    {
    	if(status[process-1] == false)
    	{
    		System.out.println("Process " + process + " is already down");
    	} 
    	else
    	{
    		status[process-1] = false;
    		System.out.println("Process " + process + " is down");
    	}
    }
}
