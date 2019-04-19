package eg.edu.alexu.csd.datastructure.linkedList;
// Abdelrahman Ibrahim Ali Hagrass   ID : 38
// Youssef Raouf Wadie        ID : 78
import java.util.*;
import java.awt.Point;
import java.lang.*;
public class Mainclass {
	public static ILinkedList[] l=new Single[30];
	static Scanner scan=new Scanner (System.in);
	
	public static int[][] intialize ()
	{
	    HashSet<Integer> taken = new HashSet<Integer>();
		int [][]arr=new int [10000][1000];
		String s=new String();
		s=scan.next();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>='0'&&s.charAt(i)<='9')
			{
				int x=0;
				int y=0;
				int j=i;
				while(s.charAt(i)>='0'&&s.charAt(i)<='9')
				{
					x=x*10+(s.charAt(i)-'0');
					i++;
					
				}
				if(s.charAt(i+1)=='-')
				{
					i+=2;
					while(s.charAt(i)>='0'&&s.charAt(i)<='9')
					{
						y=y*10+(s.charAt(i)-'0');
						i++;
						
					}
					y=999-y;
				}
				else if(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9')
				{
					i++;
					while(s.charAt(i)>='0'&&s.charAt(i)<='9')
					{
						y=y*10+(s.charAt(i)-'0');
						i++;
						
					}
				}
				else
				{
					String msg="Invalid Form of input";
					throw new RuntimeException(msg);
				}
				if(taken.contains(y))
				{
					String msg="Invalid ";
					throw new RuntimeException();
				}
				else
				{
					taken.add(y);
				}
				if(s.charAt(j-1)=='-')
				{
					arr[x][y]=-x;
				}
				else
				{
					arr[x][y]=x;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) 
	{	
		for(int i=0;i<l.length;i++)
		{
			l[i]=new Single();
		}
		Operation f=new Operation();
		boolean flag=true;
		HashSet<Character> intialized=new HashSet<Character>();
		while(flag==true)
		{
		System.out.print("Please choose an action :1>>set , 2>>print , 3>>add , 4>>subtract , 5>>multiply , 6>>evaluate , 7>>clear , else>>end ");
		int action=scan.nextInt();
		if(action==1)//set
		{
			System.out.println("Insert the variable name: A, B or C");
			char poly=scan.next().charAt(0);
			while(poly<'A'||poly>'Z')
			{
				System.out.println("Invalid variable Name");
				System.out.println("Insert the variable name: A, B or C");
				 poly=scan.next().charAt(0);
				
			}
			intialized.add(poly);
			System.out.println("Insert the polynomial terms in the form:\r\n" + 
					"(coeff1,exponent1), (coeff2,exponent2), ..\r\n");
			f.setPolynomial(poly,intialize());
			System.out.println(f.print(poly));
		}
		else if(action==2)//print
		{
			System.out.println("Insert the variable name: A, B , C or R");
			char poly=scan.next().charAt(0);
			while(l[poly-'A'].isEmpty()&&!intialized.contains(poly))
			{
				String msg="Varaible "+poly+" Not Set";
				System.out.println(msg);
				System.out.println("Insert the variable name: A, B , C or R");
				 poly=scan.next().charAt(0);

//				throw new RuntimeException(msg);
				
			}
			System.out.println(f.print(poly));
		}
		else if(action==3)//add
		{
			System.out.println("Insert the variable name: A, B or C");
			char poly=scan.next().charAt(0);
			while(l[poly-'A'].isEmpty()&&!intialized.contains(poly))
			{
				String msg="Varaible "+poly+" Not Set";
				System.out.println(msg);
				System.out.println("Insert the variable name: A, B or C");
				 poly=scan.next().charAt(0);
//				throw new RuntimeException(msg);
			}
			System.out.println("Insert the variable name: A, B or C");
			char poly2=scan.next().charAt(0);
			while(l[poly2-'A'].isEmpty()&&!intialized.contains(poly2))
			{
				String msg="Varaible "+poly2+" Not Set";
				System.out.println(msg);
				System.out.println("Insert the variable name: A, B or C");
				 poly2=scan.next().charAt(0);
//				throw new RuntimeException(msg);
			}
			f.add(poly, poly2);
			System.out.println(f.print('R'));
		}
		else if(action ==4)//subtract
		{
			System.out.println("Insert the variable name: A, B or C");
			char poly=scan.next().charAt(0);
			while(l[poly-'A'].isEmpty()&&!intialized.contains(poly))
			{
				String msg="Varaible "+poly+" Not Set";
				System.out.println(msg);
				System.out.println("Insert the variable name: A, B or C");
				 poly=scan.next().charAt(0);
//				throw new RuntimeException(msg);
			}
			System.out.println("Insert the variable name: A, B or C");
			char poly2=scan.next().charAt(0);
			while(l[poly2-'A'].isEmpty()&&!intialized.contains(poly2))
			{
				String msg="Varaible "+poly2+" Not Set";
				System.out.println(msg);
				System.out.println("Insert the variable name: A, B or C");
				 poly2=scan.next().charAt(0);
//				throw new RuntimeException(msg);
			}
			f.subtract(poly, poly2);
			System.out.println(f.print('R'));
		}
		else if(action==5)//multiply
		{
			System.out.println("Insert the variable name: A, B or C");
			char poly=scan.next().charAt(0);
			while(l[poly-'A'].isEmpty()&&!intialized.contains(poly))
			{
				String msg="Varaible "+poly+" Not Set";
				System.out.println(msg);
				System.out.println("Insert the variable name: A, B or C");
				 poly=scan.next().charAt(0);
//				throw new RuntimeException(msg);
			}
			System.out.println("Insert the variable name: A, B or C");
			char poly2=scan.next().charAt(0);
			while(l[poly2-'A'].isEmpty()&&!intialized.contains(poly2))
			{
				String msg="Varaible "+poly2+" Not Set";
				System.out.println(msg);
				System.out.println("Insert the variable name: A, B or C");
			    poly2=scan.next().charAt(0);
//				throw new RuntimeException(msg);
			}
			//(1,23),(-100,-100)
			//(1,2),(1-100),(-231,23)
			f.multiply(poly, poly2);
			System.out.println(f.print('R'));
		}
		else if(action ==6)//evaluate
		{
			System.out.println("Insert the variable name: A, B or C");
			char poly=scan.next().charAt(0);
			System.out.println("The Value");
			int value =scan.nextInt();
			while(l[poly-'A'].isEmpty()&&!intialized.contains(poly))
			{
				String msg="Varaible "+poly+" Not Set";
				System.out.println(msg);
				System.out.println("Insert the variable name: A, B or C");
			    poly=scan.next().charAt(0);
//				throw new RuntimeException(msg);
			}
			if(l[poly-'A'].isEmpty())
			{
				System.out.println('0');
				continue;
			}
			System.out.println(f.evaluatePolynomial(poly, value));
		}
		else if(action==7)//clear
		{
			System.out.println("Insert the variable name: A, B or C");
			char poly=scan.next().charAt(0);
			l[poly-'A'].clear();
		}
		else
		{   System.out.println("program terminated");
			flag=false;
		}
		}
}
}