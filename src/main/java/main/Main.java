package main;

import account.*;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SessionsServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();

        //accountService.addNewUser(new UserProfile("admin"));
        //accountService.addNewUser(new UserProfile("test"));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.addServlet(new ServletHolder(, "/signup");
        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/signin");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        System.out.println("Server started");
        server.start();
        server.join();
    }
}