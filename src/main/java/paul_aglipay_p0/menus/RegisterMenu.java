package paul_aglipay_p0.menus;

import java.io.BufferedReader;

import paul_aglipay_p0.exceptions.InvalidRequestException;
import paul_aglipay_p0.models.User;
import paul_aglipay_p0.services.UserService;
import paul_aglipay_p0.util.MenuRouter;

public class RegisterMenu extends Menu {

	UserService userService;

	public RegisterMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("Register", "/register", consoleReader, router);
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("The User selected Register");

		// Things to obtain from user: first name, last name, email,username, password

		System.out.println("Please provided us with some basic information");
		System.out.print("First Name: ");
		String firstName = consoleReader.readLine();

		System.out.print("Last Name: ");
		String lastName = consoleReader.readLine();

		System.out.print("Email: ");
		String email = consoleReader.readLine();

		System.out.print("Username: ");
		String username = consoleReader.readLine();

		System.out.print("Password: ");
		String password = consoleReader.readLine();

		User User = new User(firstName, lastName, email, username, password);

		try {
			userService.registerNewUser(User);
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("YOU HAVE PROVIDED INVALID DATA PLEASE TRY AGAIN\n\n\n");

			router.transfer("/welcome");
		}
	}

}