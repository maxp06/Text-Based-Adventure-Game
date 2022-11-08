package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private final Position position;
  private final int x;
  private final int y;
  private String name;
  private String description;
  private Inventory chest;
  private boolean visited = false;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null || description == null) {
      throw new IllegalArgumentException();
    }

    this.position = new PositionImpl(x, y);
    this.x = x;
    this.y = y;
    this.name = name;
    this.description = description;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public Position getPosition() {
    return this.position;
  }

  public Inventory getChest() {
    return this.chest;
  }

  public boolean getIsVisited() {
    return this.visited;
  }

  public boolean hasChest() {
    return !(this.chest == null);
  }

  public void setName(String name) {
    if (name != null) {
      this.name = name;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public void setDescription(String description) {
    if (description != null) {
      this.description = description;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public void setChest(Inventory chest) {
    if (!(chest == null)) {
      this.chest = chest;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public void visit() {
    visited = true;
  }
}
