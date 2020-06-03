package pv2;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("请设置读者数目:");
        Scanner scan=new Scanner(System.in);
        int readNum =scan.nextInt();
        
        System.out.print("请设置写者数目:");
        scan=new Scanner(System.in);
        int writeNum =scan.nextInt();        
        
        System.out.print("请设置循环上限:");
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

class syn{//PV操作类
    int count=0;//信号量
    syn(){}
    syn(int a){count=a;}
    public synchronized void Wait(){ //关键字 synchronized 保证了此操作是一条【原语】
        count--;
        if(count<0){//等于0 ：有一个进程进入了临界区
            try {         //小于0：abs(count)=阻塞的进程数目
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  
            }  
        }  
    }  
    public synchronized void Signal(){   //关键字 synchronized 保证了此操作是一条【原语】
        count++;
        if(count<=0){//如果有进程阻塞
            this.notify();//All
        }
    }  
}

class Global{
    static syn rmutex=new syn(1);//多个【读者】对readcount进行【互斥】访问
    static syn mutex=new syn(1);//多个【写者】对数据区进行【互斥】访问
    static int dataZone=0;    //数据区
    static int readcount=0;    //用于记录读者的数量
    static int data=0;
    static int UpBound=20;
}

class Reader implements Runnable{//读者
    int ID=0;
    Reader(){}
    Reader(int id){ID=id;}
    public void run(){
        while(Global.data<=Global.UpBound){
            //对readcount进行操作
            Global.rmutex.Wait();
            if(Global.readcount==0){//这是第一个读者，应该阻止写者的进入
                Global.mutex.Wait();
            }
            Global.readcount++;//读者数量增减
            Global.rmutex.Signal();
            //对readcount操作结束
            
            /*
             * 进行读操作
             */
            int readData=Global.dataZone;
            System.out.println("读者"+ID+"读出了数据:"+readData);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*
             * 结束读操作
             */
            
            //对readcount进行操作
            Global.rmutex.Wait();
            Global.readcount--;//读者数量减少
            if(Global.readcount==0){//这是最后一个读者，唤醒写者
                Global.mutex.Signal();
            }
            Global.rmutex.Signal();
            //对readcount操作结束
        }
    }
}

class Writer implements Runnable{//写者
    int ID=0;
    Writer(){}
    Writer(int id){ID=id;}
    public void run(){
        while(Global.data<=Global.UpBound){
            Global.mutex.Wait();    //申请对数据区进行访问
            /*
             * 进行写操作
             */
            Global.data++;
            int writeData=Global.data;
            System.out.println("写者"+ID+"写入了数据:"+writeData);
            Global.dataZone=Global.data;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            /*
             * 结束写操作
             */
            Global.mutex.Signal();    //释放数据区，允许其他进程读写
        }
    }
}