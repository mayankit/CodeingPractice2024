package com.mayank.linkedlist;

public class ListNode {
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return
                " " + val +
                "=>" + next;
    }
}
