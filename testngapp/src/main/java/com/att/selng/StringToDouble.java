package com.att.selng;

public class StringToDouble {
	
	public static void main(String ar[])
	{
		String value="46.68";
		double ip=0.0;
		int dotIndex=1; 
		String[] arra=value.split("\\.");
		String nextDot=arra[1];
		for(int j=0;j<nextDot.length();j++)
		{
			dotIndex=dotIndex*10;
		}
		for(int i=0;i<value.length();i++)
		{
			char c=value.charAt(i);
		
			if(c!='.')
			{
				double g=c -'0';
				ip=ip*10;
				ip=ip+g;
				System.out.println(ip);
			}
		
				
			
			
		}

		System.out.println(ip=ip/dotIndex);
	}

}
