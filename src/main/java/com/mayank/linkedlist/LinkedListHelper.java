package com.mayank.linkedlist;

public class LinkedListHelper {

    public static ListNode createLinkedList(int[] arr){
        ListNode node = new ListNode(-1);//dummy node;
        ListNode temp = node;
        for(int i=0;i< arr.length;i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return node.next;
    }

}
