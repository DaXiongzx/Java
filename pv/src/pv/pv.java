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
class syn{//PV������
     int count=0;//�ź���
     syn(){}
     syn(int a){count=a;}
     public synchronized void Wait(){ //�ؼ��� synchronized ��֤�˴˲�����һ��Դ�ڲ���
         count--;
         if(count<0){//����0 ����һ�����̽������ٽ���
             try {         //С��0��abs(count)=�����Ľ�����Ŀ ���������߳�
                 this.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();  
             }  
         }  
     }  
     public synchronized void Signal(){   //�ؼ��� synchronized ��֤�˴˲�����һ����ԭ�
         count++;
         if(count<=0){//����н�������
             this.notify();
         }
     }  
}

class Global{
    static syn empty=new syn(8);
    static syn full=new syn(0);
    static int buffer []=new int[8];//������
}

//��������
class Producer implements Runnable{
    int count=0;
    public void run(){
        while(count<20){
            Global.empty.Wait();
            //�ٽ���
            int index=count%8;
            Global.buffer[index]=count;
            System.out.println("�������ڻ�����"+index+"����������Ʒ"+count);
            count++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // end of �ٽ���
            Global.full.Signal();
        }
    }
}

//��������
class Consumer implements Runnable{
    int count=0;
    public void run(){
        while(count<20){
            Global.full.Wait();
            //�ٽ���
            int index=count%8;
            int value=Global.buffer[index];
            System.out.println("�������ڻ�����"+index+"����������Ʒ"+value);
            count++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // end of �ٽ���
            Global.empty.Signal();
        }
    }
}