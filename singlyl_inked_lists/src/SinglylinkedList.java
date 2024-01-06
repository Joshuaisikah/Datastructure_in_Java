import org.w3c.dom.Node;

import java.util.*;
/**
 * @author issah
 */ //
public class SinglylinkedList {
    private ListNode head;
    //this head holds the linkedlist for me

    private static class ListNode {
        private int data;
        //generic data type
        private ListNode next;

        //points to the next node
        public ListNode(int data) {
            //this is a constructor
            this.data = data;
            this.next = null;
        }
    }


    public static void main(String[] args) {
        SinglylinkedList ssl = new SinglylinkedList();
        ssl.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        // now we connect them together to form a chain which is our linked list
        ssl.head.next = second;
        //we have connceted 1 to 10;
        second.next = third;
        third.next = fourth;
        //fourth is pointing to null
        ssl.dispaly();
    System.out.println(ssl.count());
    }

    public int count(){
        int count=0;
        ListNode current =head;
        while(current!=null){
            count++;
            current = current.next;
        }
return count;
    }

    private void dispaly() {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.data + "--> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
