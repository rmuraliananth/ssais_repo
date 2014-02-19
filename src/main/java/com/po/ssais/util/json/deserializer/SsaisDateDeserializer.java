package com.po.ssais.util.json.deserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.po.ssais.util.SsaisUtil;

/**
 * @author muraliananthr
 * 
 */
public class SsaisDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		SimpleDateFormat format = new SimpleDateFormat(
				SsaisUtil.DEFAULT_DATE_PATTERN);
		String date = arg0.getText();
		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
