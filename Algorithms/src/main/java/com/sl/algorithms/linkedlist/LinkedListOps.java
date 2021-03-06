package com.sl.algorithms.linkedlist;

public class LinkedListOps {

    private LinkedListOps() {
        /**
         * This is a utility class.<br>
         */
    }

    // O(n)
    public static String printList(ListNode node) {
        StringBuilder output = new StringBuilder("[");
        while (node != null) {
            output = output.append(node.data);
            node = node.next;
        }
        output.append("]");
        return output.toString();
    }

    // O(n)
    public static int getSize(ListNode head) {
        if (head == null) {
            return 0;
        }
        return (1 + getSize(head.next));
    }

    // O(1)
    public static ListNode insertAtStart(ListNode head, int newData) {
        ListNode newNode = new ListNode(newData);
        newNode.next = head;
        head = newNode;
        return head;
    }

    // O(1)
    public static ListNode insertAfter(ListNode node, int newData) {
        if (node == null) {
            return null;
        }
        ListNode newNode = new ListNode(newData);
        newNode.next = node.next;
        node.next = newNode;
        return node;
    }

    // O(1)
    public static ListNode insertAtPosition(ListNode head, int data, int position) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }
        ListNode curr = head;
        int index = 1;
        while (curr.next != null && index < position) {
            curr = curr.next;
            index++;
        }
        if (index < position) { // handle overflow
            return head;
        }
        // now we've reached the required 'position'
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    // O(n)
    public static ListNode insertAtEnd(ListNode head, int newElement) {
        ListNode newNode = new ListNode(newElement);
        if (head == null) {
            return newNode;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    // O(1)
    public static ListNode deleteAtStart(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = temp.next;
        return head;
    }

    // O(1)
    public static ListNode deleteAtPosition(ListNode head, int deleteIndex) {
        ListNode prev = null;
        ListNode curr = head;
        int index = 1;
        while (curr != null) {
            if (index == deleteIndex) {
                if (prev == null) {
                    head = curr.next;
                    return head;
                }
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        return head;
    }

    // O(n)
    public static ListNode deleteAtEnd(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // O(n)
    public static ListNode deleteSpecificData(ListNode head, int data) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.data == data) {
                if (prev == null) {
                    head = curr.next;
                    return head;
                }
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    // O(n)
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    // O(n)
    public static ListNode reverseList(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head, next = null;
        int i = 0;
        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        if (next != null) {
            head.next = reverseList(next, k);
        }
        if (prev != null) {
            head = prev;
        }
        return head;
    }

    /**
     * Counter-clockwise rotation:<br><br>
     * 1. Reach the kth node and preserve it<br>
     * 2. Continue linkedlist, reach to the original tail<br>
     * 3. Join original tail with the original head<br>
     * 4. Mark (k+1)th node as the new head<br>
     * 5. Mark kth node as the new tail<br>
     * // O(n)
     */
    public static ListNode rotateListLeft(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode kNode = null, curr = head;
        // traverse upto kth node
        for (int i = 1; i < k; i++) {
            curr = curr.next;
            if (curr == null) {
                curr = head;
            }
        }
        // preserve the kth node
        kNode = curr;
        // now reach the end
        while (curr.next != null) {
            curr = curr.next;
        }
        // point next of last node to previous head
        curr.next = head;
        // point head to (k+1)th node
        head = kNode.next;
        // point (k+1)th node to null (as it is the new tail)
        kNode.next = null;
        return head;
    }

    /**
     * Clockwise rotation:<br><br>
     * 1. Reach the original tail and record size<br>
     * 2. Find the new tail where seed=(n-(k%n))
     * 3. Join original tail with the original head<br>
     * 4. Mark (n-k+1)th node as the new head<br>
     * 5. Mark (n-k)th node as the new tail<br>
     * // O(n)
     */
    public static ListNode rotateListRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int size = 1;
        ListNode fast = head, slow = head;
        // reach the original tail and find the size
        while (fast.next != null) {
            size++;
            fast = fast.next;
        }
        // find the seed value to find the new tail
        // (k%size) is to ensure we can handle any value of k i.e. k <=> size
        int seed = size - (k % size);
        for (int i = seed; i > 1; i--) {
            slow = slow.next;
        }
        // join original tail with original head
        fast.next = head;
        // set the new head
        head = slow.next;
        // point the new tail to null
        slow.next = null;
        return head;
    }

    public static boolean isIdentical(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.data != b.data) {
                break;
            }
            a = a.next;
            b = b.next;
        }
        if (a == null && b == null) {
            return true;
        }
        return false;
    }

    // deep copy O(n)
    public static ListNode cloneList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode deepCopy = new ListNode(head.data);
        if (head.next == null) {
            return deepCopy;
        }
        ListNode latest = new ListNode(head.next.data);
        deepCopy.next = latest;
        while (head.next.next != null) {
            ListNode temp = new ListNode(head.next.next.data);
            latest.next = temp;
            latest = temp;
            head = head.next;
        }
        return deepCopy;
    }

    // O(n) method to remove duplicates from a sorted list
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode next = null;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                next = curr.next;
                curr.next = null;
                curr.next = next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    //alternative O(n) method to remove duplicates; but this doesn't cleanup dupes explicitly
    public static ListNode removeDuplicatesNoDereference(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    // O(n) cleanup the duplicated nodes completely
    public static ListNode cleanupDuplicatedNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode dummy = new ListNode(0); // dummy helps have an initial value for prev pointer; it's own value is inconsequential though
        dummy.next = head;
        prev = dummy;
        while (curr != null) {
            while (curr.next != null && curr.data == curr.next.data) {
                curr = curr.next;
            }
            if (prev.next == curr) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    // O(m+n)
    public static ListNode mergeSortedLists(ListNode aHead, ListNode bHead) {
        if (aHead == null) {
            return bHead;
        }
        if (bHead == null) {
            return aHead;
        }
        ListNode mHead = null;
        if (aHead.data <= bHead.data) {
            mHead = aHead;
            mHead.next = mergeSortedLists(aHead.next, bHead);
        } else {
            mHead = bHead;
            mHead.next = mergeSortedLists(aHead, bHead.next);
        }
        return mHead;
    }

    // O(m+n)
    public static ListNode mergeSortedListsIteratively(ListNode aHead, ListNode bHead) {
        if (aHead == null) {
            return bHead;
        }
        if (bHead == null) {
            return aHead;
        }
        ListNode mHead = null;
        if (aHead.data <= bHead.data) {
            mHead = aHead;
            aHead = aHead.next;
        } else {
            mHead = bHead;
            bHead = bHead.next;
        }
        ListNode mNext = mHead;
        while (aHead != null && bHead != null) {
            if (aHead.data <= bHead.data) {
                mNext.next = aHead;
                mNext = aHead;
                aHead = aHead.next;
            } else {
                mNext.next = bHead;
                mNext = bHead;
                bHead = bHead.next;
            }
        }
        // handle the case when one list contains all values less that second list
        if (aHead != null) {
            mNext.next = aHead;
        }
        if (bHead != null) {
            mNext.next = bHead;
        }
        return mHead;
    }

    //O(n) time and O(1) space
    public static ListNode incrementByOne(ListNode head) {
        if (head == null) {
            return head;
        }
        int numberToAdd = 1;
        boolean addOne = true;
        head = reverseList(head);
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (addOne) {
                curr.data += numberToAdd;
            }
            if (curr.data > 9) {
                curr.data = curr.data % 10;
                addOne = true;
            } else {
                addOne = false;
            }
            curr = curr.next;
        }
        if (addOne) {
            curr.data += numberToAdd;
            if (curr.data > 9) {
                curr.data = curr.data % 10;
                curr.next = new ListNode(numberToAdd);
            }
        }
        head = reverseList(head);
        return head;
    }
}
