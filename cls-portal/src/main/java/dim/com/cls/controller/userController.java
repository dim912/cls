package dim.com.cls.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dim.cls.model.StaffMember;
import com.dim.cls.user.UserService;

@Controller
@RequestMapping("/users")
public class userController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView Test(final RedirectAttributes redirectAttributes, Model model) {
		
		
		List<StaffMember> users = userService.findAll();
		
		
		for(int i=0;i< users.size() ; i++){
			System.out.println(users.get(i).getFirstName());
		}
		
		
		return null;
	}



	@RequestMapping(value = "/add", method = RequestMethod.GET)
	// @Path in CXF, RequestMethod.GET => @GET
	public ModelAndView getRegisterForm(final RedirectAttributes redirectAttributes, Model model) {

		System.out.println("dxxddxxxxp");

		// return new ModelAndView("Register", "command", new StaffMember());
		// //command is the magic default. => no need to have
		// modelAttribute="xyz" at jsp
		// populateDefaultModel(model); // drop down ad other value population
		// can be done here
		// String css = "css";
		// String msg = "msg";
		// model.addAttribute(css);
		// model.addAttribute(msg);

		return new ModelAndView("userRegister", "command", new StaffMember());
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showAllUsers(Model model) {

		model.addAttribute("users", userService.findAll());
		return new ModelAndView("userList");

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView saveUserData(@ModelAttribute("userForm") StaffMember staffMember, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {
		// @ModelAttribute => argument should be retrived from the model. If not
		// present in the model
		// should be initiated and add to the model. /this is called as data
		// binding
		// the model attribute can be retrived from sevaral places.
		// 1) It may already in model due to "@SessionAttributes"
		// 2) @ModelAttribute method in the same controller
		// 3) It may be retrieved based on a URI template variable and type
		// converter (explained in more detail below).
		// 4) It may be instantiated using its default constructor before the
		// method is called
		// public ModelAndView getRegisterForm() {

		// System.out.println(staffMember.getFirstName());

		System.out.println("10");
		
		System.out.println(staffMember.getFirstName());
		
		if (result.hasErrors()) {
			// populateDefaultModel(model);
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors().get(0).getDefaultMessage().toString());
			System.out.println("11");

			model.addAttribute("css", "warning");
			model.addAttribute("msg", "An Error occured");

			// return new ModelAndView("userRegister", "command", staf fMember);
			return null;
		}

		else {
			model.addAttribute("css", "success");
			redirectAttributes.addFlashAttribute("css", "success");
		}
		
		if (staffMember.isNew()) {

			model.addAttribute("msg", "User  added successfully!");
			redirectAttributes.addFlashAttribute("msg", "User is added successfully!");
		} else {
			model.addAttribute("msg", "User updated successfully!");
			redirectAttributes.addFlashAttribute("msg", "User is updated successfully!");
		}
		System.out.println("1");
		userService.saveOrUpdate(staffMember);
		System.out.println("2");

		return new ModelAndView("userRegister", "command", staffMember);
	}

	@RequestMapping("/userList")
	public ModelAndView getUserList() {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users", userService.findAll());

		System.out.print(userService.findAll().get(0).toString());
		System.out.print(userService.findAll().get(1).toString());

		return new ModelAndView("UserList", model);

	}

}
