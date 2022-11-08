package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException();
    }
    this.map = map;
    this.player = player;
  }

  public Position getPlayerPosition() {
    return player.getPosition();
  }

  public String getPlayerName() {
    return player.getName();
  }

  public List<Item> getPlayerItems() {
    return player.getInventory().getItems();
  }

  public boolean getIsWinner() {
    return map.getNumItems() == player.getInventory().getNumItems();
  }

  public void printCellInfo() {
    System.out.println("Location: " + map.getCell(player.getPosition()).getName());
    System.out.println(map.getCell(player.getPosition()).getDescription());
    if (map.getCell(player.getPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (map.getCell(player.getPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    map.getCell(player.getPosition()).visit();
  }

  public void openChest() {
    if (!map.getCell(player.getPosition()).hasChest()) {
      System.out.println("No chest to open, sorry!");
    } else if (map.getCell(player.getPosition()).getChest().isEmpty()) {
      System.out.println("The chest is empty.");
    } else {
      System.out.println(
          "You collected these items: " + map.getCell(player.getPosition()).getChest().getItems());
      player.getInventory().transferFrom(map.getCell(player.getPosition()).getChest());
    }
  }

  public boolean canMove(Direction direction) {
    int x = player.getPosition().getNeighbor(direction).getX();
    int y = player.getPosition().getNeighbor(direction).getY();
    if (x > map.getWidth() - 1 || y > map.getHeight() - 1) {
      return false;
    } else if (x < 0 || y < 0) {
      return false;
    } else return map.getCell(x, y) != null;
  }

  public void move(Direction direction) {
    if (!this.canMove(direction)) {
      System.out.println("You can't go that way! Try another direction.");
    } else {
      player.move(direction);
      this.printCellInfo();
    }
  }
}
