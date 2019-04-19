package eg.edu.alexu.csd.datastructure.linkedList;
import java.awt.Point;
public class Operation implements IPolynomialSolver {
	private static ILinkedList [] l=Mainclass.l;
	public void setPolynomial(char poly, int[][] arr) {
		l[poly-'A'].clear();
		for(int i=0;i<arr[i].length/2;i++)//exponent
		{
			for(int j=0;j<arr.length;j++)//coff
			{
				if(arr[j][i]!=0)
				{
					int x=arr[j][i];
					Point a=new Point(x,i);
					l[poly-'A'].add(0,a);
				}
				if(arr[j][999-i]!=0&&i!=0)
				{
					int x=arr[j][999-i];
					Point a=new Point(x,-i);
					l[poly-'A'].add(a);
				}
			}
		}
	}
	@Override
	public String print(char poly) {
		String s=new String();
		for(int i=0;i<l[poly-'A'].size();i++)
		{
			Point b=(Point)l[poly-'A'].get(i);
			if(b.x<0)
			{
				s+=" - ";
			}
			else if(b.x>0&&i!=0)
			{
				s+=" + ";
			}
			if(b.y==0)
			{
				if(Math.abs(b.x)==1)
				{
					s+=Math.abs(b.x);
				}
			}
			if(Math.abs(b.x)!=1)
			{
				s+=Math.abs(b.x);
			}
			if(b.y!=1&&b.y!=0)
			{
				s+="x^"+b.y;
			}
			else if(b.y==1&&b.y!=0)
			{
				s+="x";
			}
		}
		return s;
	}

	@Override
	public void clearPolynomial(char poly) {
		l[poly-'A'].clear();
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		float ans=0;
		for(int i=0;i<l[poly-'A'].size();i++)
		{
			Point b=new Point();
			b=(Point)l[poly-'A'].get(i);
			ans+=(b.x)*(Math.pow(value, b.y));
		}
		return ans;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		int [][] ans=new int[1000][1000];
		int i=0;
		int j=0;
		while(l[poly1-'A'].get(i)!=null&&l[poly2-'A'].get(j)!=null)
		{
			Point a=(Point)l[poly1-'A'].get(i);
			Point b=(Point)l[poly2-'A'].get(j);
			if(a.y==b.y)
			{
				if(a.y>=0)
				{
					ans[Math.abs(b.x+a.x)][a.y]=b.x+a.x;
				}
				else
				{
					ans[Math.abs((b.x+a.x))][999+a.y]=(b.x+a.x);
				}
				i++;
				j++;
			}
			else if(a.y>b.y)
			{
				if(a.y>=0)
				{
					ans[Math.abs(a.x)][a.y]=a.x;
				}
				else
				{
					ans[Math.abs(a.x)][999+a.y]=(a.x);
				}
				i++;
			}
			else if(b.y>a.y)
			{
				if(b.y>=0)
				{
					ans[Math.abs(b.x)][b.y]=b.x;
				}
				else
				{
					ans[Math.abs(b.x)][999+b.y]=(b.x);
				}
				j++;
			}
		}
		if(l[poly1-'A'].get(i)!=null)
		{
			while(l[poly1-'A'].get(i)!=null)
			{
				Point a=(Point)l[poly1-'A'].get(i);
				if(a.y>=0)
				{
					ans[Math.abs(a.x)][a.y]=a.x;
				}
				else
				{
					ans[Math.abs(a.x)][999+a.y]=(a.x);
				}
				i++;

			}
		}
		else
		{
			while(l[poly2-'A'].get(j)!=null)
			{
				Point a=(Point)l[poly2-'A'].get(j);
				if(a.y>=0)
				{
					ans[Math.abs(a.x)][a.y]=a.x;
				}
				else
				{
					ans[Math.abs(a.x)][999+a.y]=(a.x);
				}
				j++;
			}
		}
		setPolynomial('R',ans);
		return ans;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		int [][] ans=new int[1000][1000];
		int i=0;
		int j=0;
		if(l[poly1-'A'].isEmpty())
		{
			String msg="Varaible "+poly1+" Not Set";
			throw new RuntimeException(msg);
		}
		if(l[poly2-'A'].isEmpty())
		{
			String msg="Varaible "+poly2+" Not Set";
			throw new RuntimeException(msg);
		}
		while(l[poly1-'A'].get(i)!=null&&l[poly2-'A'].get(j)!=null)
		{
			Point a=(Point)l[poly1-'A'].get(i);
			Point b=(Point)l[poly2-'A'].get(j);
			if(a.y==b.y)
			{
				if(a.y>=0)
				{
					ans[Math.abs(a.x-b.x)][a.y]=a.x-b.x;
				}
				else
				{
					ans[Math.abs((a.x-b.x))][999+a.y]=(a.x-b.x);
				}
				i++;
				j++;
			}
			else if(a.y>b.y)
			{
				if(a.y>=0)
				{
					ans[Math.abs(a.x)][a.y]=a.x;
				}
				else
				{
					ans[Math.abs(a.x)][999+a.y]=(a.x);
				}
				i++;
			}
			else if(b.y>a.y)
			{
				if(b.y>=0)
				{
					ans[Math.abs(b.x)][b.y]=-b.x;
				}
				else
				{
					ans[Math.abs(b.x)][999+b.y]=-(b.x);
				}
				j++;
			}
		}
		if(l[poly1-'A'].get(i)!=null)
		{
			while(l[poly1-'A'].get(i)!=null)
			{
				Point a=(Point)l[poly1-'A'].get(i);
				if(a.y>=0)
				{
					ans[Math.abs(a.x)][a.y]=a.x;
				}
				else
				{
					ans[Math.abs(a.x)][999+a.y]=(a.x);
				}
				i++;

			}
		}
		else
		{
			while(l[poly2-'A'].get(j)!=null)
			{
				Point a=(Point)l[poly2-'A'].get(j);
				if(a.y>=0)
				{
					ans[Math.abs(a.x)][a.y]=-a.x;
				}
				else
				{
					ans[Math.abs(a.x)][999+a.y]=-(a.x);
				}
				j++;
			}
		}

		setPolynomial('R',ans);
		return ans;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		if(l[poly1-'A'].isEmpty())
		{
			String msg="Varaible "+poly1+" Not Set";
			throw new RuntimeException(msg);
		}
		if(l[poly2-'A'].isEmpty())
		{
			String msg="Varaible "+poly2+" Not Set";
			throw new RuntimeException(msg);
		}
		int [][] ans=new int[1000][1000];
		for(int i=0;i<l[poly1-'A'].size();i++)
		{
			Point a=(Point)l[poly1-'A'].get(i);
			for(int j=0;j<l[poly2-'A'].size();j++)
			{
				Point b=(Point)l[poly2-'A'].get(j);
				if(a.y+b.y>=0)
				{
					ans[Math.abs(a.x*b.x)][a.y+b.y]=a.x*b.x+ans[Math.abs(a.x*b.x)][a.y+b.y];
				}
				else
				{
					ans[Math.abs(a.x*b.x)][999-(a.y+b.y)]=a.x*b.x+ans[Math.abs(a.x*b.x)][999-(a.y+b.y)];
				}
			}
		}
		for(int i=0;i<ans.length;i++)//exp
		{
			int sum=0;
			for(int j=0;j<ans.length;j++)
			{
				if(ans[j][i]!=0)
				{
					sum+=ans[j][i];
					ans[j][i]=0;
				}
				
			}
			ans[Math.abs(sum)][i]=sum;
		}
		setPolynomial('R',ans);
		return ans;
	}

}
