import java.io.*;
import java.util.Scanner;
 
class Ring{
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
		    System.out.println("\n----RING ELECTION ALGORITHM----\n");
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
    	ele--;
        int front = ele;
		int active[] = new int[n];
		int k = 0;
		int maxi = 0;
		int mini = Integer.MAX_VALUE;

		for (int i = front; i < n; i++) {

			if (status[i] == true && (i == front || i+1 >= mini)) {
				active[k] = i+1;
				maxi = Math.max(maxi, active[k]);
				mini = Math.min(mini, active[k]);
				k++;
			}
			
			if (i > front) {
				System.out.println("Election message is sent from " + i + " to " + (i+1));
			}
			
			System.out.println("Active list :");
			for (int j = 0; j < k; j++) {
				System.out.println(active[j]);
			}
		}

		for (int i = 0; i < front; i++) {

			if (status[i] && i+1 >= mini) {
				active[k] = i+1;
				maxi = Math.max(maxi, active[k]);
				mini = Math.min(mini, active[k]);
				k++;
			}
			
			if (i > 0) {
				System.out.println("Election message is sent from " + i + " to " + (i+1));
			} else {
				System.out.println("Election message is sent from " + n + " to " + (i+1));
			}
			
			System.out.println("Active list :");
			for (int j = 0; j < k; j++) {
				System.out.println(active[j]);
			}
		}

		co = maxi;
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
