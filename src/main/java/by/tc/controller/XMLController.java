package by.tc.controller;

import by.tc.controller.exception.ControllerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XMLController extends HttpServlet {
    private static final String commandParameter = "command";
    public XMLController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter(commandParameter);
        try {
            CommandProvider.getCommand(command).execute(req, resp);
        } catch (ControllerException e) {
            req.setAttribute("exception", e);
            req.getRequestDispatcher("/WEB-INF/jsp/500.jsp").forward(req, resp);
        }
    }
}
