import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateString}")
public class DateResource {

	
	@GET
	//@Produces(MediaType.TEXT_PLAIN)
	//JAX-RS will go to the corresponding messageBodyWriter depending on the media type and -> 
	//messageBodyWriter ->  will write on the output.
	@Produces(value = {MediaType.TEXT_PLAIN, "text/shortDate"})
	public MyDate getRequestDate(@PathParam("dateString") MyDate mydate){
		
		
		
		//return "Go " + mydate.toString();
		
		//JAX-RS will go to the corresponding messageBodyWriter depending on the media type and -> it will write on the output.
		return mydate ;
		
	}
	
	
	
}
