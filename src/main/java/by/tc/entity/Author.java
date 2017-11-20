package by.tc.entity;

import java.io.Serializable;

public class Author implements Serializable {
    private static final long serialVersionUID = 6979987522943389518L;
    private String name;
    private String surname;

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
