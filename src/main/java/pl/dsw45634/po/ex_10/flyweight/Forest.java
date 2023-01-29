package pl.dsw45634.po.ex_10.flyweight;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

class Forest extends JFrame {

  private List<Tree> trees = new ArrayList<>();

  public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
    TreeType treeType = TreeFactory.getTreeType(name, color, otherTreeData);
    Tree tree = new Tree(x, y, treeType);
    this.trees.add(tree);
  }

  @Override
  public void paint(Graphics graphics) {
    for(Tree tree : this.trees) {
      tree.draw(graphics);
    }
  }
}
