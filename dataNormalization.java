import java.util.Scanner;


public class dataNormalization
{
	public static void minMax(int arr[],int n)
	{
		int new_min=0,new_max=1,i,min=arr[0],max=arr[n-1];
		double m[]=new double[n];
		double v,temp;
		for(i=0;i<n;i++)
		{
			temp=(double)(arr[i]-min)/(max-min);
			v=(double)(temp*(new_max-new_min)+new_min);
			m[i]=v;
		}
		System.out.print("\nNormalized data by min-max normalization method : ");
		for(i=0;i<n;i++)
		{
//			System.out.format(" %.2f", m[i]);
			System.out.print(" "+m[i]);
		}
	}
	public static void zscore(int arr[],int n)
	{
		int i,sum=0;
		double z[]=new double[n];
		double mean,sd = 0,temp = 0;
		for(i=0;i<n;i++)
		{
			sum=sum+arr[i];
		}
		mean=sum/n;
		for(i=0;i<n;i++)
		{
			temp=temp+Math.pow((arr[i]-mean), 2);
			sd=Math.sqrt(temp/n);
		}
		System.out.print("\nNormalized data by Z-Score normalization method : ");
		for(i=0;i<n;i++)
		{
			z[i]=(arr[i]-mean)/sd;
			System.out.format(" %.2f",z[i]);
//			System.out.print(" "+z[i]);
		}
	}
	public static void decimalScaling(int arr[],int n)
	{
		int i,c=0,j,temp,min =100;
		double d[]=new double[n];
		int count[]=new int[n];
		for(i=0;i<n;i++)
		{
			temp=arr[i];
			while(temp>0)
			{
				temp=temp/10;
				c++;	
			}
			if(c<min)
				min=c;
//			count[i]=c;
			c=0;
		}
//		min=count[0];
//		for(i=0;i<n;i++)
//		{
//			if(count[i]<min)
//				min=count[i];
//		}
		j=min;
		System.out.print("\nNormalized data by Decimal Scaling Normalization method : ");
		for(i=0;i<n;i++)
		{
			d[i]=arr[i]/Math.pow(10,j);
			System.out.print(" "+d[i]);
		}
	}
	public static void main(String[] args)
	{
		int n,j,temp,i;
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the dataset size:");
		n=scan.nextInt();
		int arr[]=new int[n];
		for(i=0;i<n;i++)
		{
			System.out.print("Enter arr["+i+"]:");
			arr[i]=scan.nextInt();
		}
		for(i=0;i<n;i++)
		{
			System.out.print("\narr["+i+"]: "+arr[i]);
		}
		for(i=0;i<n-1;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("\n\nSorted Array(dataset) is:\n");
		for(i=0;i<n;i++)
		{
			System.out.println("arr["+i+"]: "+arr[i]);
		}
		minMax(arr,n);
		zscore(arr,n);
		decimalScaling(arr,n);
	}
}