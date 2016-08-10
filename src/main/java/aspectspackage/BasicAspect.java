package aspectspackage;
 
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
 
@Aspect
public class BasicAspect {
    
 @Pointcut ("call(void java.io.PrintStream.println(String)) && !within(aspectspackage..*) ")
 public void pcsout(){}
	/* Read as -- do this *before* any *call* to the function
         * *java.io.PrintStream.println* that takes a *String*
         * and returns *void* and the function is not called
	 * within any class under the package net.andrewewhite.aspects
	 
 "   call(void java.io.PrintStream.println(String)) " +
            "&& !within(aspectspackage..*)"
 
 */
   @Before("pcsout()")
    public void beforePrintlnCall() {
        System.out.println("About to make call to print Hello World before");
    }
 
    @After("    call(void java.io.PrintStream.println(String)) " +
           "&&  !within(aspectspackage..*)")
    public void afterPrintlnCall() {
        System.out.println("Just made call to print Hello World after");
    }
}