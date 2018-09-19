package com.signuptokenretrofit.model;

import java.util.ArrayList;
import java.util.List;

public class DogResponsePojo {

    private String category;
    
    private List<String> list = new ArrayList<>();

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
