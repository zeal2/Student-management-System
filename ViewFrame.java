import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame
{
Container c;
TextArea taData;
JButton btnBack;

ViewFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());
taData = new TextArea(10,20);
btnBack = new JButton("Back");

c.add(taData);
c.add(btnBack);


HbHandler hb = new HbHandler();
String data = hb.viewStudent();
taData.setText(data);



ActionListener a1 = (ae) ->{

StudentFrame s = new StudentFrame();
dispose();


};
btnBack.addActionListener(a1);






setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setSize(250,250);
setTitle("View Student");


}

public static void main(String args[]){

ViewFrame v = new ViewFrame();

}

}