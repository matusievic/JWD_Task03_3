package by.tc.controller.impl;

import by.tc.controller.XMLCommand;
import by.tc.controller.exception.InternalServerException;
import by.tc.controller.exception.NotFoundException;
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
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws InternalServerException, ServletException, IOException, NotFoundException {
        String parserParamValue = req.getParameter(parserParam);
        if (parserParamValue == null) {
            throw new InternalServerException("Parser parameter wasn't defined");
        }

        try {
            List<Card> oldCards = XMLServiceFactory.getInstance().getXmlService().parse(parserParamValue, (String) req.getAttribute("xmlFilePath"));
            new DisplayCommand().execute(req, resp);
        } catch (ServiceException e) {
            throw new InternalServerException("Cannot get cards", e);
        } catch (NotFoundException e) {
            throw new NotFoundException("Cannot display the content");
        }
    }
}
