package com.mayank.tree;

import java.util.Iterator;
import java.util.Stack;

public class InorderIterator implements Iterator<TreeNode> {

    TreeNode node;
    Stack<TreeNode> stack;

    TreeNode lastVisitedNode;

    public InorderIterator(TreeNode node){
        this.stack = new Stack<>();
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }

    @Override
    public TreeNode next() {

        while(!stack.isEmpty()||node != null){
            if(node !=null){
                stack.push(node);
                node = node.left;
            }else{
                this.lastVisitedNode = stack.pop();
                node = this.lastVisitedNode.right;
                break;
            }
        }

        return this.lastVisitedNode;
    }
}
