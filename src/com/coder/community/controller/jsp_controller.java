package com.coder.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.coder.community.DAO.DAO;
import com.coder.community.entity.User;

@Controller
/* @RequestMapping("/ashish") */
public class jsp_controller {

	@Autowired
	public DAO dao;

	@GetMapping("/registration")
	public String registration(Model theModel) {

		User theUser = new User();
		
		
		theModel.addAttribute("user", theUser);
		return "home";
	}

	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("user") User theUser, @RequestParam("image") CommonsMultipartFile file) {
		System.out.println("name " + file.getOriginalFilename());
		System.out.println("Byte " + file.getBytes());
		System.out.println("Byte " + file.getSize());
		System.out.println("Byte " + file.getContentType());

		dao.saveCustomer(theUser);

//		return "redirect:/login";
		return "login";
	}

	@GetMapping("/login")
	public String login(Model theModel) {

		User theUser = new User();

		theModel.addAttribute("user", theUser);

		return "login";

	}

	@PostMapping("/DetailsPage")
	public String login1(@ModelAttribute("user") User theUser, Model theModel) {

		String email = theUser.getEmail();
		String password = theUser.getPassword();

		User validate = dao.validate(email, password);

		System.out.println("Designation of the uses" + validate.getDesignation());
		if (validate != null) {

			System.out.println("Designation of the uses vv " + validate.getDesignation());

			String designation = validate.getDesignation();
			System.out.println("String Designation  " + designation);
			if (designation.equalsIgnoreCase("Admin")) {
				System.out.println("Designation of the uses ff" + validate.getDesignation());
				// User is validated
				List<User> user = dao.getCustomer();
				theModel.addAttribute("user", user);
				return "redirect:/list";
			} else {
				System.out.println("Designation of the uses ww " + validate.getDesignation());
				// User is validated
				List<User> user = dao.getCustomerUser();
				theModel.addAttribute("user", user);
				return "redirect:/listUser";
			}

		} else {
			// User is not validated
			return "login";
		}

	}

	@GetMapping("/list")
	public String list(Model theModel) {

		List<User> theCustomer = dao.getCustomer();

		theModel.addAttribute("user", theCustomer);

		return "Admin_Page";
	}

	@GetMapping("/listUser")
	public String listUser(Model theModel) {

		List<User> theCustomer = dao.getCustomerUser();

		theModel.addAttribute("user", theCustomer);

		return "User_Page";
	}

	@GetMapping("/adminPage")
	public String adminPage(Model theModel) {

		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "admin";
	}

	@GetMapping("/userPage")
	public String userPage(Model theModel) {

		return "userPage";
	}

	@GetMapping("/userEdit")
	public String userEdit(@RequestParam("id") int theId, Model themodel) {

		User theUser = dao.updateUser(theId);

		themodel.addAttribute("user", theUser);

		return "UserEdit";

	}

	@PostMapping("/UpdateUser")
	public String SaveAndUser(@ModelAttribute("user") User theUser) {

		dao.UpdateSaveUser(theUser);

		return "redirect:/listUser";
	}

	@GetMapping("/DeleteUser")
	public String DeleteUser(@RequestParam("id") int theId, Model theModel) {

		dao.delteUser(theId);

		User theUser = new User();
		theModel.addAttribute("user", theUser);
//		return "redirect:/DetailsPage";
		/* return "redirect:/adminPage"; */
		return "redirect:/listUser";
	}

	/* ==========================Admin Details ========================== */

	@GetMapping("/AdminEdit")
	public String AdminEdit(@RequestParam("id") int theId, Model themodel) {

		User theUser = dao.updateUser(theId);

		themodel.addAttribute("user", theUser);

		return "AdminEdit";

	}

	@PostMapping("/UpdateAdmin")
	public String UpdateAdmin(@ModelAttribute("user") User theUser) {

		dao.UpdateSaveUser(theUser);

		return "redirect:/list";
	}

	@GetMapping("/DeleteAddmin")
	public String DeleteAdmin(@RequestParam("id") int theId, Model theModel) {

		dao.delteUser(theId);

		User theUser = new User();
		theModel.addAttribute("user", theUser);
//		return "redirect:/DetailsPage";
		/* return "redirect:/adminPage"; */
		return "redirect:/list";
	}

	/* ================================================ */
}
