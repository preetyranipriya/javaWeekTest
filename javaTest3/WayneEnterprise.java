package javaTest3;

import java.util.*;
import java.util.concurrent.*;

class Order
{ 
	Random random=new Random();
	int cargoWeight;
	String destination;
	public Order() {
		super();
		this.cargoWeight = random.nextInt(41)+10;
		this.destination = random.nextBoolean()?"Gotham":"Atlanta";
	}
	public int getCargoWeight() {
		return cargoWeight;
	}
	
	public String getDestination() {
		return destination;
	}
}
class Wayne extends Thread
{ 
	  static int order_cost=1000;
	 static int canceled_order_penalty=250;
	  static int target_earning=1000000;
	  static int totalEarning=0;
	 static int totalOrderDelivered=0;
	 static int totalOrderCanceled=0;
	 static int trip=0;
	 
	
	 public Wayne() {
		
		this.order_cost = 1000;
		this.canceled_order_penalty =250;
		this.target_earning = 1000000;
		this.totalEarning = 0;
		this.totalOrderDelivered =0;
		this.totalOrderCanceled = 0;
		this.trip = 0;
		imp();
	 }
		
	static BlockingQueue<Order>orderQueue=new LinkedBlockingQueue<>();
	 static BlockingQueue<Integer> shipQueue=new LinkedBlockingQueue<>();
	public int getOrder_cost() {
		return order_cost;
	}
	public void setOrder_cost(int order_cost) {
		this.order_cost = order_cost;
	}
	public int getCanceled_order_penalty() {
		return canceled_order_penalty;
	}
	public void setCanceled_order_penalty(int canceled_order_penalty) {
		this.canceled_order_penalty = canceled_order_penalty;
	}
	public int getTarget_earning() {
		return target_earning;
	}
	public void setTarget_earning(int target_earning) {
		this.target_earning = target_earning;
	}
	public int getTotalEarning() {
		return totalEarning;
	}
	public void setTotalEarning(int totalEarning) {
		this.totalEarning = totalEarning;
	}
	public int getTotalOrderDelivered() {
		return totalOrderDelivered;
	}
	public void setTotalOrderDelivered(int totalOrderDelivered) {
		this.totalOrderDelivered = totalOrderDelivered;
	}
	public int getTotalOrderCanceled() {
		return totalOrderCanceled;
	}
	public void setTotalOrderCanceled(int totalOrderCanceled) {
		this.totalOrderCanceled = totalOrderCanceled;
	}
	public int getTrip() {
		return trip;
	}
	public void setTrip(int trip) {
		this.trip = trip;
	}
	static void imp()
    { 
  	  for(int i=0;i<5;i++)
  		  shipQueue.add(0);
    }
	void print()
	{ 
		System.out.println(getTotalOrderDelivered());
		System.out.println( getTotalOrderCanceled());
		System.out.println(getTotalEarning());
		
	}
	
}
class Ship extends Wayne implements Runnable
{  
	public void run() { 
			while(true)
			{
			try
			{ 
				int weight=shipQueue.take();
				Order order=orderQueue.take();
				int cargoweight=order.cargoWeight;
				weight=weight+cargoweight;
				shipQueue.put(weight);
				setTotalEarning(getTotalEarning()+order_cost);
				if(weight>=50 && weight<=300)
				{ 
					
					setTrip(getTrip()+1);
					
				}
				//				

			synchronized(this)
			{  
				if (getTrip() == 5) {
		            try {
		                System.out.println("Ship is going for maintenance.");
		                Thread.sleep(60000);
		                System.out.println("Ship is back from maintenance.");
		                 setTrip(0);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				}
	

				System.out.println(getTotalEarning());
				
				


				
				
				if(getTotalEarning()>=target_earning)
				{ 
					System.out.println(" Shipping Done");
					print();
					System.exit(0);
				}
								
				
				
				
			}
			//notify();
			}
			
			catch(InterruptedException e)
			{ 
				e.printStackTrace();
			}
		 }
	}
	}
class PickCargo extends Wayne implements Runnable
{
public void run() {
		
		while(true)
		{ 
			try { 
				long start=System.currentTimeMillis();
				Order order =new Order();
				orderQueue.put(order);
				
				long finish=System.currentTimeMillis();
				long timeTaken=finish-start;
				

			     if(timeTaken>60000)
				{ 
					setTotalOrderCanceled(getTotalOrderCanceled()+1);
					setTotalEarning(getTotalEarning()-canceled_order_penalty);
				}
			     Thread.sleep(100);

			
				
				
				
			
				synchronized(this)
				{ 
					
				 if(getTotalEarning()>=target_earning)
					{ 
						System.out.println(" Thread Done");
						print();
						System.exit(0);
					}
					
					
				
				
				}
				
				
				
				
			}
			catch(InterruptedException e)
			{ 
				e.printStackTrace();
				
				
			}
		}
		
	} 
}
class WayneEnterprise 
{  
	public static void main(String args[])
	{
	//Wayne w=new Wayne();
	PickCargo pickCargo=new PickCargo();
	Ship ship=new Ship();
	
	ExecutorService executor=Executors.newFixedThreadPool(5);
	executor.execute(new Runnable() {

		@Override
		public void run() {
			
		
			pickCargo.start();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
		
	});
	
	ExecutorService executor1=Executors.newFixedThreadPool(7);
	executor1.execute(new Runnable() {
		

		@Override
		public void run() {
			
			// TODO Auto-generated method stub
			ship.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		});	
	executor.shutdown();
	executor1.shutdown();
	}
	
}