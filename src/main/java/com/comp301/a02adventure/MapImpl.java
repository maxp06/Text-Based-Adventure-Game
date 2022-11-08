package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final int hidden;
  private final int width;
  private final int height;
  private final Cell[][] grid;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException();
    }
    this.hidden = numItems;
    this.width = width;
    this.height = height;
    this.grid = new Cell[this.height][this.width];
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public Cell getCell(int x, int y) {
    if (x > width || y > height) {
      throw new IndexOutOfBoundsException();
    } else {
      return this.grid[y][x];
    }
  }

  public Cell getCell(Position position) {
    if (position.getX() > width || position.getY() > height) {
      throw new IndexOutOfBoundsException();
    } else {
      return this.grid[position.getY()][position.getX()];
    }
  }

  public void initCell(int x, int y) {
    if (x > width || y > height) {
      throw new IndexOutOfBoundsException();
    } else {
      this.grid[y][x] = new CellImpl(x, y);
    }
  }

  public int getNumItems() {
    return hidden;
  }
}
