package es.ricoh.servlet;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jferna57.samples.ejb.HelloWorldBeanRemote;

/**
 * Servlet implementation class TestServlet
 */
public class EjbMethod1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjbMethod1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.getWriter().append("Response from servlet -->: ").append(getEjbViaJNDI());
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String getEjbViaJNDI(){

		Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        
        Context ic;
        
		try {
			ic = new InitialContext(env);
			HelloWorldBeanRemote remote = (HelloWorldBeanRemote) ic.lookup ("HelloWorld#net.jferna57.samples.ejb.HelloWorldBeanRemote");	        
	        
	        return remote.sayHello("Servlet");

		} catch (NamingException e) {
			return e.getMessage();
		}

	}

}
