/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4_final;

/**
 *
 * @author Ciprian
 */

class Node {
    int value;
    Node left;
    Node right;
 
    public Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
  
}

public class BinaryTree {
    
    Node root;
    
    
    public static void main(String args[]){
        
        BinaryTree bt = new BinaryTree();
    bt.add(6);
    bt.add(4);
    bt.add(8);
    bt.add(3);
    bt.add(5);
    bt.add(7);
    bt.add(9);
         
        
       bt.traverseInOrder(bt.root);
       System.out.println("\n");
       bt.traversePreOrder(bt.root);
        
        
 
    
     
    }
    
    private Node addRecursive(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }
 
    if (value < current.value) {
        current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
        current.right = addRecursive(current.right, value);
    } else {
        // value already exists
        return current;
    }
 
    return current;
    
}
    
    public void add(int value) {
    root = addRecursive(root, value);
    
    
    
    
}
    
    public void traverseInOrder(Node node) {
    if (node != null) {
        traverseInOrder(node.left);
        System.out.print(" " + node.value);
        traverseInOrder(node.right);
    }
      }
    
     public void traversePreOrder(Node node) {
    if (node != null) {
        System.out.print(" " + node.value);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }
    
    
}
     
}
