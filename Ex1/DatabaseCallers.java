package Ex1;
import java.util.*;
public class DatabaseCallers {
	public static HashMap<Long, String> hm;
	public static Scanner sc = new Scanner(System.in);
	
	static void addMissedCalls(int n) {
		hm = new HashMap<Long , String> ();
		for(int i=0;i<n;i++) {
			System.out.println("Enter telnum and name:");
			Long tel_num = sc.nextLong();
			String name = sc.next();
			hm.put(tel_num, name);
		}
	}
	
	public static void createDatabase() {
		System.out.println("Enter how many calls to be added");
		int n = sc.nextInt();
		addMissedCalls(n);
	}
	
	public static void display() {
		for(Map.Entry<Long,String> m : hm.entrySet()) {
			System.out.println(m.getKey()+"==>"+ m.getValue());
		}
	}
}
