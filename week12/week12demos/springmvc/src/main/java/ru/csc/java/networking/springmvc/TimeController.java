package ru.csc.java.networking.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/time/", method = RequestMethod.GET, produces = "text/html")
public class TimeController {

	@RequestMapping
	@ResponseBody
    public String time() {
		return "<p>" + LocalDateTime.now() + "</p>";
	}

}
