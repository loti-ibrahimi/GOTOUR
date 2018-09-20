import java.util.Iterator;

public class GenericList<N> implements Iterable<N>{

    public Node<N> head = null;

    public void addNode(N newItem) {
        // The Local newNode variable is set to the incoming object that is wrapped in a node object.
        Node<N> newNode = new Node<>();
        
        // It will initially set the first node's next node to null, and additional nodes are set to previous head.
        newNode.setNodeContents(newItem);
        
        // This will set the new node's next node address to be null (the first node) or to be what the previous head address is.
        newNode.nextNode = head;
        
        // The new Node is set to be the head of the list.
        head = newNode;
    }

    public void removeNode(N removeItem) {
        // Checks if the item to be removed is the head. Assigns head to nextNode
        if (head.getNodeContents().equals(removeItem)) {
            head = head.nextNode;
            
        // Otherwise, sets up a loop to remove the target and stitch list back together.
        } else {
            Node nodeBeforeTarget = head;
            Node nodeTarget = head.nextNode;
            Node nodeAfterTarget = head.nextNode.nextNode;
            System.out.println(head.getNodeContents().toString() + " IS NOW HEAD");
            while (nodeTarget != null && nodeTarget.getNodeContents() != removeItem){
                if (nodeTarget.getNodeContents().equals(removeItem)){
                    nodeBeforeTarget.nextNode = nodeAfterTarget;
                } else {
                    nodeBeforeTarget = nodeBeforeTarget.nextNode;
                    nodeTarget = nodeTarget.nextNode;
                    nodeAfterTarget = nodeAfterTarget.nextNode;
                }
            }
        }
    }

    @Override
    public Iterator<N> iterator(){
        return new GenericIterator<>(head);
    }

    public void clearAllNodes(){
        head = null;
    }

    public boolean isEmpty() {
        if (head == null){
            return true;
        }
        return false;
    }

    public Node<N> getHead() {
        return head;
    }

}