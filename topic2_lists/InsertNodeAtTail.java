// SpaniardsToSv. Please report an issue if you have any questions.

// HackerRank documentation.
/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  
  class Node {
     int data;
     Node next;
  }
*/

/**
* Our solution. Please note that there could always be more than one.
*
*/

public class InsertNodeAtTail {
    SinglyLinkedListNode insert(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode tail = new SinglyLinkedListNode(data);
        if (head == null) {
            return tail;
        }

        SinglyLinkedListNode trackingNode = head;

        while (trackingNode.next != null) {
            trackingNode = trackingNode.next;
        }
        trackingNode.next = tail;
        return head;
    }

    public static void main(String[] args) {

    }
}