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
@Produces("text/shortDate")
public class ShortDateDateMessageBodyWriter implements MessageBodyWriter<MyDate> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {

		if (type.isAssignableFrom(MyDate.class)) {
			return true;
		}

		return false;
	}

	@Override
	public long getSize(MyDate t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void writeTo(MyDate t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {

		String shortDte = t.getYear() + "-" + t.getMonth() + "-" + t.getDate();

		entityStream.write((shortDte + "custom Media Type").getBytes());
	}

}
