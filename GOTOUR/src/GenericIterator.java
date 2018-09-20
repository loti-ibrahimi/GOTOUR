import java.util.Iterator;

public class GenericIterator<I> implements Iterator<I> {

    private Node<I> position;

    public GenericIterator(Node<I> head) {
        position = head;
    }

     // Returns a boolean value indicating if there are more elements to process
    @Override
    public boolean hasNext() {
        return position != null;
    }

   
    // Returns a reference to the next element in the list.
    @Override
    public I next() {
        Node<I> temporary = position;
        position = position.nextNode;
        return temporary.getNodeContents();
    }
}
