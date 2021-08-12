package Ex3;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

	public class Student_Management implements ActionListener 
	{
		ArrayList<Student> arr=new ArrayList<Student>();
		static JFrame frm,frm1;
		JTextField name,usn,address,age,sgpa;
		JButton compute,done,ADDSgpa;
		JTextArea jt;
		double cgpa;
		double a[]=new double[8];
		Student_Management()
		{
			//enter student information - name, usn, age, address, sgpa of 8 semesters, category.
			frm=new JFrame("Enter details");
			frm1=new JFrame("Display details");
			JLabel nam=new JLabel("Enter name");
			JLabel ag=new JLabel("Enter age");
			JLabel add=new JLabel("Enter address");
			JLabel us=new JLabel("Enter usn");
			jt=new JTextArea(100,100);
			name=new JTextField(20);
			age=new JTextField(20);
			address=new JTextField(20);
			usn=new JTextField(20);
			compute=new JButton("Compute");
			ADDSgpa=new JButton("Enter sgpa");
			done=new JButton("Display details");
			frm.add(nam);
			frm.add(name);
			frm.add(ag);
			frm.add(age);
			frm.add(add);
			frm.add(address);
			frm.add(us);
			frm.add(usn);
			frm.add(compute);
			frm.add(ADDSgpa);
			frm.add(done);
			frm1.add(jt);
			ADDSgpa.addActionListener(this);
			compute.addActionListener(this);
			done.addActionListener(this);
		}//Constructor
		public void actionPerformed(ActionEvent evt) 
		{
			if(evt.getSource()==ADDSgpa) 
			{//Validation of8 sgpas
				sgpa=new JTextField();
				for(int i=0;i<8;i++) 
				{
					String str=Integer.toString(i+1);
					int option=JOptionPane.showConfirmDialog(null, sgpa,"ENTER SGPA"+str,JOptionPane.OK_CANCEL_OPTION);
					if(option==JOptionPane.OK_OPTION) 
					{
						if(Double.parseDouble(sgpa.getText())>10) 
						{
							JOptionPane.showMessageDialog(null,"Sgpa incorrect,re enter");
							option=JOptionPane.showConfirmDialog(null, sgpa,"ENTER SGPA"+str,JOptionPane.OK_CANCEL_OPTION);
						}
						else 
						{
							a[i]=Double.parseDouble(sgpa.getText());
						}
						sgpa.setText("");
					}
				}
			}
			if(evt.getSource()==compute) 
			{
				double sum=0.0;
				for(int i=0;i<8;i++) 
				{
					sum=sum+a[i];
				}
				cgpa=sum/8;
				JOptionPane.showMessageDialog(null,cgpa);
			}	
			if(evt.getSource()==done) 
			{
				int age1=Integer.parseInt(age.getText());
				if(age1<17) 
				{
					JOptionPane.showMessageDialog(null,"Invalid age,re enter");
				}
				else if(cgpa==0.0||name.getText().equals("")||age.getText().equals("")||usn.getText().equals("")||address.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Enter all the fields");
			}
			else 
			{
				//Display collected data in correct area 
				String name1=name.getText();
				String address1=address.getText();
				String usn1=usn.getText();
				Student s=new Student(name1,address1,usn1,age1);
				arr.add(s);
				jt.setText("");
				for(Student c :arr) 
				{
					jt.append(c+"\n");
				}
				jt.append("CGPA:"+cgpa);
			}	
		}
	}
		
	public static void main(String args[]) 
	{
	Student_Management obj=new Student_Management();
	frm.setVisible(true);
	frm.setSize(300,400);
	frm.setLayout(new GridLayout(6,1));
	frm1.setVisible(true);
	frm1.setSize(300,400);
	}	
}