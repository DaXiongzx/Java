package oskeshe;
import java.util.*;

public class FIFO {
	
	public int yekuang = 3;
	public int queue[] = new int[this.yekuang];
	public int in = 6;
	public int input[] = {1,2,3,4,5,6};
	String FIFOresult1="";
	public void fifo()
	{

		
		
		for(int j=0;j<this.in;j++)
		{
			for(int i=0;i<this.yekuang;i++)
			{
				if(this.queue[i]==this.input[j])
					break;
				
				if(this.queue[i]==0)
				{
					this.queue[i]=this.input[j];
					break;
				}
				else if(this.queue[this.yekuang-1]!=0)
				{
					for(int r = 0;r<this.yekuang-1;r++)
					{
						this.queue[r]=this.queue[r+1];
					}
					this.queue[this.yekuang-1]=this.input[j];
					break;
				}
			}
			
			for(int r=0;r<this.yekuang;r++)
			{
				if(this.queue[r]==0)
					break;
				FIFOresult1=FIFOresult1+this.queue[r]+" ";
				System.out.print(this.queue[r]);
			}
			FIFOresult1=FIFOresult1+"\n";
			System.out.print("\n");
		}
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		FIFO gg = new FIFO();
//		gg.fifo();
//	}

}
