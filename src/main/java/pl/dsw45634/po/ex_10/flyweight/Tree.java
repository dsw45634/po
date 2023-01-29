package pl.dsw45634.po.ex_10.flyweight;

import java.awt.Graphics;

// refactoring guru

class Tree {

  private int x;
  private int y;
  private TreeType treeType;

  public Tree(int x, int y, TreeType treeType) {
    this.x = x;
    this.y = y;
    this.treeType = treeType;
  }

  public void draw(Graphics graphics) {
    treeType.draw(graphics, this.x, this.y);
  }
}
