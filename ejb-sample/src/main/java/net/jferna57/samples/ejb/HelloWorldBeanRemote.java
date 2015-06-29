package net.jferna57.samples.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWorldBeanRemote {
	
	String sayHello(String name);

}
