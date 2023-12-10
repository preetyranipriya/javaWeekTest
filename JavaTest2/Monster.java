package JavaTest2;


import java.lang.reflect.*;
import java.util.*;

public class Monster { 
	
	static HashMap<Integer,List<String>> map=new HashMap<>(); //to store the individual parents properties
	static HashMap<String,List<String>> child=new HashMap<>(); // to store all the unique child created.
	static int parent=1;  //no of parent entered.
	
	public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException
	{ 
		MonsterProperties obj=new MonsterProperties();
		Scanner scn=new Scanner(System.in);	
		
		Field[] monster=obj.getClass().getDeclaredFields(); //using reflection collecting the field of monsterProperties class.
		System.out.println("enter the parents Monster Properties");
		boolean enter=true;
		while(enter!=false)
		{
			List<String>list=new ArrayList<>();
		for(Field field :monster) // setting and getting the monster properties using reflection.
		{ 
		        System.out.println("enter in the String "+field);
				String s=scn.next();
				field.setAccessible(true);
				field.set(obj, s); 
				list.add((String) field.get(obj));
		}
		System.out.println("Do you want to enter the parents answer in true or false");
		enter=scn.nextBoolean();
		
		System.out.println(list);
		map.put(parent,list);
		parent++;
		}
		parent--;
		
		child=childCreation();
		System.out.println("Final unique child with Properties of there Parents");
		System.out.print(child);
		
		
		}
	static HashMap<String,List<String>> childCreation()
	{   
		
		List<String>s1=new ArrayList<>(); 
		List<String>s2=new ArrayList<>();
		
		HashSet<List<String>>unique=new HashSet<>();
		if(parent<=1)
		{ 
			System.out.println("Only one parent");
		}
		
		else if(parent>1)
		{ 
			for(int i=1;i<=parent;i++)
			{ 
				s1=map.get(i);
				
				for(int j=i+1;j<=parent;j++)
				{ 
					List<String>childList=new ArrayList<>();
					s2=map.get(j);
					
					Random r=new Random(); //using the random to select the properties of any two parents.
					for(int k=0;k<5;k++)  //k is the number of monsterProperties it is five since  I have taken only five properties
					{
					boolean random=r.nextBoolean();
					if(random==true)
					{  
						childList.add(s1.get(k));
						
						
						
					}
					else 
					{
						childList.add(s2.get(k));
						
					}
					}
					if(!unique.contains(childList))
					{
						unique.add(childList);
					
					
						child.put(Integer.toString(i)+","+Integer.toString(j), childList);
					   System.out.println("Child of "+ Integer.toString(i)+","+Integer.toString(j)+childList);
					}
					else   // this else will execute if child properties already exit.
					{ 
						System.out.println("child of "+i+","+j+childList+"this child properties  is already exit");
					}
				}
			}
			
			
		}
		return child;
		
		
		
		
	}

}
