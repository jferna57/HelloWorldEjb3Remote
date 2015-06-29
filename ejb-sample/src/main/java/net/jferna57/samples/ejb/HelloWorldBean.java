package net.jferna57.samples.ejb;

import javax.ejb.Stateless;

@Stateless(mappedName = "HelloWorld")
public class HelloWorldBean implements HelloWorldBeanRemote, HelloWorldBeanLocal {

    public HelloWorldBean() {
    }

	@Override
	public String sayHello(String name) {
		
		return "Hello World " + name;
		
	}

}
