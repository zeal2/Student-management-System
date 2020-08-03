import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends JFrame
{
Container c;
JButton btnSave,btnBack;
JLabel lblRno,lblName,lblMarks;
JTextField txtRno,txtName,txtMarks;


UpdateFrame(){

c = getContentPane();
c.setLayout(new FlowLayout());

lblRno = new JLabel("Enter roll-no:");
lblName = new JLabel("Enter name: ");
lblMarks = new JLabel("Enter marks: ");
btnSave = new JButton("Save");
btnBack = new JButton("Back");
txtRno = new JTextField(10); 
txtName = new JTextField(10);
txtMarks = new JTextField(10);

c.add(lblRno);
c.add(txtRno);
c.add(lblName);
c.add(txtName);
c.add(lblMarks);
c.add(txtMarks);
c.add(btnSave);
c.add(btnBack);

ActionListener a1 = (ae) ->{

StudentFrame s = new StudentFrame();
dispose();


};
btnBack.addActionListener(a1);


ActionListener a2 = (ae) ->{
try{
int flag = 0;
int rno = Integer.parseInt(txtRno.getText());



String name =txtName.getText();
UpdateFrame u = new UpdateFrame();
boolean check = u.isName(name);
if(check == false || name.length()<2)
{
JOptionPane.showMessageDialog(new JDialog(),"invalid input(name) : Please enter correct name");
flag = 1;

}


int marks = Integer.parseInt(txtMarks.getText());

if(marks<0 || marks > 100)
{
JOptionPane.showMessageDialog(new JDialog(),"invalid input(marks) : Please enter correct marks ");
flag = 1;
}


		
if(flag==0){
HbHandler hb = new HbHandler();
hb.updateStudent(rno,name,marks);
}		

}
catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"invalid input");

}
};

btnSave.addActionListener(a2);

setVisible(true);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setTitle("Update Student");
setSize(250,250);



}

public static void main(String args[]){

UpdateFrame u = new UpdateFrame();

}
public boolean isName(String s){

	for(int i = 0;i<s.length();i++)
	{
		if((s.charAt(i)>90 || s.charAt(i)<65) & (s.charAt(i)>122 || s.charAt(i)<97))
			return false;	

	}
	return true;
		
}

}