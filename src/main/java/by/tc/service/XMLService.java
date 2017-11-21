package by.tc.service;

import by.tc.entity.Card;
import by.tc.service.exception.ServiceException;

import java.util.List;

public interface XMLService {
    List<Card> parse(String parser, String file) throws ServiceException;
    List<Card> parse(int recordsPerPage, int currentPage);
    int getPageCount(int recordsPerPage);
}
