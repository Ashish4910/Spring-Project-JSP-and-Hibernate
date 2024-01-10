package com.coder.community.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

//	@PostMapping("/processForm")
//	public String processForm(@ModelAttribute("user") User theUser, @RequestParam("image") MultipartFile file)
//			throws IOException {
//
//		System.out.println("" + file.getContentType());
//		System.out.println("" + file.getOriginalFilename());
//		System.out.println("" + file.getSize());
//
//		theUser.setImage(file.getBytes());
//		dao.saveCustomer(theUser);
//
//		// return "redirect:/login";
//		return "login";
//	}

	/* ========================= */

	/* ========================= */

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

		if (validate != null) {
			String designation = validate.getDesignation();

			if (designation.equalsIgnoreCase("Admin")) {
				// Redirect to the admin page
				return "redirect:/list";
			} else if (designation.equalsIgnoreCase("User")) {
				// Redirect to the user page
				return "redirect:/listUser";
			} else {
				// Handle other designations as needed
				return "redirect:/registration";
			}
		} else {
			// Redirect to the login page if validate is null
			return "redirect:/login";
		}
	}

	/* ================================== */

	@GetMapping("/list")
	public String list(Model theModel) {

		List<User> theCustomer = dao.getCustomerWithImages();
		// List<User> theCustomer = dao.getCustomer();

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

		User theUser = dao.updateUsercurret(theId);
 
		String fullName = theUser.getFullName();
		String email = theUser.getEmail();
		String password = theUser.getPassword();
		String phone = theUser.getPhone();
		String designation = theUser.getDesignation();

		themodel.addAttribute("fullName", fullName);
		themodel.addAttribute("email", email);
		themodel.addAttribute("password", password);
		themodel.addAttribute("phone", phone);
		themodel.addAttribute("designation", designation);
		themodel.addAttribute("id", theId);

		byte[] imageData = theUser.getImage();

		themodel.addAttribute("image", imageData);

		String imageBase64 = Base64.getEncoder().encodeToString(imageData);
		themodel.addAttribute("imageBase64", theUser.getImageBase64());

		System.out.println(" User Edit controller " + theUser.getImageBase64());
		System.out.println(" User Edit controller imageBase64  " + imageBase64);

		themodel.addAttribute("user", theUser);

		return "User_edit";

	}
