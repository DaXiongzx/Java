package ch3;

import java.lang.reflect.Field;

class TaskProcessor<T> {
	private T message;
	public TaskProcessor(T intask)
	{
		message=intask;
	}
        public void printResult(){
        	try
    		{	
    			Field namefield=message.getClass().getDeclaredField("name");
    			Object nameValue=namefield.get(message);
    			Field timefield=message.getClass().getDeclaredField("time");
    			Object timeValue=timefield.get(message);
    			Field locfield=message.getClass().getDeclaredField("location");
    			Object locValue=locfield.get(message);
    			Field receiverField=message.getClass().getDeclaredField("receiver");  			
    			Object receiverValue=receiverField.get(message);   		
    			System.out.println("==========================================");
    			System.out.println("Name: "+nameValue);
    			System.out.println("Time: "+timeValue);
    			System.out.println("Location: "+locValue);
    			System.out.println("Content: "+receiverValue);
    		}
    		catch(Exception ex)
    		{
    			ex.printStackTrace();
    		}
        }
}
