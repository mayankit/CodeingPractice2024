package com.mayank.tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Traversal {

    public static void main(String[] args) {
        Traversal tr = new Traversal();

        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(7);

        t1.right = t5;
        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t5.left = t6;

        System.out.println(tr.preOrderRecursive(t1));
        PreOrderIterator preOrderIterator = new PreOrderIterator(t1);
        List<Integer> preOrderList = StreamSupport
                .stream(((Iterable<TreeNode>) () -> preOrderIterator).spliterator(), false)
                .map(x->x.val)
                .collect(Collectors.toList());
        System.out.println(preOrderList);
        System.out.println(tr.postOrderRecursive(t1));
        PostOrderIterator postOrderIterator = new PostOrderIterator(t1);
        List<Integer> postOrderList = StreamSupport
                .stream(((Iterable<TreeNode>) () -> postOrderIterator).spliterator(), false)
                .map(x->x.val)
                .collect(Collectors.toList());
        System.out.println(postOrderList);
        System.out.println(tr.inOrderRecursive(t1));
        InorderIterator iterator = new InorderIterator(t1);
        List<Integer> inOrderList = StreamSupport
                .stream(((Iterable<TreeNode>) () -> iterator).spliterator(), false)
                .map(x->x.val)
                .collect(Collectors.toList());
        System.out.println(inOrderList);
        System.out.println(tr.preOrderIterative(t1));
        System.out.println(tr.preOrderRecursive(t1).equals(tr.preOrderIterative(t1)));
        System.out.println(tr.postOrderIterative(t1));
        System.out.println(tr.postOrderRecursive(t1).equals(tr.postOrderIterative(t1)));
        System.out.println(tr.inOrderIterative(t1));
    }

    public List<Integer> preOrderRecursive(TreeNode root){
        List<Integer> traversal = new ArrayList<>();
        preOrder(root, traversal);
        return traversal;
    }

    private void preOrder(TreeNode root, List<Integer> traversal) {
        if(root == null) return;

        traversal.add(root.val);
        preOrder(root.left, traversal);
        preOrder(root.right, traversal);
    }

    public List<Integer> inOrderRecursive(TreeNode root){
        List<Integer> traversal = new ArrayList<>();
        inOrder(root, traversal);
        return traversal;
    }

    private void inOrder(TreeNode root, List<Integer> traversal) {
        if(root == null) return;
        inOrder(root.left, traversal);
        traversal.add(root.val);
        inOrder(root.right, traversal);
    }


    public List<Integer> postOrderRecursive(TreeNode root){





        List<Integer> traversal = new ArrayList<>();
        postOrder(root, traversal);
        return traversal;
    }

    private void postOrder(TreeNode root, List<Integer> traversal) {
        if(root == null) return;
        postOrder(root.left, traversal);
        postOrder(root.right, traversal);
        traversal.add(root.val);
    }

    public List<Integer> preOrderIterative(TreeNode root){
        if(root == null) return new ArrayList<>();//empty array list
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);

            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }

        return list;
    }



    public List<Integer> postOrderIterative(TreeNode root){
        if(root == null) return new ArrayList<>();//empty array list
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisitedNode = null;
        while(!stack.isEmpty() || node != null){

            if( node != null){
                stack.push(node);
                node = node.left;
            } else{
                TreeNode peekNode = stack.peek();

                if(peekNode.right != null && lastVisitedNode!=peekNode.right){
                   node = peekNode.right;
                }else{
                    list.add(peekNode.val);
                    lastVisitedNode = stack.pop();
                }
            }
        }
      return list;
    }

    public List<Integer> inOrderIterative(TreeNode root){
        if(root == null) return new ArrayList<>();//empty array list
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node!=null){

            if(node != null){
                stack.push(node);
                node = node.left;
            } else{
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }

        }
        return list;
    }

}
