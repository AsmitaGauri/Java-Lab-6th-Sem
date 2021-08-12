package Ex1;
import java.util.*;
public class MissedCallDetails {
	Calendar date;
	Long tel_num;
	String name;
	MissedCallDetails(Calendar date, Long tel_num, String name){
		this.date =  date;
		this.tel_num =  tel_num;
		this.name = name;
	}
	
	void display() {
		System.out.println(date.getTime());
		System.out.println(tel_num);
		System.out.println(name);
	}
}
