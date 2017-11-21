package by.tc.controller.impl;

import by.tc.controller.XMLCommand;
import by.tc.controller.exception.ControllerException;
import by.tc.entity.Card;
import by.tc.service.XMLService;
import by.tc.service.XMLServiceFactory;
import by.tc.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ParseCommand implements XMLCommand {
    private static final String file = "xml/oldcards.xml";
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ControllerException {
        String parser = req.getParameter("parser");
        if (parser == null) {
            throw new ControllerException("Parser parameter wasn't defined");
        }

        try {
            List<Card> oldCards = XMLServiceFactory.getInstance().getXmlService().parse(parser, file);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}
