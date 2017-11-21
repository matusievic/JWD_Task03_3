package by.tc.controller.impl;

import by.tc.controller.XMLCommand;
import by.tc.controller.exception.ControllerException;
import by.tc.entity.Card;
import by.tc.service.XMLServiceFactory;
import by.tc.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ParseCommand implements XMLCommand {
    private static final String parserParam = "parser";
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ControllerException, ServletException, IOException {
        String parserParamValue = req.getParameter(parserParam);
        if (parserParamValue == null) {
            throw new ControllerException("Parser parameter wasn't defined");
        }

        try {
            List<Card> oldCards = XMLServiceFactory.getInstance().getXmlService().parse(parserParamValue, (String) req.getAttribute("xmlFilePath"));
        } catch (ServiceException e) {
            throw new ControllerException("Cannot get cards", e);
        }

        new DisplayCommand().execute(req, resp);
    }
}
