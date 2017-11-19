package by.tc.controller.impl;

import by.tc.controller.XMLCommand;
import by.tc.controller.exception.ControllerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParseCommand implements XMLCommand {
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ControllerException {
        String parser = req.getParameter("parser");
        if (parser == null) {
            throw new ControllerException("Parser parametr wasn't defined");
        }

        //TODO
    }
}
