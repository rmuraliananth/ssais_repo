package com.po.ssais.util.json.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.po.ssais.util.SsaisUtil;

/**
 * @author muraliananthr
 * 
 */
public class SsaisDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat(
				SsaisUtil.DEFAULT_DATE_PATTERN);
		String formattedDate = formatter.format(arg0);
		arg1.writeString(formattedDate);
	}

}
