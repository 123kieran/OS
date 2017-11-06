package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	private ArrayList<Process> queue = new ArrayList<Process>();
	private Scanner scan;

	public static void main(String[] args) { 
		/* Creata an intance of Runner*/
		Runner run = new Runner();
		/* Create an instance of Scheduler and sent queue ref. */
		Scheduler sch = new Scheduler(run.queue);
		/* Assign scan new instance of Scanner passing in system input */
		run.scan = new Scanner(System.in);
		
		/* Ask user input for # of process */
		System.out.println("Pease enter the number of processes to schedule: ");
		int numOfProcesses = run.scan.nextInt();
		/* Loop # of processes selected geting user input for ID and Duration */
		for (int i = 0; i < numOfProcesses; i++) {
			System.out.println("Pease enter process ID(int): ");
			int id = run.scan.nextInt();
			System.out.println("Pease enter process duration(int): ");
			int duration = run.scan.nextInt();
			run.queue.add(new Process(id, duration));
			
		}
		/* Loop Menu to apply selected scheduling algorithm */
		int schedulingAlgorithm;
		do {
			System.out.println("**************************************************************");
			System.out.println("Pease enter the scheduling alrgorithm to apply: ");
			System.out.println("1: First Come First Served (FCFS)");
			System.out.println("2: Shortest Job First (SJF)");
			System.out.println("3: Round Robin (RR)");
			System.out.println("Press -1 to exit.");
			schedulingAlgorithm = run.scan.nextInt();
			System.out.println("**************************************************************");
			/* Switch schedulingAlgorithm to call correspondent method */
			switch(schedulingAlgorithm){
				case 1:
					System.out.println("First come first served");
					sch.fCFS();
					break;
				case 2:
					System.out.println("Shortest Job First");
					sch.sJF();
					break;
				case 3:
					System.out.println("Round Robbin");
					System.out.println("Set quantum value: ");
					int quantum = run.scan.nextInt();
					sch.roundRobin(quantum);
					break;
					default:
						System.out.println("No alogorithm selected");
			}
		}while(schedulingAlgorithm != -1);
		

	}/* End of Main */
}
