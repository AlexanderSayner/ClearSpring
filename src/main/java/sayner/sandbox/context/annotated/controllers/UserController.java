/**
 * 
 */
package sayner.sandbox.context.annotated.controllers;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sayner.sandbox.context.annotated.services.UserService;
import sayner.sandbox.models.CustomUser;

/**
 * @author uarchon
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {


	@Autowired
	private final UserService userService;

	/**
	 * @param userService
	 */
	@Autowired
	public UserController(UserService userService) {

		this.userService = userService;
	}

	@GetMapping
	public String userForm(Locale locale, Model model) {

		model.addAttribute("users", userService.list());
		return "editUsers";
	}

	@ModelAttribute("user")
	public CustomUser formBackingObject() {
		return new CustomUser();
	}

	@PostMapping("/addUser")
	public String saveUser(@ModelAttribute("user") @Valid CustomUser user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("users", userService.list());
			return "editUsers";
		}

		userService.save(user);
		return "redirect:/user";
	}
}
