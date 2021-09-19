class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.equals("")) {
            return "";
        }
        
        Deque<String> queue = new LinkedList<String>();
        StringBuilder str = new StringBuilder();
        for (String curr : path.split("/")) {
            if (curr.equals("..") && !queue.isEmpty()) {
                queue.removeLast();
            } 
            if (curr.equals(".") || curr.equals("") || curr.equals("..")) {
                continue;
            } else {
                queue.addLast(curr);
            }

        }
        if (queue.isEmpty()) {
            return "/";
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            str.append("/" + queue.removeFirst());
        }
        return str.toString();

    }
}