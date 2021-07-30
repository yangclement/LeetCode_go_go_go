/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        //这题其实就是BFS, 没有什么难得，主要是要会怎么把你的function分区
        //有个优美的coding style
        //一共有三个parts：找点，复制点，复制边
        if (node == null) {
            return node;
        }
        List<Node> allNodes = new ArrayList<>();
        //先loop这个graph，可以把node都看完，然后再clone
        findAllNodes(allNodes, node);
        //这个map用来记录旧node和新node的对映
        Map<Node, Node> copyList = new HashMap<>();
        copyAllNodes(allNodes, copyList);
        copyAllEdges(allNodes, copyList);
        return copyList.get(node);
    }
    //copyEdges
    private void copyAllEdges(List<Node> nodes, Map<Node, Node> copyList) {
        for (Node curr : nodes) {
            Node newNode = copyList.get(curr);
            for (Node oldNeighbors : curr.neighbors) {
                newNode.neighbors.add(copyList.get(oldNeighbors));
            }
        }
    }
    
    //copyNodes
    private void copyAllNodes(List<Node> nodes, Map<Node, Node> copyList) {
        for (Node curr : nodes) {
            //这里不能直接neigbors不能直接赋值进来，因为这样还是reference
            //就算直接new arraylist<>(curr.neighbors)，只是新的neighbors list，但是里面的node还是旧的
            //需要弄个新的neighbors list，然后加入新的node加进去neighbors
            copyList.put(curr, new Node(curr.val));
        }
    }
    
    private void findAllNodes(List<Node> nodes, Node node) {
        //这个没法用单队列来做了，node的结构会把相同的node加进来
        //用set来防止duplicate
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (int i = 0; i < curr.neighbors.size(); i++) {
                if (!visited.contains(curr.neighbors.get(i))) {
                    //没visite过
                    nodes.add(curr.neighbors.get(i));
                    visited.add(curr.neighbors.get(i));
                    queue.add(curr.neighbors.get(i));
                }
            }
            //走完邻居再看看自己是否被加进去了
            if (!visited.contains(curr)) {
                nodes.add(curr);
                visited.add(curr);
            }
        }
    }
}