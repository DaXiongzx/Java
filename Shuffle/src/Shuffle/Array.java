package Shuffle;
import java.util.Random;
public class Array {
	String [][] arr= {{9,9,9},{9,9,9},{9,9,9}};
	//int [][] arr= {{1,2,3},{4,5,6},{7,0,8}};
	int min=0;
	int max=9;
	public int createrandom() {
		Random random=new Random();
		int s=random.nextInt(max)%(max-min+1)+min;
		return s;
	}//create a set of random numbers
	public boolean repeat(int num) {//判断是否重复
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(arr[i][j]==num) return false;
			}
		}
		return true;
	}
	public void initarray() {
		int rand;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				rand=createrandom();
				if((repeat(rand))) {
					arr[i][j]=rand;
				}
				else {
					j--;
				}
			}
		}
	}


	public void show() {
		initarray();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.print('\n');
		}
	}
	public boolean judge() {
		int [][]b= {{1,2,3},{4,5,6},{7,8,0}};
		int t=1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if (arr[i][j]==b[i][j]) continue;
				else return false;
				
			}
		}
		return true;
	}
	/*public void swap(int num1,int num2) {//交换两个数
		int t;
		t=num1;
		num1=num2;
		num2=t;
	}*/
	public void swap1() {//与左边的数交换
		int t=0;
		for(int i=0;i<3;i++) {
			if(t==1) break;
			for(int j=0;j<3;j++) {
				if(arr[i][j]==0) {
					if(j==0) {
						break;
					}
					else {
						int t1;
						t1=arr[i][j];
						arr[i][j]=arr[i][j-1];
						arr[i][j-1]=t1;
					t=1;
					break;
				}
			}
		}
	}
	}
	public void swap2() {//与右边的数进行交换
		int t=0;
		for(int i=0;i<3;i++) {
			if(t==1) break;
			for(int j=0;j<3;j++) {
				if(arr[i][j]==0) {
					if(j==2) {//越界问题解决方案
					   break;
					}
					else {
						int t1;
						t1=arr[i][j];
						arr[i][j]=arr[i][j+1];
						arr[i][j+1]=t1;
					t=1;
					break;
				}
			}
		}
	}
	}
	public void swap3() {//与上边的数进行交换
		int t=0;
		for(int i=0;i<3;i++) {
			if(t==1) break;
			for(int j=0;j<3;j++) {
				if(arr[i][j]==0) {
					if(i==0) {
						//i--;
						break;
					}
					else {
						int t1 = 0;
						t=arr[i][j];
						arr[i][j]=arr[i-1][j];
						arr[i-1][j]=t1;
					t=1;
					break;
				}
			}
		}
	}
	}
	public void swap4() {//与下边的数进行交换
		int t=0;
		for(int i=0;i<3;i++) {
			if(t==1) break;
			for(int j=0;j<3;j++) {
				if(arr[i][j]==0) {
					if(i==2) 
					{
						break;
					}
					else {
						int t1;
						t1=arr[i][j];
						arr[i][j]=arr[i+1][j];
						arr[i+1][j]=t1;
					t=1;
					break;
				}
			}
		}
	}
}

}
