package Aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
//	@Before("execution(* com.project2.impl.CustomerBoImpl.addCustomer(..))")
//public void logBefore(JoinPoint joinPoint) {
//	System.out.println("LogBefore() is running....");
//	System.out.println("hijacked: "+ joinPoint.getSignature().getName());
//	System.out.println("*******************");
//}
//	
//	@AfterReturning(
//			
//	  pointcut = "execution(* com.project2.impl.CustomerBoImpl.addCustomerReturnValue(..))",
//      returning= "result")
//	
//	public void logAfter(JoinPoint joinPoint, Object result) {
//		System.out.println("Method Return Value is: "+result);
//		System.out.println("LogAfterReturning is running.....");
//		System.out.println("hijacked:"+ joinPoint.getSignature().getName());
//		
//		
//		
//	}
//	@AfterThrowing(
//	
//	pointcut="execution(* com.project2.impl.CustomerBoImpl.addCustomerThrowException(..))",
//	throwing="error")
//public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
//	System.out.println("LogAfterThrowing is Running..");
//	System.out.println("hiJacked: "+ joinPoint.getSignature().getName());
//	System.out.println("Exception :"+error);
//	System.out.println("*******");
//}
	@Around("execution(* com.project2.impl.CustomerBoImpl.addCustomerThrowException(..))")
	   public void logCustomerAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
			
		System.out.println("Around before is running!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("Around after is running!");
			
		System.out.println("******");

	   }
}
