public class Node<N> {

    public Node nextNode = null;
    private N contents;

    public N getNodeContents(){
        return contents;
    }
    
    public void setNodeContents(N contents){
        this.contents = contents;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

