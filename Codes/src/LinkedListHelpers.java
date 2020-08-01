public class LinkedListHelpers {
    public static String getLinkedListToString(ListNode list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (list != null) {
            sb.append(list.val);
            if (list.next != null)
                sb.append(",");
            list = list.next;
        }
        sb.append("]");
        return sb.toString();
    }
}