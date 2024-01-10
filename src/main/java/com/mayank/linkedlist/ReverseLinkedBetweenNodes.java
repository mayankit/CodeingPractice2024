package com.mayank.linkedlist;

import static com.mayank.linkedlist.LinkedListHelper.createLinkedList;

public class ReverseLinkedBetweenNodes {

    public static void main(String[] args) {
        ListNode list = createLinkedList(new int[]{ 1,2});
        System.out.println(list);
        System.out.println(reverseBetween(list, 1, 2));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return head;
        if(head.next == null) return head;
        if(left == right) return head;

        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftHead = dummy;
        ListNode leftHeadPrevious = null;

        while(count!= left){
            leftHeadPrevious = leftHead;
            leftHead = leftHead.next;
            count++;
        }

        if(leftHeadPrevious != null){
            leftHeadPrevious.next = null;
        }

        ListNode begin = leftHead;
        ListNode end = begin;
        while(count != right){
            end = end.next;
            count++;
        }

        ListNode rightNodeAfter = end.next;
        end.next = null;

        ListNode reverse = reverse(begin);
        leftHeadPrevious.next = reverse;
        begin.next = rightNodeAfter;

        return head;
    }

    private static  ListNode reverse(ListNode list) {

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
