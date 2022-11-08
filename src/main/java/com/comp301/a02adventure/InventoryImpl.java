package com.comp301.a02adventure;

import java.util.List;
import java.util.ArrayList;

public class InventoryImpl implements Inventory {
  private final List<Item> list;

  public InventoryImpl() {
    list = new ArrayList<Item>();
  }

  public boolean isEmpty() {
    return list.size() == 0;
  }

  public int getNumItems() {
    return list.size();
  }

  public List<Item> getItems() {
    List<Item> clonedList = new ArrayList<Item>(list);
    return clonedList;
  }

  public void addItem(Item item) {
    list.add(item);
  }

  public void removeItem(Item item) {
    list.remove(item);
  }

  public void clear() {
    list.clear();
  }

  public void transferFrom(Inventory other) {
    for (int i = 0; i < other.getNumItems(); i++) {
      list.add(other.getItems().get(i));
    }
    other.clear();
  }
}
