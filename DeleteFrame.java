import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame
{
Container c;
JButton btnDelete,btnBack;
JLabel lblRno;
JTextField txtRno;

DeleteFrame(){

c = getContentPane();
c.setLayout(new FlowLayout());

lblRno = new JLabel("Enter roll-no:");
txtRno = new JTextField(10);
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");

c.add(lblRno);
c.add(txtRno);
c.add(btnDelete);
c.add(btnBack);

ActionListener a1 = (ae) ->{

StudentFrame s = new StudentFrame();
dispose();


};
btnBack.addActionListener(a1);


ActionListener a2 = (ae) ->{
int rno = 0;

try
{

	 rno = Integer.parseInt(txtRno.getText());
	
	if(rno<=0){
	JOptionPane.showMessageDialog(new JDialog(),"invalid input(roll no): Please enter correct roll no. ");
	}
	HbHandler a = new HbHandler();
	a.deleteStudent(rno);

}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"invalid input");
}





};
btnDelete.addActionListener(a2);

setVisible(true);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setTitle("Delete Student");
setSize(250,250);



}

public static void main(String args[]){

DeleteFrame d = new DeleteFrame();

}
}