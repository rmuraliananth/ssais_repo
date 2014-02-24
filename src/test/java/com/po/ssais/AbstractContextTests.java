package com.po.ssais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration( "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AbstractContextTests {

	/*@Autowired
	protected WebApplicationContext wac;*/

}
