package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private final String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public boolean equals(Object other) {
    if (other instanceof Item) {
      Item temp = (Item) other;
      return this.name.equals(temp.getName());
    } else {
      return false;
    }
  }

  public String toString() {
    return this.name;
  }
}
