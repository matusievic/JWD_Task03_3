package by.tc.controller;

import by.tc.controller.exception.InternalServerException;
import by.tc.controller.exception.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface XMLCommand {
    void execute(HttpServletRequest req, HttpServletResponse resp) throws InternalServerException, ServletException, IOException, NotFoundException;
}
