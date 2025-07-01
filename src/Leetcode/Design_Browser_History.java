package Leetcode;
//leetcode 1472
class BrowserHistory {
    class Node {
        String data;
        Node prev, next;
        Node(String x) {
            data = x;
            prev = null;
            next = null;
        }
    }
    private Node curr;
    public BrowserHistory(String homepage) {
        curr=new Node(homepage);
    }

    public void visit(String url) {
        Node urlNode=new Node(url);
        urlNode.prev = curr;
        curr.next=urlNode;
        curr=urlNode;
    }

    public String back(int steps) {
        Node trav=curr;
        while(trav.prev!=null&&steps>0){
            trav=trav.prev;
            steps--;
        }
        curr=trav;
        return curr.data;
    }

    public String forward(int steps) {
        Node trav=curr;
        while(trav.next!=null&&steps>0){
            trav=trav.next;
            steps--;
        }
        curr=trav;
        return curr.data;
    }
}

/*
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */