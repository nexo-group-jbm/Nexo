package App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project2.CustomerBo;

public class CustomerBoApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext appContext= new ClassPathXmlApplicationContext("Spring-Customer.xml");
CustomerBo customer= (CustomerBo) appContext.getBean("customerBo"); 
//customer.addCustomerReturnValue();
//customer.addCustomerThrowException();
customer.addCustomerAround("Badri");
	}}
