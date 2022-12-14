/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package t8;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

    private Node root;
    
    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }
    public BinaryTree(){
        root = null;
    }
    /*public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    } */
    
    public void insert(String aData){
        if(this.root == null){
            root = new Node(aData);
        } else {
            setLocator(aData, this);
        }
    }

    private void setLocator(String aData, BinaryTree parent){

        int comparisonValue = aData.compareTo(parent.root.getData());

        if(comparisonValue < 0){
            if(parent.root.left() == null){
                parent.root.setRight(new BinaryTree(aData));
                return;
            } else {
                parent = parent.root.left();
            }
        } else {
            if(parent.root.right() == null){
                parent.root.setRight(new BinaryTree(aData));
                return;
            } else {
                parent = parent.root.right();
            }
        }
        setLocator(aData, parent);
    }
    
    public BinaryTree find(String aData){
        
        return findLocator(aData, this);
    }

    private BinaryTree findLocator(String aData, BinaryTree parent){
        if(parent != null){
            System.out.println("Iiii");
            int comparisonValue = aData.compareTo(parent.root.getData());

            if(comparisonValue < 0){
                findLocator(aData, parent.root.left());
            } else if(comparisonValue > 0){
                findLocator(aData, parent.root.right());
            }
            return parent;
        } else {
            return null;
        }
    }

    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+',');
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }

    }
  
    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
}
