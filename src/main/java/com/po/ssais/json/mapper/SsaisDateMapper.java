/**
 * 
 */
package com.po.ssais.json.mapper;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.springframework.stereotype.Component;

import com.po.ssais.util.json.serializer.SsaisDateSerializer;

/**
 * @author muraliananthr
 * 
 */

@Component("jacksonDateMapper")
public class SsaisDateMapper extends ObjectMapper {

	private String mask = "dd-MM-yyyy";
	
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);

		// this one doesn't work at all, it's necessary to create and register a
		// factory
		// getSerializationConfig().withDateFormat(new SimpleDateFormat(mask));

		// I am using Jackson 1.9 asl
		CustomSerializerFactory factory = new CustomSerializerFactory();
		factory.addSpecificMapping(Date.class, new SsaisDateSerializer());
//		factory.addSpecificMapping(Date.class, new JsonSerializer<Date>() {
//
//			@Override
//			public Class<Date> handledType() {
//				return Date.class;
//			}
//
//			@Override
//			public void serialize(Date value, JsonGenerator jgen,
//					SerializerProvider provider) throws IOException,
//					JsonProcessingException {
//
//				jgen.writeString(new SimpleDateFormat(mask).format(value));
//				System.out.println("==================");
//				System.out.println(new SimpleDateFormat(mask).format(value));
//				System.out.println("==================");
//			}
//		});
		this.setSerializerFactory(factory);
	}

	public void setMask(String mask) {
		this.mask = mask;
	}
}
