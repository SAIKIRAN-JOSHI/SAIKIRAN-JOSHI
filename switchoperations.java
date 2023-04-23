/**
 * 
 */
package patternprinter;

import java.util.Scanner;

/**
 * @author SAIKI
 *
 */
public class switchoperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
System.out.println("Enter first number");
float n1 = sc.nextInt();
System.out.println("Enter second number:");
float n2 = sc.nextInt();
System.out.println("press 1.addition 2.subtraction 3.multiplication 4.divison");
float n3;
int op = sc.nextInt();
switch(op) {
case 1: n3 = n1+n2;
System.out.println("Answer is:"+n3);
break;
case 2:n3 = n1-n2;
System.out.println("Answer is:" +n3);
break;
case 3: n3 = n1 * n2;
System.out.println("Answer is:"+n3);
break;
case 4: 
if(n2==0) {
	System.out.println("cannot be divided");
}
else {
	n3=n1/n2;
	System.out.println("Answer is :"+n3);
	break;
}
default: 
	System.out.println("selected option is invalid");
}
	
	}

}
