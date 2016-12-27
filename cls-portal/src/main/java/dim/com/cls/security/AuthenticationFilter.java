package dim.com.cls.security;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
	
	public AuthenticationFilter(){
		System.out.println("Filter is created");
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Filter is triggered");
		System.out.println(requestContext.getRequest());
		
	}

}
