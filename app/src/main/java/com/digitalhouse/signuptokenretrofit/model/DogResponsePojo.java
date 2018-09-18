package com.digitalhouse.signuptokenretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DogResponsePojo {

    @SerializedName("category")
    private String category;

    @SerializedName("urlImageList")
    private List<String> list = new ArrayList<String>();

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}
