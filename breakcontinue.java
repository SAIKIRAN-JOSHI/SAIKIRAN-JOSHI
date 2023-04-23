package breakcontinue;

public class breakcontinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i=1;
//Scanner sc = new Scanner(System.in);
//System 
for(;;i++) {
	if(i%2!=0)
		continue;
	else if(i>20)
	break;
	else
		System.out.println(i);
}
	}

}
