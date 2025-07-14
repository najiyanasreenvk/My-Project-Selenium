package Retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class RetryListener implements IAnnotationTransformer {
	@Override  
	  public void transform(ITestAnnotation annotation,Class testclass,Constructor testConstructor,Method testMethod) {
		 annotation.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) RetryAnalizer.class);
		}
	

}
