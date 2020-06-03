package pv;

public class pv {
    public static void main(String[] args) {
        Producer p=new Producer();
        Consumer c=new Consumer();
        Thread pp=new Thread(p);
        Thread cp=new Thread(c);
        pp.start();
        cp.start();
    }

}
class syn{//PV操作类
     int count=0;//信号量
     syn(){}
     syn(int a){count=a;}
     public synchronized void Wait(){ //关键字 synchronized 保证了此操作是一条源于操作
         count--;
         if(count<0){//等于0 ：有一个进程进入了临界区
             try {         //小于0：abs(count)=阻塞的进程数目 则阻塞此线程
                 this.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();  
             }  
         }  
     }  
     public synchronized void Signal(){   //关键字 synchronized 保证了此操作是一条【原语】
         count++;
         if(count<=0){//如果有进程阻塞
             this.notify();
         }
     }  
}

class Global{
    static syn empty=new syn(8);
    static syn full=new syn(0);
    static int buffer []=new int[8];//缓冲区
}

//生产者类
class Producer implements Runnable{
    int count=0;
    public void run(){
        while(count<20){
            Global.empty.Wait();
            //临界区
            int index=count%8;
            Global.buffer[index]=count;
            System.out.println("生产者在缓冲区"+index+"中生产了物品"+count);
            count++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // end of 临界区
            Global.full.Signal();
        }
    }
}

//消费者类
class Consumer implements Runnable{
    int count=0;
    public void run(){
        while(count<20){
            Global.full.Wait();
            //临界区
            int index=count%8;
            int value=Global.buffer[index];
            System.out.println("消费者在缓冲区"+index+"中消费了物品"+value);
            count++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // end of 临界区
            Global.empty.Signal();
        }
    }
}