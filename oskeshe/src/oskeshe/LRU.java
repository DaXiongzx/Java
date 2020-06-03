package oskeshe;
public class LRU {  
	  
    public int yekuang[];  
    public int back;     
    public int total;     
    public int maxSize=3;  
    public String LRUresult1="";
    
    public LRU()
    {  
        yekuang=new int[maxSize];  
        back=0;  
        total=0;  
    }  
    public void queue(int a[])
    {  
        for(int i=0;i<a.length;i++)
        {  
            enQueue(a[i]);  
        }  
    }  
      
    public void enQueue(int x)
    {           
        take(x);                        
        if(total<maxSize)
        {  
            yekuang[back]=x;  
            back++;   
            total++;  
        }
        else if(total==maxSize)
        {        
            for(int i=0;i<maxSize-1;i++)
            {  
                yekuang[i]=yekuang[i+1];  
            }  
            yekuang[maxSize-1]=x;  
        }  
        for(int i=0;i<total;i++)
        {
        	LRUresult1=LRUresult1+yekuang[i]+" ";
            System.out.print(yekuang[i]);  
        }
        LRUresult1=LRUresult1+"\n";
        System.out.println();  
    }  
    public void take(int x)
    {          
        for(int i=0;i<total;i++)
        {  
            if(yekuang[i]==x)
            {  
                for(int j=i;j<total-1;j++)
                {  
                    yekuang[j]=yekuang[j+1];  
                }  
                total--;  
                back--;  
            }     
        }  
    }
}
