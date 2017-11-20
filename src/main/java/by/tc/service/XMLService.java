package by.tc.service;

import by.tc.entity.Card;

import java.util.List;

public interface XMLService {
    List<Card> parse(String parser, String file);
}
