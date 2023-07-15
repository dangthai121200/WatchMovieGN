package thai.demo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	
	private String USERNAME_ATTRIBUTE = "username";
	private String PASSWORD_ATTRIBUTE = "password";
	private String LOGIN_SUCCESS_ATTRIBUTE = "loginSuccess";



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getAttribute(USERNAME_ATTRIBUTE).toString();
		String password = req.getAttribute(PASSWORD_ATTRIBUTE).toString();
		if(username.equals(password)) {
			resp.setStatus(200);
			req.getSession().setAttribute(LOGIN_SUCCESS_ATTRIBUTE, "true");
		} else {
			resp.setStatus(401);
		}
	}
	
	
	

}
