package com.ubox.rests;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PrincipalResource   {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public void method(HttpServletResponse httpServletResponse) {
	    httpServletResponse.setHeader("Location", "http://localhost:5000/unbox/swagger-ui.html");
	    httpServletResponse.setStatus(302);
	}
	
	

}
