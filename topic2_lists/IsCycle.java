/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
*/

import java.util.HashSet;
import java.util.Set;

/**
* The list has less than 100 items. Therefore, we can keep the reference to each
* of the nodes - as it will not be memory expensive.
* If we see that reference (that node) while we iterate over the list,
* it means that there is a cycle.
*/
public class IsCycle {
    boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null) {
            return false;
        }
        Set<SinglyLinkedListNode> nodeTrackingList = new HashSet<>();
        while (head != null) {
            if (nodeTrackingList.contains(head)) {
                return true;
            }
            nodeTrackingList.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * Another option would be to move two pointers. One should be twice faster.
     * If there are any cycles, this should never end, but it will meet the other
     * pointer. This idea is much more creative.
     **/
    boolean hasCycle2Pointers(SinglyLinkedListNode head) {
        if (head == null) {
            return false;
        }

        SinglyLinkedListNode trackerSlow = head;
        SinglyLinkedListNode trackerFast = head.next;

        while (trackerFast != null && trackerFast != trackerSlow) {
            if (trackerFast.next == null) {
                return false;
            }
            trackerFast = trackerFast.next.next;
            trackerSlow = trackerSlow.next;
        }
        return trackerFast == trackerSlow;
    }

    public static void main(String[] args) {

    }
}
