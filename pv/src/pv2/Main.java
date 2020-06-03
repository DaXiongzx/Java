package pv2;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("�����ö�����Ŀ:");
        Scanner scan=new Scanner(System.in);
        int readNum =scan.nextInt();
        
        System.out.print("������д����Ŀ:");
        scan=new Scanner(System.in);
        int writeNum =scan.nextInt();        
        
        System.out.print("������ѭ������:");
        scan=new Scanner(System.in);
        Global.UpBound =scan.nextInt();
        
        scan.close();

        
        Reader r[]=new Reader[readNum];
        Writer w[]=new Writer[writeNum];
        int i;
        for(i=0;i<readNum;i++){
            r[i]=new Reader(i+1);
        }
        for(i=0;i<writeNum;i++){
            w[i]=new Writer(i+1);
        }
        Thread []r_t=new Thread[readNum];
        Thread []w_t=new Thread[writeNum];
        for(i=0;i<readNum;i++){
            r_t[i]=new Thread(r[i]);
        }        
        for(i=0;i<writeNum;i++){
            w_t[i]=new Thread(w[i]);
        }
        for(i=0;i<writeNum;i++){
            w_t[i].start();
        }    
        for(i=0;i<readNum;i++){
            r_t[i].start();
        }    
        

    
    }

}

class syn{//PV������
    int count=0;//�ź���
    syn(){}
    syn(int a){count=a;}
    public synchronized void Wait(){ //�ؼ��� synchronized ��֤�˴˲�����һ����ԭ�
        count--;
        if(count<0){//����0 ����һ�����̽������ٽ���
            try {         //С��0��abs(count)=�����Ľ�����Ŀ
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  
            }  
        }  
    }  
    public synchronized void Signal(){   //�ؼ��� synchronized ��֤�˴˲�����һ����ԭ�
        count++;
        if(count<=0){//����н�������
            this.notify();//All
        }
    }  
}

class Global{
    static syn rmutex=new syn(1);//��������ߡ���readcount���С����⡿����
    static syn mutex=new syn(1);//�����д�ߡ������������С����⡿����
    static int dataZone=0;    //������
    static int readcount=0;    //���ڼ�¼���ߵ�����
    static int data=0;
    static int UpBound=20;
}

class Reader implements Runnable{//����
    int ID=0;
    Reader(){}
    Reader(int id){ID=id;}
    public void run(){
        while(Global.data<=Global.UpBound){
            //��readcount���в���
            Global.rmutex.Wait();
            if(Global.readcount==0){//���ǵ�һ�����ߣ�Ӧ����ֹд�ߵĽ���
                Global.mutex.Wait();
            }
            Global.readcount++;//������������
            Global.rmutex.Signal();
            //��readcount��������
            
            /*
             * ���ж�����
             */
            int readData=Global.dataZone;
            System.out.println("����"+ID+"����������:"+readData);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*
             * ����������
             */
            
            //��readcount���в���
            Global.rmutex.Wait();
            Global.readcount--;//������������
            if(Global.readcount==0){//�������һ�����ߣ�����д��
                Global.mutex.Signal();
            }
            Global.rmutex.Signal();
            //��readcount��������
        }
    }
}

class Writer implements Runnable{//д��
    int ID=0;
    Writer(){}
    Writer(int id){ID=id;}
    public void run(){
        while(Global.data<=Global.UpBound){
            Global.mutex.Wait();    //��������������з���
            /*
             * ����д����
             */
            Global.data++;
            int writeData=Global.data;
            System.out.println("д��"+ID+"д��������:"+writeData);
            Global.dataZone=Global.data;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            /*
             * ����д����
             */
            Global.mutex.Signal();    //�ͷ��������������������̶�д
        }
    }
}