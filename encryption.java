public class encryption
{
	public static String Encrypt(String input)
	{
	try
	{
		String result = "";
		char a[] = input.toCharArray();
		int b[] = new int[input.length()];
		for(int i = 0; i < input.length(); i++)
		{
			b[i] = (int)a[i];
			b[i] = b[i] * 3 - 10;
			result +=  b[i] + "%";
		}
		return result;
	} catch(Exception e) {return "";}
	}
	public static String Decrypt(String input)
	{
	try
	{
		String[] parts = input.split("%");
		int a[] = new int[parts.length];
		char b[] = new char[parts.length];
		for(int i = 0; i < parts.length; i++)
		{
			a[i] = Integer.parseInt(parts[i]);
			a[i] = (a[i] + 10) / 3;
			b[i] = (char)a[i];
		}
		String result = String.valueOf(b);
		return result;
	} catch(Exception e) {return "";}
	}

}
