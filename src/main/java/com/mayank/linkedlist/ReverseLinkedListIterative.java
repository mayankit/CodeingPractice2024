package com.mayank.linkedlist;

import static com.mayank.linkedlist.LinkedListHelper.createLinkedList;

public class ReverseLinkedListIterative {

    public static void main(String[] args) {
        ListNode list = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println(list);
        System.out.println(reverse(list));
    }

    private static ListNode reverse(ListNode list) {

        if(list == null) return list;

        if(list.next == null) return list;

        ListNode previous = null;
        ListNode next = null;
        ListNode current = list;

        while(current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
