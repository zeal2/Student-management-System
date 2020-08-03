import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;

class StudentFrame extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;


StudentFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

btnAdd = new JButton("Add");
btnView = new JButton("View");
btnUpdate = new JButton("Update");
btnDelete = new JButton("Delete");

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

ActionListener a1 = (ae) ->{
AddFrame a = new AddFrame();
dispose();


};
btnAdd.addActionListener(a1);


ActionListener a2 = (ae) ->{
ViewFrame v = new ViewFrame();
dispose();


};
btnView.addActionListener(a2);


ActionListener a3 = (ae) ->{
UpdateFrame u = new UpdateFrame();
dispose();


};
btnUpdate.addActionListener(a3);


ActionListener a4 = (ae) ->{
DeleteFrame d = new DeleteFrame();
dispose();


};
btnDelete.addActionListener(a4);




setSize(250,250);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setTitle("STUDENT DATABASE");
setVisible(true);





}


public static void main(String args[]){

StudentFrame s = new StudentFrame();

}
}


class HbHandler
{
public void addStudent(int rno,String name,int marks)
{

Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;
try{
session = factory.openSession();

t = session.beginTransaction();
Student s = new Student();
s.setRno(rno);
s.setName(name);
s.setMarks(marks);

session.save(s);
t.commit();

JOptionPane.showMessageDialog(new JDialog(),"Student record inserted");


}


catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"issue " + e);
t.rollback();
}

finally
{
session.close();

}

}



public String viewStudent(){

StringBuffer sb = new StringBuffer();

Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory = cfg.buildSessionFactory();
Session session = null;

try{
session = factory.openSession();
ArrayList<Student> sl = new ArrayList<>();
sl = (ArrayList)(session.createQuery("from Student").list());
for(Student m : sl)
	sb.append(m.getRno() + " " + m.getName() + " " + m.getMarks() + "\n");



}


catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"issue " + e);
}

finally
{
session.close();

}

return sb.toString();
}

public void updateStudent(int rno,String name,int marks){


Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;
try{
session = factory.openSession();

t = session.beginTransaction();
Student s = (Student)session.get(Student.class,rno);
if(s!=null){
s.setName(name);
s.setMarks(marks);
session.save(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(),"Student record updated");


}
else{
JOptionPane.showMessageDialog(new JDialog(),"Student does not exists");

}
}


catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"issue " + e);
t.rollback();
}

finally
{
session.close();

}
}

public void deleteStudent(int rno){

Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;
try{
session = factory.openSession();

t = session.beginTransaction();
Student s = (Student)session.get(Student.class,rno);
if(s!=null){
session.delete(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(),"Student record deleted");



}
else{
JOptionPane.showMessageDialog(new JDialog(),"Student does not exists");

}
}


catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"issue " + e);
t.rollback();
}

finally
{
session.close();

}

















}
}