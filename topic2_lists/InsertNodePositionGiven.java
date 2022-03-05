/*
  Insert Node at a given position in a linked list
  head can be NULL
  First element in the linked list is at position 0
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/
public class InsertNodePositionGiven {
    SinglyLinkedListNode insertNth(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode toInsert = new SinglyLinkedListNode(data);
        if (head == null) {
            return toInsert;
        }
        if (position == 0) {
            toInsert.next = head;
            return toInsert;
        }
        int index = 0;
        SinglyLinkedListNode tracker = head;

        // We don't assume that the position that we are given will ever be greater
        // than the number of elements in the list + 1. If so, we would need to add
        // the element at the end of the list.
        while (tracker.next != null && index != position - 1) {
            tracker = tracker.next;
            index++;
        }

        //insertInBetween(tracker, toInsert);
        SinglyLinkedListNode tmp = tracker.next;
        tracker.next = toInsert;
        toInsert.next = tmp;

        return head;
    }

    private static void insertInBetween(SinglyLinkedListNode current, SinglyLinkedListNode toInsert) {
        SinglyLinkedListNode tmp = current.next;
        current.next = toInsert;
        toInsert.next = tmp;
    }

    public static void main(String[] args) {}
}