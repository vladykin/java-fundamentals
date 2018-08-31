package ru.csc.java.networking.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
public class HelloController {

	@RequestMapping
	@ResponseBody
    public String hello() {
		return "<h1>Hello world!</h1>";
	}

}
