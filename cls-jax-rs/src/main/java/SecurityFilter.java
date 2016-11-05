import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	
	private static final String AUTHERIZATION_HEADER_KEY = "Autherization";
	private static final String AUTHERIZATION_HEADER_PREFIX = "Basic ";

	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		System.out.println(requestContext.getUriInfo().getQueryParameters().get("link"));
		
		if(requestContext.getUriInfo().getPath().contains("secure")) {
			List<String> authHeaders = requestContext.getHeaders().get("AUTHERIZATION_HEADER_KEY");
			
			if(authHeaders != null && authHeaders.size()>0){
				
				String authHeader = authHeaders.get(0);
				authHeader = authHeader.replace(AUTHERIZATION_HEADER_PREFIX, "");
				
				
				String decodedAuth = Base64.decodeAsString(authHeader);
				System.out.println(decodedAuth);
				
				
				String username  = decodedAuth.split(":")[0];
				String passWd  = decodedAuth.split(":")[1];
				
				if(username.equals("user") && passWd.equals("password")){
					return ;  // return means => JAX-RS is free to proceed with processing	
				}
				else {
					Response unauthorizedStatus = 	Response.status(Response.Status.UNAUTHORIZED)
							.entity("user do not have the rights to call this secure rest ws")
							.build();
					
					requestContext.abortWith(unauthorizedStatus);
				}
			}
			else{
				Response unauthorizedStatus = 	Response.status(Response.Status.UNAUTHORIZED)
						.entity("user do not have the rights to call this secure rest ws")
						.build();
				
				requestContext.abortWith(unauthorizedStatus);
			}
		}
	}

}
