
public class PhoneNumber
{
	private String num;
		
		public PhoneNumber(String num)
		{
			this.num = num;
		}
		
		public String getNum()
		{
			return num;
		}
		
		public int hashCode()
		{
			int code = 0;
			for(int i=0; i<num.length(); i++)
				if(num.substring(i, i+1).matches("\\d"))
					code += (int)num.charAt(i) - 48;
			return code;
		}
		
		public boolean equals(Object other)
		{
			PhoneNumber p2 = (PhoneNumber) other;
			return num.equals(p2.getNum());
		}
		
		public String toString()
		{
			return num;
		}
}