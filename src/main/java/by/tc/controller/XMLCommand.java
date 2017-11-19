package by.tc.controller;

import by.tc.controller.exception.ControllerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface XMLCommand {
    void execute(HttpServletRequest req, HttpServletResponse resp) throws ControllerException;
}
