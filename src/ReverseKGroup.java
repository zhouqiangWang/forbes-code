public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode nextI = dummy;
        while(nextI != null) {
            nextI = reverse(nextI, k);
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode ret = head.next;
        ListNode cur = head.next;
        int i = 0;
        while (cur != null && i++ < k) {
            cur = cur.next;
        }
        if (i < k) {
            return null;
        }
        ListNode nextHead = cur;

        cur = head.next.next;
        i = 0;
        while (++i < k) {
            ListNode next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
        ret.next = nextHead;

        return ret;
    }

    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = node;
        }

        return dummy.next;
    }

    static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ReverseKGroup instance = new ReverseKGroup();
        ListNode newList = instance.reverseKGroup(buildList(new int[]{1, 2, 3, 4, 5}), 2);

        printList(newList);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
