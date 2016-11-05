import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.sql.RowSetWriter;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

//This provider will be registered by Jersy at aapplicationStart up.
@Provider
public class MyDateConverterProvider implements ParamConverterProvider{

	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {

		//return a Converter, if the rowType is MyDate
		if(rawType.getName().equals(MyDate.class.getName())){
			//implementing the paramConverter inlines
			return new ParamConverter<T>(){

				//input is always String
				@Override
				public T fromString(String value) {
					
					Calendar requestedDate = Calendar.getInstance();
					
					if(value.equals("tomorrow")){
						requestedDate.add(Calendar.DATE, 1);
					}
					else if(value.equals("yesterday")){
						requestedDate.add(Calendar.DATE, -1);
					}
					
					
					MyDate myDate = new MyDate();
					myDate.setDate(requestedDate.get(Calendar.DATE));
					myDate.setMonth(requestedDate.get(Calendar.MONTH));
					myDate.setYear(requestedDate.get(Calendar.YEAR));

					
					return rawType.cast(myDate);
				}

				@Override
				public String toString(T value) {
					if(value == null){
						return null;
					}
					return value.toString();
				}
				
			};
		}
		
		return null;	
	}

}
