import java.util.ArrayList;
import java.util.Scanner;

class LRUOSC{
    int value;
    long time;
}
class SC{
    int value;
    long time;
    int bit;
}
public class Main {

    public static int FIFO(int number,ArrayList<Integer> fifo,int count,int frame){
        boolean flag=true;
        for (int i = 0; i <fifo.size() ; i++) {
            if(number==fifo.get(i))
            {
                flag=false;
            }
        }

        if(flag){
            if(fifo.size()<frame){
                fifo.add(number);
                count++;
            }
            else{
                fifo.remove(0);
                fifo.add(number);
                count++;
            }
        }

        for (int i = 0; i < fifo.size(); i++) {
            System.out.print(fifo.get(i));
            System.out.print("-");
        }
        System.out.println();
       return count;

    }


    public static int LRU(int number,long time,ArrayList<LRUOSC> lru,int count,int frame){
        boolean flag=true;
        for (int i = 0; i < lru.size(); i++) {
            if(number==lru.get(i).value){
                lru.get(i).time=time;
                flag=false;
            }
        }
        if(flag){
            if(lru.size()<frame)
            {
                LRUOSC lr=new LRUOSC();
                lr.value=number;
                lr.time=time;
                lru.add(lr);
                count++;
            }

            else{
                long minTime=Long.MAX_VALUE;
                int minIndex=0;
                for (int i = 0; i <lru.size() ; i++) {
                    if(lru.get(i).time<minTime){
                        minIndex=i;
                        minTime=lru.get(i).time;

                    }
                }
                lru.remove(minIndex);
                LRUOSC lr=new LRUOSC();
                lr.value=number;
                lr.time=time;
                lru.add(lr);
                count++;
            }
        }
        for (int i = 0; i < lru.size(); i++) {
            System.out.print(lru.get(i).value);
            System.out.print("-");
        }
        System.out.println();

        return count;
    }

    public static int SCFunction(int number,long time,ArrayList<SC> sc,int count,int frame){
        boolean flag=true;
        for (int i = 0; i <sc.size() ; i++) {
            if(number==sc.get(i).value){
                sc.get(i).bit=1;
                flag=false;
            }
        }

        if(flag){
            if(sc.size()<frame){
                SC SChance=new SC();
                SChance.time=time;
                SChance.value=number;
                SChance.bit=1;
                sc.add(SChance);
                count++;
            }
            else{
                int index=0;
                int countNumber=0;
                while(countNumber<sc.size()){
                    if(sc.get(index).bit==0){
                        sc.remove(index);
                        break;
                    }
                    else {

                        SC newsc = new SC();
                        newsc = sc.get(index);
                        newsc.bit = 0;
                        sc.remove(index);
                        sc.add(newsc);

                    }
                    countNumber++;
                }

                if(countNumber==sc.size()){
                    sc.remove(0);
                }

                SC secondC=new SC();
                secondC.value=number;
                secondC.bit=1;
                secondC.time=time;
                sc.add(secondC);
                count++;
            }
        }
        for (int i = 0; i <sc.size() ; i++) {
            System.out.print(sc.get(i).value);
            System.out.print("-");
        }
        System.out.println();

        return count;
    }


    public static void main(String[] args) {

        ArrayList<Integer> FIFOAl=new ArrayList<Integer>();
        ArrayList<SC> SCAl=new ArrayList<SC>();
        ArrayList<LRUOSC> LRUAl=new ArrayList<LRUOSC>();

        int countFifo=0;
        int countLRU=0;
        int countSC=0;
        int amount;
        Scanner input = new Scanner(System.in);
        System.out.println("frame : ");
        int frame=input.nextInt();
        amount=input.nextInt();
        long time=System.currentTimeMillis();
        while(amount!=-1){

            System.out.println("FIFO : ");
            countFifo=FIFO(amount,FIFOAl,countFifo,frame);
            System.out.println("LRU : ");
            countLRU=LRU(amount,time,LRUAl,countLRU,frame);
            System.out.println("S_CHANCE : ");
            countSC=SCFunction(amount,time,SCAl,countSC,frame);
            amount=input.nextInt();
            time=System.currentTimeMillis();

        }
        System.out.println("FIFO PAGE FAULT :"+countFifo);
        System.out.println("LRU PAGE FAULT :"+countLRU);
        System.out.println("SECOND-CHANCE PAGE FAULT :"+countSC);



    }

}