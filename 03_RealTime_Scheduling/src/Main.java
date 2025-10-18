////////JAVA Program for implementing
////////Round Robin Algorithm
//////// code by Sparsh_cbs
//////import java.util.*;
//////
//////public class Main{
//////    private static Scanner inp = new Scanner(System.in);
//////    //Driver Code
//////    public static void main(String[] args){
//////        int n,tq, timer = 0, maxProccessIndex = 0;
//////        float avgWait = 0, avgTT = 0;
//////        System.out.print("\nEnter the time quanta : ");
//////        tq = inp.nextInt();
//////        System.out.print("\nEnter the number of processes : ");
//////        n = inp.nextInt();
//////        int arrival[] = new int[n];
//////        int burst[] = new int[n];
//////        int wait[] = new int[n];
//////        int turn[] = new int[n];
//////        int queue[] = new int[n];
//////        int temp_burst[] = new int[n];
//////        boolean complete[] = new boolean[n];
//////
//////        System.out.print("\nEnter the arrival time of the processes : ");
//////        for(int i = 0; i < n; i++)
//////            arrival[i] = inp.nextInt();
//////
//////        System.out.print("\nEnter the burst time of the processes : ");
//////        for(int i = 0; i < n; i++){
//////            burst[i] = inp.nextInt();
//////            temp_burst[i] = burst[i];
//////        }
//////
//////        for(int i = 0; i < n; i++){ //Initializing the queue and complete array
//////            complete[i] = false;
//////            queue[i] = 0;
//////        }
//////        while(timer < arrival[0]) //Incrementing Timer until the first process arrives
//////            timer++;
//////        queue[0] = 1;
//////
//////        while(true){
//////            boolean flag = true;
//////            for(int i = 0; i < n; i++){
//////                if(temp_burst[i] != 0){
//////                    flag = false;
//////                    break;
//////                }
//////            }
//////            if(flag)
//////                break;
//////
//////            for(int i = 0; (i < n) && (queue[i] != 0); i++){
//////                int ctr = 0;
//////                while((ctr < tq) && (temp_burst[queue[0]-1] > 0)){
//////                    temp_burst[queue[0]-1] -= 1;
//////                    timer += 1;
//////                    ctr++;
//////
//////                    //Updating the ready queue until all the processes arrive
//////                    checkNewArrival(timer, arrival, n, maxProccessIndex, queue);
//////                }
//////                if((temp_burst[queue[0]-1] == 0) && (complete[queue[0]-1] == false)){
//////                    turn[queue[0]-1] = timer;	 //turn currently stores exit times
//////                    complete[queue[0]-1] = true;
//////                }
//////
//////                //checks whether or not CPU is idle
//////                boolean idle = true;
//////                if(queue[n-1] == 0){
//////                    for(int k = 0; k < n && queue[k] != 0; k++){
//////                        if(complete[queue[k]-1] == false){
//////                            idle = false;
//////                        }
//////                    }
//////                }
//////                else
//////                    idle = false;
//////
//////                if(idle){
//////                    timer++;
//////                    checkNewArrival(timer, arrival, n, maxProccessIndex, queue);
//////                }
//////
//////                //Maintaining the entries of processes after each premption in the ready Queue
//////                queueMaintainence(queue,n);
//////            }
//////        }
//////
//////        for(int i = 0; i < n; i++){
//////            turn[i] = turn[i] - arrival[i];
//////            wait[i] = turn[i] - burst[i];
//////        }
//////
//////        System.out.print("\nProgram No.\tArrival Time\tBurst Time\tWait Time\tTurnAround Time"
//////                + "\n");
//////        for(int i = 0; i < n; i++){
//////            System.out.print(i+1+"\t\t"+arrival[i]+"\t\t"+burst[i]
//////                    +"\t\t"+wait[i]+"\t\t"+turn[i]+ "\n");
//////        }
//////        for(int i =0; i< n; i++){
//////            avgWait += wait[i];
//////            avgTT += turn[i];
//////        }
//////        System.out.print("\nAverage wait time : "+(avgWait/n)
//////                +"\nAverage Turn Around Time : "+(avgTT/n));
//////    }
//////    public static void queueUpdation(int queue[],int timer,int arrival[],int n, int maxProccessIndex){
//////        int zeroIndex = -1;
//////        for(int i = 0; i < n; i++){
//////            if(queue[i] == 0){
//////                zeroIndex = i;
//////                break;
//////            }
//////        }
//////        if(zeroIndex == -1)
//////            return;
//////        queue[zeroIndex] = maxProccessIndex + 1;
//////    }
//////
//////    public static void checkNewArrival(int timer, int arrival[], int n, int maxProccessIndex,int queue[]){
//////        if(timer <= arrival[n-1]){
//////            boolean newArrival = false;
//////            for(int j = (maxProccessIndex+1); j < n; j++){
//////                if(arrival[j] <= timer){
//////                    if(maxProccessIndex < j){
//////                        maxProccessIndex = j;
//////                        newArrival = true;
//////                    }
//////                }
//////            }
//////            if(newArrival) //adds the index of the arriving process(if any)
//////                queueUpdation(queue,timer,arrival,n, maxProccessIndex);
//////        }
//////    }
//////
//////    public static void queueMaintainence(int queue[], int n){
//////
//////        for(int i = 0; (i < n-1) && (queue[i+1] != 0) ; i++){
//////            int temp = queue[i];
//////            queue[i] = queue[i+1];
//////            queue[i+1] = temp;
//////        }
//////    }
//////}
////
////import java.util.ArrayList;
////import java.util.Scanner;
////
////public class Main{
////    public static void main(String[] args) {
////
////        ArrayList<Integer> arr=new ArrayList<Integer>();
////        for (int i = 0; i < 5; i++) {
////            Scanner input = new Scanner(System.in);
////            int x=input.nextInt();
////            arr.add(x);
////        }
////        System.out.println(arr);
////        arr.remove(Integer.valueOf(3));
////        System.out.println(arr);
////        arr.add(3);
////        System.out.println(arr);
////    }
////}
//
//import java.util.Scanner;
//
//public class Main {
//
//
//    public static void main(String args[]) {
//
//
//        Scanner sc = new Scanner(System.in);
//
//
//        System.out.println("enter no. of processes : ");
//        int n = sc.nextInt();
//        int job[] = new int[n + 1];
//        int burst[] = new int[n + 1];
//        int newburst[] = new int[n + 1];
//        int arrival[] = new int[n + 1];
//        int deadline[] = new int[n + 1];
//        int wt[] = new int[n + 1];
//        int turn[] = new int[n + 1];
//        int tot_turn = 0;
//        int tot_wait = 0;
//        float avg_turn = 0;
//        float avg_wait = 0;
//        int j;
//
//        for (int m = 1; m <= n; m++) {
//            arrival[m] = m;
//        }
//        for (int m = 1; m <= n; m++) {
//            job[m] = m;
//        }
//
//        for (int m = 1; m <= n; m++) {
//            System.out.println("enter arrival time, burst time and deadline of process " + (m) + "(0 for none):");
//            arrival[m] = sc.nextInt();
//            burst[m] = sc.nextInt();
//            deadline[m] = sc.nextInt();
//
//            if (deadline[m] == 0) {
//                deadline[m] = 1000;
//            }
//        }
//
//
//        int temp;
//        for (int i = 1; i < n; i++) {
//            for (j = 1; j < n; j++) {
//
//                if (deadline[i + 1] < deadline[j]) {
//                    temp = deadline[j + 1];
//                    deadline[j + 1] = deadline[j];
//                    deadline[j] = temp;
//
//                    temp = job[j + 1];
//                    job[j + 1] = job[j];
//                    job[j] = temp;
//
//                    temp = burst[j + 1];
//                    burst[j + 1] = burst[j];
//                    burst[j] = temp;
//                }
//            }
//        }
//        turn[1] = burst[1];
//
//        for (int i = 2; i <= n; i++) {
//            turn[i] = burst[i] + turn[i - 1];
//            wt[i] = turn[i] - burst[i];
//        }
//        for (int i = 1; i <= n; i++) {
//            tot_turn += (wt[i] + burst[i]) - arrival[i];
//            avg_turn = (float) tot_turn / n;
//            tot_wait += wt[i] - arrival[i];
//            avg_wait = (float) tot_wait / n;
//        }
//        System.out.println("----------Earliest Deadline Scheduling Diagram----------");
//        for (int m = 1; m <= n; m++) {
//            if (deadline[m] == 1000) {
//                deadline[m] = 0;
//            }
//            if (wt[m] == 0) {
//                System.out.println("0" + wt[m] + " _____");
//            } else {
//                System.out.println(wt[m] + " _____");
//            }
//            System.out.println("  |     |");
//
//            System.out.println("  |job " + job[m] + "|");
//
//            System.out.println("  |_____|");
//            try {
//                //newburst[m]=(burst[m]*1000);
//                Thread.sleep(1000);
//            } catch (InterruptedException ie) {
//                System.out.println(ie.getMessage());
//            }
//        }
//        System.out.println((wt[wt.length - 1] + burst[burst.length - 1]));
//    }
//}
public class Main {
    public static void main(String[] args) {
        String[] processName={"p1","p2","p3"};
        int[] processPeriod={30,40,50};
        int[] burstTime={15,15,5};
        edf(3,burstTime,processPeriod,processName);
    }
    public static void edf(int n, int[] burstTime, int[] processPeriod, String[] processName) {
        int[] completionTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];

        int time = 0;
        int processCount = n;

        while (processCount > 0) {
            int shortestPeriodIndex = -1;
            int shortestPeriod = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (processPeriod[i] < shortestPeriod && burstTime[i] > 0) {
                    shortestPeriodIndex = i;
                    shortestPeriod = processPeriod[i];
                }
            }
            if (shortestPeriodIndex == -1) {
                time++;
                continue;
            }
            if (time < processPeriod[shortestPeriodIndex]) {
                time = processPeriod[shortestPeriodIndex];
            }
            burstTime[shortestPeriodIndex]--;
            processPeriod[shortestPeriodIndex] += 120;
            if (burstTime[shortestPeriodIndex] == 0) {
                completionTime[shortestPeriodIndex] = time + 1;
                turnaroundTime[shortestPeriodIndex] = completionTime[shortestPeriodIndex];
                waitingTime[shortestPeriodIndex] = turnaroundTime[shortestPeriodIndex] - burstTime[shortestPeriodIndex];
                processCount--;
                System.out.println("Process " + processName[shortestPeriodIndex] + " completed at " + completionTime[shortestPeriodIndex] + "ms");
            }
            time++;
        }
    }
}