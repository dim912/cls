import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class DateMessageBodyWritter implements MessageBodyWriter<MyDate> {

	
	//JAX-RS calls this method to check whether a given object type type can be written to the message by this writter
	//when a instance is given, the message body writter checks whether it can be writable by this writer.
	
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		
//		if(type.getName().equals(MyDate.class.getName())){
//			return true;
//		}
		
		return MyDate.class.isAssignableFrom(type);
		
		// TODO Auto-generated method stub
	//	return false;
	}

	//depriated in current JAX-RS 
	@Override
	public long getSize(MyDate t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return -1;
	}

	//jbo of this method is getting the object t and write to output stream
	@Override
	public void writeTo(MyDate t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		//
		
		entityStream.write((t.toString()+"written by messageBodyWriter").getBytes());
		
	}

}
