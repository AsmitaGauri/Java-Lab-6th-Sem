package Ex3;

public class Student {
	String name;
	String address,usn;
	int age;
	Student(String name,String address,String usn,int age)
	{
	this.name=name;
	this.age=age;
	this.address=address;
	this.usn=usn;
	}
	public String toString() 
	{
	return "Name : "+name+"\nAge : "+age+"\nAddress : "+address+"\n Usn : "+usn;
	}
}
