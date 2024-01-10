package com.mayank.linkedlist;

import static com.mayank.linkedlist.LinkedListHelper.createLinkedList;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode list = createLinkedList(new int[]{ 1,2,3,4,5});
        System.out.println(list);
        System.out.println(removeNthFromEnd(list, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        ListNode temp = head;

        while(temp !=null){
            temp = temp.next;
            length++;
        }

        if(n>length){
            n = n% length;
        }
        int moveTill = length-n;

        temp = head;
        ListNode previous = null;

        while( moveTill != 0){
            previous = temp;
            temp = temp.next;
            moveTill--;
        }

        if(temp != null){
            previous.next = temp.next;
        }
        return head;
    }
}
