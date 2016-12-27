package dim.com.cls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dim.cls.model.abstracts.AbstractDomainEntry;

import org.springframework.ui.ModelMap;


@Controller
@RequestMapping("hello")
public class HelloController{
 
   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) {
	   
	  System.out.println("yoyo");
      model.addAttribute("message", "Hello Spring MVC Framework!");

      return "hello";
   }

}
