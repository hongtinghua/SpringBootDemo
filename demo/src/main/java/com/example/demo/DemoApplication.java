package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	
	
	
	   /**
     * Run the Spring application, creating and refreshing a new
     * {@link ApplicationContext}.
     * @param args the application arguments (usually passed from a Java main method)
     * @return a running {@link ApplicationContext}
     */
    public ConfigurableApplicationContext run(String... args) {
    		/**
    		 * 计时工具，不管
    		 */
           StopWatch stopWatch = new StopWatch();
           stopWatch.start();
           ConfigurableApplicationContext context = null;
           Collection<SpringBootExceptionReporter> exceptionReporters = new ArrayList<>();
           /**
            * 图形化界面awt，不管
            */
           configureHeadlessProperty();
           SpringApplicationRunListeners listeners = getRunListeners(args);
           listeners.starting();
           try {
                  ApplicationArguments applicationArguments = new DefaultApplicationArguments(
                               args);
                  ConfigurableEnvironment environment = prepareEnvironment(listeners,
                               applicationArguments);
                  configureIgnoreBeanInfo(environment);
                  Banner printedBanner = printBanner(environment);
                  context = createApplicationContext();
                  exceptionReporters = getSpringFactoriesInstances(
                               SpringBootExceptionReporter.class,
                               new Class[] { ConfigurableApplicationContext.class }, context);
                  prepareContext(context, environment, listeners, applicationArguments,
                               printedBanner);
                  refreshContext(context);
                  afterRefresh(context, applicationArguments);
                  stopWatch.stop();
                  if (this.logStartupInfo) {
                        new StartupInfoLogger(this.mainApplicationClass)
                                      .logStarted(getApplicationLog(), stopWatch);
                  }
                  listeners.started(context);
                  callRunners(context, applicationArguments);
           }
           catch (Throwable ex) {
                  handleRunFailure(context, ex, exceptionReporters, listeners);
                  throw new IllegalStateException(ex);
           }
           try {
                  listeners.running(context);
           }
           catch (Throwable ex) {
                  handleRunFailure(context, ex, exceptionReporters, null);
                  throw new IllegalStateException(ex);
           }
           return context;
    }

	
	
	
	
	
}
