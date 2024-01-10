package com.mayank.tree;

import java.util.Iterator;
import java.util.Stack;

public class PostOrderIterator implements Iterator<TreeNode> {
    TreeNode node;

    Stack<TreeNode> stack;

    TreeNode lastVisitedNode;

    public PostOrderIterator(TreeNode root){
        this.node = root;
        stack = new Stack<>();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }

    @Override
    public TreeNode next() {
        while(!stack.isEmpty() || node != null){

            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                TreeNode peekNode = stack.peek();
                if(peekNode.right != null && lastVisitedNode != peekNode.right){
                    node = peekNode.right;
                }else{
                    lastVisitedNode=stack.pop();
                    break;
                }
            }
        }
        return lastVisitedNode;
    }
}
