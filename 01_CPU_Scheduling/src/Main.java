import com.sun.jdi.IntegerValue;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
class ProcessFIFORoundRobin{
    String name;
    int arrivalTime;
    int burstTime;

}
class Deadlines{
    int time;
    String[] pDead=new String[10];
}

class ProcessEDF{
    String name;
    int periodTime;
    int burstTime;
    ArrayList<Integer> deadline=new ArrayList<Integer>();
}
public class Main {
    public static void main(String[] args) {
        int timeQuantum = 0;
        int numOfProcess;
        System.out.println("which algorithm?");
        Scanner input = new Scanner(System.in);
        String algorithmName = input.next();

        System.out.println("number of process?");
        numOfProcess = input.nextInt();


        if (Objects.equals(algorithmName, "FIFO")) {

            int arrivalCounter = Integer.MAX_VALUE;
            ArrayList<ProcessFIFORoundRobin> processQueue = new ArrayList<ProcessFIFORoundRobin>();
            for (int i = 0; i < numOfProcess; i++) {
                ProcessFIFORoundRobin p = new ProcessFIFORoundRobin();
                p.name = input.next();
                p.arrivalTime = input.nextInt();
                p.burstTime = input.nextInt();
                processQueue.add(p);
                if (p.arrivalTime <= arrivalCounter)
                    arrivalCounter = p.arrivalTime;

            }


            while (processQueue.size() != 0) {
                int x = Integer.MAX_VALUE;
                for (int i = 0; i < processQueue.size(); i++) {
                    if (x > processQueue.get(i).arrivalTime) {
                        x = processQueue.get(i).arrivalTime;
                    }
                }
                arrivalCounter = x;
                for (int i = 0; i < processQueue.size(); i++) {

                    if (processQueue.get(i).arrivalTime <= arrivalCounter) {
                        System.out.println(processQueue.get(i).name + " (" + arrivalCounter + "-" + (arrivalCounter + (int) processQueue.get(i).burstTime) + ")");
                        arrivalCounter = arrivalCounter + processQueue.get(i).burstTime;
                        processQueue.remove(i);
                        i--;
                    }

                }

            }

        } else if (Objects.equals(algorithmName, "RR")) {
            System.out.println("time quantum:");
            timeQuantum = input.nextInt();
            int minArrival = Integer.MAX_VALUE;
            ArrayList<ProcessFIFORoundRobin> p2 = new ArrayList<ProcessFIFORoundRobin>();
            ProcessFIFORoundRobin process = new ProcessFIFORoundRobin();
            ArrayList<ProcessFIFORoundRobin> processQueue = new ArrayList<ProcessFIFORoundRobin>();
            for (int i = 0; i < numOfProcess; i++) {
                ProcessFIFORoundRobin p = new ProcessFIFORoundRobin();
                p.name = input.next();
                p.arrivalTime = input.nextInt();
                p.burstTime = input.nextInt();
                processQueue.add(p);
                if (minArrival > p.arrivalTime) {
                    process = p;
                    minArrival = p.arrivalTime;
                }
            }
            p2.add(process);
            int n = numOfProcess;
            processQueue.remove(0);

            ProcessFIFORoundRobin currentProcess = new ProcessFIFORoundRobin();
            while (n > 0) {
                if (p2.size() == 0) {

                    int min = Integer.MAX_VALUE;
                    int index = 0;
                    ProcessFIFORoundRobin pro = new ProcessFIFORoundRobin();
                    for (int i = 0; i < processQueue.size(); i++) {
                        if (min > processQueue.get(i).arrivalTime) {
                            min = processQueue.get(i).arrivalTime;
                            pro = processQueue.get(i);
                            index = i;
                        }
                    }
                    minArrival = min;
                    p2.add(pro);
                    processQueue.remove(index);

                }
                if (p2.get(0).burstTime <= timeQuantum) {
                    int f = p2.get(0).burstTime + minArrival;
                    System.out.println(p2.get(0).name + "(" + minArrival + "-" + f + ")");
                    minArrival = f;
                    p2.remove(0);
                    for (int i = 0; i < processQueue.size(); i++) {
                        if (processQueue.get(i).arrivalTime <= minArrival) {
                            p2.add(processQueue.get(i));
                            processQueue.remove(i);
                        }
                    }
                    n--;
                } else {
                    currentProcess = p2.get(0);
                    int f = timeQuantum + minArrival;
                    System.out.println(p2.get(0).name + "(" + minArrival + "-" + f + ")");
                    p2.get(0).burstTime = p2.get(0).burstTime - timeQuantum;
                    minArrival = f;
                    p2.remove(0);


                    for (int i = 0; i < processQueue.size(); i++) {
                        if (processQueue.get(i).arrivalTime <= minArrival) {
                            p2.add(processQueue.get(i));
                            processQueue.remove(i);
                            i--;
                        }


                    }

                    p2.add(currentProcess);

                }
            }


        } else if (Objects.equals(algorithmName, "EDF")) {
            ArrayList<ProcessEDF> processQueue = new ArrayList<ProcessEDF>();
            ArrayList<ProcessEDF> p2 = new ArrayList<ProcessEDF>();
            for (int i = 0; i < numOfProcess; i++) {
                ProcessEDF p = new ProcessEDF();
                p.name = input.next();
                p.burstTime = input.nextInt();
                p.periodTime = input.nextInt();
                p.deadline = new ArrayList<Integer>();
                processQueue.add(p);
            }

            int startTime = 0;
            int endTime = 0;

            for (int i = 0; i < processQueue.size(); i++) {
                for (int j = 0; j <= 200; j++) {
                    if (j % processQueue.get(i).periodTime == 0) {
                        processQueue.get(i).deadline.add(j);

                    }
                }
                processQueue.get(i).deadline.add(1000);
            }


            boolean flag = true;
            boolean flag2 = true;
            boolean flag3 = true;
            int busrtTime = 0;
            int deadline = 0;
            int index = 0;
            ProcessEDF p0 = new ProcessEDF();
            for (int i = 0; i <= 150; i++) {

                for (int j = 0; j < numOfProcess; j++) {
                    if (i % processQueue.get(j).periodTime == 0) {
                        processQueue.get(j).deadline.remove(0);
                        p2.add(processQueue.get(j));
                    }
                }


                if (flag) {
                    int nearestDeadline = Integer.MAX_VALUE;

                    for (int j = 0; j < p2.size(); j++) {
                        for (int k = 0; k < p2.get(j).deadline.size(); k++) {
                            if (nearestDeadline > p2.get(j).deadline.get(k)) {
                                nearestDeadline = p2.get(j).deadline.get(k);
                                index = j;

                            }

                        }
                    }

                    if (p0 != p2.get(index)) {
                        for (int j = 0; j <p2.size() ; j++) {
                            if(p2.get(j)==p0){
                                p2.get(j).burstTime=busrtTime;
                            }
                        }
                        p0 = p2.get(index);
                        busrtTime = p2.get(index).burstTime;
                        startTime = i;
                    }


                    flag = false;

                }

                if (flag2) {
                    deadline = Integer.MAX_VALUE;
                    for (int j = 0; j < processQueue.size(); j++) {
                        for (int k = 0; k < processQueue.get(j).deadline.size(); k++) {
                            if (deadline > processQueue.get(j).deadline.get(k)) {
                                if (processQueue.get(j).deadline.get(k) > i) {
                                    deadline = processQueue.get(j).deadline.get(k);
                                }
                            }
                        }
                        flag2 = false;
                    }
                }
                    if (i == deadline-1) {
                        flag = true;
                        flag2 = true;
                        if(p0.deadline.get(0)==deadline || busrtTime==1)
                                p2.remove(p0);
                        else{

                            busrtTime=busrtTime-1;
                        }
                        endTime=i+1;
                        System.out.println(p0.name+"("+startTime+"-"+endTime+")");
                    } else {
                        if (busrtTime > 1) {
                            busrtTime--;
                        } else if (busrtTime == 1) {
                            flag = true;
                            p2.remove(p0);
                            endTime=i+1;
                            busrtTime=0;
                            System.out.println(p0.name+"("+startTime+"-"+endTime+")");
                        }

                    }

                }


            }

        }
    }