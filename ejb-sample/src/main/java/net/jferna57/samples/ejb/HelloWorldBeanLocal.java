package net.jferna57.samples.ejb;

import javax.ejb.Local;

@Local
public interface HelloWorldBeanLocal {
	
	String sayHello(String name);

}
