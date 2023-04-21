package unciorn.demo.dto;

import unciorn.demo.model.Item;

import java.util.List;

public class ShoppingList {

    private List<Item> list;

    public ShoppingList(List<Item> list) {
        this.list = list;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
