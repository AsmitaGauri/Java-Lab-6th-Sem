package Ex5;
import java.sql.*;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class Representative extends JFrame implements ActionListener{
JTextField repno,repname,state,comm,rate,cust_no,cust_name,cred,repno1,repname1,state1,comm1,rate1;
JButton submit,display;
ResultSet rs;
Connection con;
PreparedStatement ps,ps1;
Statement st;
Representative(){
super("Enter details");JLabel r=new JLabel("Enter repno");
repno=new JTextField(20);
repname=new JTextField(20);
state=new JTextField(20);
comm=new JTextField(20);
rate=new JTextField(20);
cust_no=new JTextField(20);
cust_name=new JTextField(20);
cred=new JTextField(20);
JLabel r1=new JLabel("Enter repname");
JLabel r2=new JLabel("Enter state");
JLabel r3=new JLabel("Enter comm");
JLabel r4=new JLabel("Enter rate");
JLabel r5=new JLabel("Enter cust_no");
JLabel r6=new JLabel("Enter cust_name");
JLabel r7=new JLabel("Enter credit");
submit=new JButton("submit");
display=new JButton("Display");
add(r);
add(repno);
add(r1);
add(repname);
add(r2);
add(state);
add(r3);
add(comm);
add(r4);
add(rate);
add(r5);add(cust_no);
add(r6);add(cust_name);
add(r7);add(cred);
add(submit);
add(display);
submit.addActionListener(this);
display.addActionListener(this);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
try {
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Representative","root","password");
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
public void actionPerformed(ActionEvent evt){
if(evt.getSource()==submit){
int repn=Integer.parseInt(repno.getText());
String repna=repname.getText();
String sta=state.getText();String com=comm.getText();
String rat=rate.getText();
int custn=Integer.parseInt(cust_no.getText());
String custna=cust_name.getText();
String cre=cred.getText();
String query="insert into Rep values(?,?,?,?,?)";
try {
ps = con.prepareStatement(query);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
ps.setInt(1, repn);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
ps.setString(2, repna);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
ps.setString(3, sta);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
ps.setString(4, com);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
ps.setString(5, rat);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
int i=ps.executeUpdate();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
String query1="insert into Cust values(?,?,?,?,?)";
try {
ps1 = con.prepareStatement(query1);
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
try {
ps1.setInt(1, custn);} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
ps1.setString(2, custna);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
ps1.setString(3, sta);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
ps1.setString(4, cre);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
ps1.setInt(5, repn);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
int i=ps1.executeUpdate();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
else{
try {
st=con.createStatement();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
rs=st.executeQuery("select * from Rep where repno in(select repno from Cust where cred>1500)" );
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
if(rs!=null){
try {
while(rs.next()){
JFrame frm=new JFrame("Print");
JLabel s5=new JLabel("repno");
JLabel s1=new JLabel("repname");
JLabel s2=new JLabel("state");
JLabel s3=new JLabel("comm");JLabel s4=new JLabel("rate");
repno1=new JTextField(20);
repname1=new JTextField(20);
state1=new JTextField(20);
comm1=new JTextField(20);
rate1=new JTextField(20);
frm.add(s5);
frm.add(repno1);
frm.add(s1);
frm.add(repname1);
frm.add(s2);
frm.add(state1);
frm.add(s3);
frm.add(comm1);
frm.add(s4);
frm.add(rate1);
repno1.setText(String.valueOf(rs.getInt(1)));
repname1.setText(rs.getString(2));
state1.setText(rs.getString(3));
comm1.setText(rs.getString(4));
rate1.setText(rs.getString(5));
frm.setVisible(true);
frm.setSize(300,300);
frm.setLayout(new GridLayout(2,10));
}
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
}
public static void main(String args[]){
Representative obj=new Representative();
obj.setVisible(true);
obj.setSize(300,300);
obj.setLayout(new GridLayout(20,2));
}
}