package edu.hes.e57.demo;

import org.springframework.aop.framework.ProxyFactory;

/**
 * This example is taken from Pro Spring 4: com.apress.prospring4.ch5
 * 
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.ProfilingExample" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.ProfilingExample" -Dexec.cleanupDaemonThreads=false
 */
public class ProfilingExample {
    public static void main(String[] args) {
        WorkerBean bean = getWorkerBean();
        bean.doSomeWork(10000);
    }

    private static WorkerBean getWorkerBean() {
        WorkerBean target = new WorkerBean();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new ProfilingInterceptor());

        return (WorkerBean)factory.getProxy();
    }
}