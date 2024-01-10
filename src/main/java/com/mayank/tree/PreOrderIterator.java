package com.mayank.tree;

import java.util.Iterator;
import java.util.Stack;

public class PreOrderIterator implements Iterator<TreeNode> {
    TreeNode root;

    Stack<TreeNode> stack;

    public PreOrderIterator(TreeNode node){
        this.root = node;
        this.stack = new Stack<>();
        stack.add(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
        TreeNode node = stack.pop();
        if(node.right != null) stack.add(node.right);
        if(node.left != null) stack.add(node.left);

        return node;
    }
}