//
//	@PostMapping("/UpdateUser")
//	public String SaveAndUser(@ModelAttribute("user") User theUser) {
//
//		// System.out.println("Update User after editing the form "+
//		// theUser.getImageBase64());
//
////		
////		System.out.println("File for image " + file.getOriginalFilename());
////		System.out.println("File for image " + file.getSize());
////		System.out.println("File for image " + file.getContentType());
//
//		System.out.println("Update user ImageBase64  " + theUser.getImageBase64());
//
//		System.out.println("Update User after editing the form " + theUser.getImage());
//
//		byte[] file_image = theUser.getImage();
//
//		if (file_image != null) {
//			dao.UpdateSaveUser(theUser);
//
//		} else {
//
//			dao.UpdateSaveUser(theUser);
//		}
//
//		return "redirect:/listUser";
//	}

	/* ================================================================ */

	@PostMapping("/UpdateUser")
	public String SaveAndUser(@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("designation") String designation,
			@RequestParam("password") String password, @RequestParam("image") MultipartFile image,
			@RequestParam("imageBase64") String imageBase64, @RequestParam("imageData") byte[] imageDataform,
			@RequestParam("id") int theId, Model theModel) {

		System.out.println(" Update user name" + fullName);
		System.out.println(" Update user  email" + email);
		System.out.println(" Update user  phone" + phone);
		System.out.println(" Update user designation " + designation);
		System.out.println(" Update user imageBase64 " + imageBase64);
		System.out.println(" Update user " + image.getContentType());
		System.out.println("Update User Form  imageDataform" + imageDataform);

		if (image != null && !image.isEmpty()) {
			System.out.println("Image is selected ");
			try {
				System.out.println("Byte Image " + image.getBytes());
				byte[] imageData = image.getBytes();

				System.out.println(" byte code for process form " + imageData);

				User userData = new User();
				userData.setFullName(fullName);
				userData.setEmail(email);
				userData.setPhone(phone);
				userData.setDesignation(designation);
				userData.setPassword(password);
				userData.setImage(imageData);
				userData.setId(theId);

				String base64Image = Base64.getEncoder().encodeToString(imageData);
				userData.setImageBase64(base64Image);

				System.out.println("Image base 64  " + base64Image);
				dao.UpdateSaveUser(userData);
				return "redirect:/listUser";

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			User userData = new User();
			System.out.println("Image is not selected ");
			userData.setFullName(fullName);
			userData.setEmail(email);
			userData.setPhone(phone);
			userData.setDesignation(designation);
			userData.setPassword(password);
			userData.setImage(imageDataform);
			System.out.println("Image Data " + imageDataform);
			userData.setImageBase64(imageBase64);
			System.out.println("ImageBase64 " + imageBase64);
			userData.setId(theId);

			dao.UpdateSaveUser(userData);
			return "redirect:/listUser";
		}

		return "redirect:/login";
	}

	/* ============================================================ */

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

	/*
	 * @GetMapping("/AdminEdit") public String AdminEdit(@RequestParam("id") int
	 * theId, Model themodel) {
	 * 
	 * List<User> theUser = dao.updateUser(theId);
	 * 
	 * 
	 * // System.out.println("Admin Edit " + theUser.getImageBase64());
	 * 
	 * themodel.addAttribute("user", theUser);
	 * 
	 * return "AdminEdit";
	 * 
	 * }
	 */

//	@GetMapping("/AdminEdit")
//	public String AdminEdit(@RequestParam("id") int theId, Model themodel) {
//
//		List<User> theUser = dao.updateUser(theId);
//
//		System.out.println("AdminEdit - User Details:");
//
//		for (User user : theUser) {
//			System.out.println("User ID: " + user.getId());
//			System.out.println("Full Name: " + user.getFullName());
//			System.out.println("Email: " + user.getEmail());
//			System.out.println("Phone: " + user.getPhone());
//			System.out.println("Designation: " + user.getDesignation());
//			System.out.println("Password: " + user.getPassword());
//			// Assuming you have a getter for the imageBase64 property
//			System.out.println("Image Base64: " + user.getImageBase64());
//		}
//
//		themodel.addAttribute("user", theUser);
//
//		return "AdminEdit";
//	}

	/* ======================================== */

	@GetMapping("/AdminEdit")
	public String AdminEdit(@RequestParam("id") int theId, Model themodel) {

		User theUser = dao.updateUsercurret(theId);

		String fullName = theUser.getFullName();
		String email = theUser.getEmail();
		String password = theUser.getPassword();
		String phone = theUser.getPhone();
		String designation = theUser.getDesignation();

		themodel.addAttribute("fullName", fullName);
		themodel.addAttribute("email", email);
		themodel.addAttribute("password", password);
		themodel.addAttribute("phone", phone);
		themodel.addAttribute("designation", designation);
		themodel.addAttribute("id", theId);

		byte[] imageData = theUser.getImage();

		themodel.addAttribute("image", imageData);

		String imageBase64 = Base64.getEncoder().encodeToString(imageData);
		themodel.addAttribute("imageBase64", theUser.getImageBase64());

		System.out.println(" User Edit controller " + theUser.getImageBase64());
		System.out.println(" User Edit controller imageBase64  " + imageBase64);

		themodel.addAttribute("user", theUser);

		return "AdminEdit";

	}

	/* ============================== */

	/*
	 * @GetMapping("/AdminEdit") public String AdminEdit(@RequestParam("id") int
	 * theId, Model themodel) {
	 * 
	 * List<User> theUser = dao.updateUser(theId);
	 * 
	 * // Check if there is at least one user if (!theUser.isEmpty()) {
	 * themodel.addAttribute("user", theUser); } else { return "login"; }
	 * 
	 * return "AdminEdit"; }
	 */
	/*
	 * @PostMapping("/UpdateAdmin") public String
	 * UpdateAdmin(@ModelAttribute("user") User theUser, @RequestParam("image")
	 * MultipartFile file) {
	 * 
	 * if (!file.isEmpty()) { try { // Convert the image file to a byte array byte[]
	 * imageBytes = file.getBytes();
	 * 
	 * // Convert the byte array to a base64-encoded string String imageBase64 =
	 * Base64.getEncoder().encodeToString(imageBytes);
	 * 
	 * // Set the imageBase64 in the user object
	 * theUser.setImageBase64(imageBase64); } catch (IOException e) {
	 * e.printStackTrace(); // Handle the exception appropriately } }
	 * 
	 * dao.UpdateSaveUser(theUser);
	 * 
	 * return "redirect:/list"; }
	 * 
	 */

	/* ======================================== */
	@PostMapping("/UpdateAdmin")
	public String UpdateAdmin(@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("designation") String designation,
			@RequestParam("password") String password, @RequestParam("image") MultipartFile image,
			@RequestParam("imageBase64") String imageBase64, @RequestParam("imageData") byte[] imageDataform,
			@RequestParam("id") int theId, Model theModel) {

		System.out.println(" Update user name" + fullName);
		System.out.println(" Update user  email" + email);
		System.out.println(" Update user  phone" + phone);
		System.out.println(" Update user designation " + designation);
		System.out.println(" Update user imageBase64 " + imageBase64);
		System.out.println(" Update user " + image.getContentType());
		System.out.println("Update User Form  imageDataform" + imageDataform);

		if (image != null && !image.isEmpty()) {
			System.out.println("Image is selected ");
			try {
				System.out.println("Byte Image " + image.getBytes());
				byte[] imageData = image.getBytes();

				System.out.println(" byte code for process form " + imageData);

				User userData = new User();
				userData.setFullName(fullName);
				userData.setEmail(email);
				userData.setPhone(phone);
				userData.setDesignation(designation);
				userData.setPassword(password);
				userData.setImage(imageData);
				userData.setId(theId);

				String base64Image = Base64.getEncoder().encodeToString(imageData);
				userData.setImageBase64(base64Image);

				System.out.println("Image base 64  " + base64Image);
				dao.UpdateSaveUser(userData);
				return "redirect:/list";

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			User userData = new User();
			System.out.println("Image is not selected ");
			userData.setFullName(fullName);
			userData.setEmail(email);
			userData.setPhone(phone);
			userData.setDesignation(designation);
			userData.setPassword(password);
			userData.setImage(imageDataform);
			System.out.println("Image Data " + imageDataform);
			userData.setImageBase64(imageBase64);
			System.out.println("ImageBase64 " + imageBase64);
			userData.setId(theId);

			dao.UpdateSaveUser(userData);
			return "redirect:/list";
		}

		return "redirect:/login";
	}
	/* =============================== */

	/*
	 * @GetMapping("/DeleteAddmin") public String DeleteAdmin(@RequestParam("id")
	 * int theId, Model theModel) {
	 * 
	 * dao.delteUser(theId);
	 * 
	 * User theUser = new User(); theModel.addAttribute("user", theUser); // return
	 * "redirect:/DetailsPage"; return "redirect:/adminPage"; return
	 * "redirect:/list"; }
	 */

	@GetMapping("/DeleteAdmin")
	public String DeleteAdmin(@RequestParam("id") int theId, Model theModel) {

		dao.delteUser(theId);

		User theUser = new User();
		theModel.addAttribute("user", theUser);
//		return "redirect:/DetailsPage";
		/* return "redirect:/adminPage"; */
		return "redirect:/list";
	}

	/* ================================================ */

	@GetMapping("/uploadFile")
	public String uploadFile() {

		return "upload_file";
	}

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam("image") MultipartFile file) {

		System.out.println("Content type " + file.getContentType());
		System.out.println("original name " + file.getOriginalFilename());
		System.out.println("size of file " + file.getSize());

		try {
			System.out.println("byte of file " + file.getBytes());

		} catch (IOException e) {

			e.printStackTrace();
		}
		return "redirect:/login";
	}

	@GetMapping("/Image_login")
	public String showForm() {
		return "Image_login";
	}

	@PostMapping("/processForm")
	public String processForm(@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("designation") String designation,
			@RequestParam("password") String password, @RequestParam("image") MultipartFile image, Model theModel) {

		System.out.println("Conetent Type " + image.getContentType());
		System.out.println("Name of image " + image.getName());

		System.out.println("Original image " + image.getOriginalFilename());

		if (!image.isEmpty()) {

			try {
				System.out.println("Byte Image " + image.getBytes());
				byte[] imageData = image.getBytes();

				System.out.println(" byte code for process form " + imageData);

				User userData = new User();
				userData.setFullName(fullName);
				userData.setEmail(email);
				userData.setPhone(phone);
				userData.setDesignation(designation);
				userData.setPassword(password);
				userData.setImage(imageData);

				String base64Image = Base64.getEncoder().encodeToString(imageData);
				userData.setImageBase64(base64Image);

				System.out.println("Image base 64  " + base64Image);
				// Save the entire form data to the database
				dao.saveCustomer(userData);
				theModel.addAttribute("user", userData);
				return "redirect:/login";
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		return "redirect:/Image_login";

	}

}
