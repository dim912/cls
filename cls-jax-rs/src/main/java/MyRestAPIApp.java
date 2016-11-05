import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//this is one of another way of configurating an webapp without using webxml. But using annotations.
@ApplicationPath(value = "/testwebapi") //no need of web xml.
public class MyRestAPIApp extends Application {
	
	
	//Application class : 
	//can implement in this class to cusstomize behaviour 

}
