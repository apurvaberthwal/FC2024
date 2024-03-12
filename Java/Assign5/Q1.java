 class MyThread extends Thread{
  
String str;
public MyThread(String s)
{
str=s;  
}
public void run()
{
while(true)
{   System.out.println((Thread.currentThread()).getName()+" "+"Message: "+str);
System.out.println((Thread.currentThread()).getName()+" "+"Priority:  "+(Thread.currentThread()).getPriority());
try
{
Thread.sleep(1000);
}
catch(InterruptedException ie)
{ 
System.out.println(ie.toString());
}           
}
}
}
public class Q1
{
public static void main(String args[])
{
MyThread t1= new MyThread("Thread 1 Hello");
MyThread t2= new MyThread("Thread 2 Hii");    
t1.setName("Thread 1");   
t2.setName("Thread 2");
System.out.println("Details of the Threads in running state....");
t1.start();
t2.start();
}
}

