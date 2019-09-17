package com.benbenxiang.test.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            /*ListNode result = new ListNode(l1.val + l2.val);
            ListNode next = result;
            ListNode tempL1 = l1, tempL2 = l2;
            int temp = 0;
            while ( hasNext(tempL1) || hasNext(tempL2) || temp != 0){
                if(hasNext(tempL1))
                    tempL1 = tempL1.next;
                else
                    tempL1 = null;
                if(hasNext(tempL2))
                    tempL2 = tempL2.next;
                else
                    tempL2 = null;
                int sum = (tempL1 != null ? tempL1.val : 0) + (tempL2 != null ? tempL2.val : 0) + temp;
                next.next = new ListNode( sum % 10);
                next = next.next;
                temp = sum / 10;
            }
            return result;*/

            ListNode result = null;
            ListNode next = result;
            ListNode tempL1 = l1, tempL2 = l2;
            int temp = 0;
            while ( tempL1 != null || tempL2 != null || temp != 0){
                int sum = (tempL1 != null ? tempL1.val : 0) + (tempL2 != null ? tempL2.val : 0) + temp;
                if(next != null) {
                    next.next = new ListNode(sum % 10);
                    next = next.next;
                } else {
                    result = new ListNode(sum % 10);
                    next = result;
                }

                temp = sum / 10;

                if(hasNext(tempL1))
                    tempL1 = tempL1.next;
                else
                    tempL1 = null;
                if(hasNext(tempL2))
                    tempL2 = tempL2.next;
                else
                    tempL2 = null;
            }
            return result;
        }





    public static void main(String[] args) {
        ListNode l1 = new ListNode(2), l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printListNode(l1);
        printListNode(l2);
        ListNode listNode = addTwoNumbers(l1, l2);
        printListNode(listNode);
    }

    public static void printListNode(ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

        public static boolean hasNext(ListNode listNode){
            if(listNode == null)
                return false;
            if(listNode.next != null)
                return true;
            else
                return false;
        }

    public static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
    }
}
