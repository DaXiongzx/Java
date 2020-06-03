package oskeshe;

import java.util.Scanner;

class yemian 
{
	private int no = 0;
	private int page;
	private boolean use = true;
	
	void setPage(int page)
	{
		this.page=page;
	}
	
	int getPage()
	{
		return this.page;
	}
	
	void setUse(boolean use)
	{
		this.use=use;
	}
	
	boolean getUse()
	{
		return this.use;
	}

	public yemian(int no)
	{
		this.no=no;
	}
}


public class clock
{
	public int max=3;//页框数量
	public yemian []ye = new yemian [max];
	public int sequence[] = {1,2,3,4,5,6};
	public static int point = 0;
	public boolean stop = false;
	String clockresult1="";
	public clock()
	{
		for(int i=0;i<this.max;i++)
		{
			ye[i]=new yemian(i);
		}
	}
	
	public  void huoqu()
	{
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<sequence.length;i++)
		{
			sequence[i] = sc.nextInt();
		}
	}
	
	public void clock()
	{
		for(int i=0;i<sequence.length;i++)
		{
			for(int j=0;j<max;j++)
			{
				if(ye[j].getPage()==sequence[i])
				{
					this.stop=true;
					ye[j].setUse(true);
					break;
				}
			}
			
			if(this.stop==true)
			{
				this.stop=false;
				continue;
			}
			
			for(int j=0;j<max;j++)
			{	
				if(ye[j].getPage()==0)
				{
					ye[j].setPage(sequence[i]);
					ye[j].setUse(true);
					break;
				}
				else if(ye[max-1].getPage()!=0)//队列满，开始运用clock
				{	
					while(true)
					{
						if(this.point==max)
							this.point=0;
						
						if(ye[this.point].getUse()==true)
						{
							ye[this.point].setUse(false);
							this.point++;
						}
						else if(ye[this.point].getUse()==false)
						{
							ye[this.point].setPage(sequence[i]);
							ye[this.point].setUse(true);
							this.point++;
							this.stop=true;
							break;
						}
					}
					
					if(this.stop==true)
					{
						this.stop=false;
						break;
					}
				}
			}
			
			for(int r=0;r<max;r++)
			{
				if(ye[r].getPage()==0)
					break;
				clockresult1=clockresult1+ye[r].getPage()+" ";
				System.out.print(ye[r].getPage()+" ");
			}
			System.out.print("\n");
			clockresult1=clockresult1+"\n";
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clock gg = new clock();
		System.out.println("please input the sequence:");
		gg.huoqu();
		gg.clock();
	}

}
