package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public Position getNeighbor(Direction direction) {
    int x2;
    int y2;
    if (direction == Direction.NORTH) {
      y2 = this.y + 1;
      x2 = this.x;
    } else if (direction == Direction.SOUTH) {
      y2 = this.y - 1;
      x2 = this.x;
    } else if (direction == Direction.EAST) {
      x2 = this.x + 1;
      y2 = this.y;
    } else if (direction == Direction.WEST) {
      x2 = this.x - 1;
      y2 = this.y;
    } else {
      throw new IllegalArgumentException();
    }
    return new PositionImpl(x2, y2);
  }
}
