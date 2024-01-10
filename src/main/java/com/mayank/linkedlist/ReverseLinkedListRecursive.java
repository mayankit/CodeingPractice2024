package com.mayank.linkedlist;

import static com.mayank.linkedlist.LinkedListHelper.createLinkedList;

public class ReverseLinkedListRecursive {

    public static void main(String[] args) {
        ListNode list = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println(list);
        System.out.println(reverse(list));
    }

    private static ListNode reverse(ListNode list) {

        if(list == null) return list;

        if(list.next == null) return list;

        ListNode second = list.next;
        list.next = null;

        ListNode reverseList = reverse(second);

        second.next = list;
        return reverseList;
    }


}
