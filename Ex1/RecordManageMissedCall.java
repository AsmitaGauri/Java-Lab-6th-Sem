package Ex1;
import java.util.*;
public class RecordManageMissedCall {
	static LinkedList<MissedCallDetails> missedCalls;
	public static void handleMissedCallChoices() {
		missedCalls = new LinkedList<MissedCallDetails>();
		while(true) {
			System.out.println("Enter a choice");
			System.out.println("1: Add a missed call \n 2: Display and delete based on request\n 3: Delete based on telnum\n 4: Print");
			int choice = DatabaseCallers.sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter the missed call number");
					Long telnum =  DatabaseCallers.sc.nextLong();
					String name;
					Calendar date = Calendar.getInstance();
					if(DatabaseCallers.hm.containsKey(telnum)) {
						name = DatabaseCallers.hm.get(telnum);
					}else {
						name = "Private Caller";
					}
					
					MissedCallDetails mcd = new MissedCallDetails(date, telnum, name);
					if(missedCalls.size()==10) {
						missedCalls.removeLast();
					}
					
					missedCalls.addFirst(mcd);
					break;
				case 2:
					ListIterator<MissedCallDetails> itr = missedCalls.listIterator();
					LinkedList<MissedCallDetails> removeCalls = new LinkedList<MissedCallDetails>();
					int i =0;
					while(itr.hasNext()) {
						i++;
						MissedCallDetails mcde = itr.next();
						System.out.println(mcde.tel_num);
						System.out.println("Do you want to delete details related to this number? \n 1: Remove this number\n 2: Continue\n 3: Display details\n");
						int cho = DatabaseCallers.sc.nextInt();
						if(cho==1) {
							removeCalls.add(mcde);
						}else if(cho == 3) {
							mcde.display();
						}
					}
					
					if(i==0)
						System.out.println("No missed calls to delete");
					missedCalls.removeAll(removeCalls);
					break;
				case 3:
					System.out.println("Enter the tel num");
					Long telnum3 = DatabaseCallers.sc.nextLong();
					ListIterator<MissedCallDetails> itr3 = missedCalls.listIterator();
					boolean flag = false;
					int j=0;
					while(itr3.hasNext()) {
						j++;
						MissedCallDetails mcd3 = itr3.next();
						if(telnum3 ==  mcd3.tel_num) {
							missedCalls.remove(mcd3);
							flag=true;
							break;
						}
					}
					
					if(j==0)
						System.out.println("No missed calls");
					else if(flag){
						System.out.println("Details deleted");
					}else {
						System.out.println("No such  number exists");
					}
					break;
				case 4:
					ListIterator<MissedCallDetails> itr4 = missedCalls.listIterator();
					while(itr4.hasNext()) {
						MissedCallDetails mcde4 = itr4.next();
						mcde4.display();
					}
					break;
				default :
					return;
			}
		}
	}
	
	public static void main(String args[]) {
		DatabaseCallers.createDatabase();
		handleMissedCallChoices();
		DatabaseCallers.display();
	}
}

