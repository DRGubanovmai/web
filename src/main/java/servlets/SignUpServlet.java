package servlets;

import account.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService();

        String login = request.getParameter("login");
        String password = request.getParameter("pass");

        UserProfile User = new UserProfile(login, password);
        accountService.addNewUser(User);

    }


}
