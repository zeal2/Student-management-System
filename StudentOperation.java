import org.hibernate.*;
import org.hibernate.cfg.*;

class StudentOperation{
public static void main(String args[]){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory = cfg.buildSessionFactory();

Session session = null;
try{
session = factory.openSession();
System.out.println("session open");
}
catch(Exception e)
{
System.out.println("issue " + e);
}
finally
{
session.close();
System.out.println("session close");
}
}
}