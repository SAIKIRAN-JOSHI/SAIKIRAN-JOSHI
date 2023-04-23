package CheckingString;

public class Stringformat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String first = "java";
String second = "python";
String Third = "c programming";
String old = "java";
System.out.println(first);
System.out.println("new string:"+second);
int length = Third.length();
System.out.println(length);
String joinedstring = first.concat(second);
System.out.println(joinedstring);
boolean result = old.equals(first);
System.out.println("The 2 strings are same: "+result);
String ex = "this is a \"new\" type";
System.out.println(ex);
String name = new String("java string");
System.out.println(name);




	}

}
