package by.tc.controller.impl;

import by.tc.controller.XMLCommand;
import by.tc.controller.exception.ControllerException;
import by.tc.entity.Card;
import by.tc.service.XMLServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisplayCommand implements XMLCommand {
    private static final int recordsPerPage = 5;
    private static final String pageParam = "page";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ControllerException, ServletException, IOException {
        int currentPage = 0;
        String pageParamValue = req.getParameter(pageParam);
        if (pageParamValue != null) {
            currentPage = Integer.getInteger(pageParamValue);
        }

        List<Card> currentCards = XMLServiceFactory.getInstance().getXmlService().parse(5, currentPage);

        System.out.println(currentCards);
        req.setAttribute("cardList", currentCards);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pageCount", XMLServiceFactory.getInstance().getXmlService().getPageCount(recordsPerPage));

        req.getRequestDispatcher("/result").forward(req, resp);
    }
}
