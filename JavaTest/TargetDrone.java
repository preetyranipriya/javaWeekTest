package JavaTest;

import java.util.ArrayList;
import java.util.Scanner;

public class TargetDrone { 
	public static void main(String args[])
	{ 
		Scanner scn=new Scanner(System.in);
		int arr[][]= { {0,3},{2,0},{3,1},{3,3}};
        System.out.println("Enter the target x coordinate");
		
		int p=scn.nextInt();
		System.out.println("Eneter the target y coordinate");
		int q=scn.nextInt();
		int drone;
		ArrayList<ArrayList<String>> ans=new ArrayList<ArrayList<String>>(); // to store all the path from drone to the target. 
		for(int i=0;i<4;i++)
		{ 
			ArrayList<String>list=new ArrayList<>(); //to store path from drone to the target
			
				// with four condition its is traversing the row and than the column.
				if(arr[i][0]<=p && arr[i][1]<=q)
				{ 
					
					drone=arr[i][0];
					list.add(Integer.toString(drone)+","+Integer.toString(arr[i][1]));
					while(p!=drone)
					{ 
						drone++;
						list.add(Integer.toString(drone)+","+Integer.toString(arr[i][1]));
						
					}
					drone=arr[i][1];
					while(q!=drone)
					{ 
						drone++;
						list.add(Integer.toString(p)+","+Integer.toString(drone));
						
					}
					
				}
				else if(arr[i][0]<=p && arr[i][1]>=q)
				{ 
					drone=arr[i][0];
					list.add(Integer.toString(drone)+","+Integer.toString(arr[i][1]));
					while(p!=drone)
					{ 
						drone++;
						list.add(Integer.toString(drone)+","+Integer.toString(arr[i][1]));
						
					}
					drone=arr[i][1];
					while(q!=drone)
					{ 
						drone--;
						list.add(Integer.toString(p)+","+Integer.toString(drone));
						
					}
					
				}
				else if(arr[i][0]>=p && arr[i][1]>=q)
				{ 
					drone=arr[i][0];
					list.add(Integer.toString(drone)+","+Integer.toString(arr[i][1]));
					while(p!=drone)
					{ 
						drone--;
						list.add(Integer.toString(drone)+","+Integer.toString(arr[i][1]));
						
					}
					drone=arr[i][1];
					while(q!=drone)
					{ 
						drone--;
						list.add(Integer.toString(p)+","+Integer.toString(drone));
						
					}
					
				}
				else if(arr[i][0]>=p && arr[i][1]<=q)
				{ 
					drone=arr[i][0];
					list.add(Integer.toString(drone)+","+Integer.toString(arr[i][1]));
					while(p!=drone)
					{ 
						drone--;
						list.add(Integer.toString(drone)+","+Integer.toString(arr[i][1]));
						
					}
					drone=arr[i][1];
					while(q!=drone)
					{ 
						drone++;
						list.add(Integer.toString(p)+","+Integer.toString(drone));
						
					}
					
				}
				ans.add(list);
			
			
		}
		for(ArrayList<String> a:ans)
		System.out.println(a);
		
		
	}

}
