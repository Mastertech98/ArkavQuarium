public class LinkedList<T> {
  private ElementList<T> first;

  public LinkedList() {
    first = null;
  }

  public ElementList<T> getFirst() {
    return first;
  }

  public int find(T element) {
    int i = 0;
    for (ElementList<T> e = first; e != null; e = e.getNext(), i++) {
      if (e.getData().equals(element)) {
        return i;
      }
    }
    return -1;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void add(T element) {
    if (isEmpty()) {
      first = new ElementList<>(element);
    } else {
      ElementList<T> e;
      for (e = first; e.getNext() != null; e = e.getNext()) {}
      e.setNext(new ElementList<>(element));
    }
  }

  public void remove(T element) {
    for (ElementList<T> e = first, precedence = null; e != null; precedence = e, e = e.getNext()) {
      if (e.getData().equals(element)) {
        if (e == first) {
          first = e.getNext();
        } else {
          precedence.setNext(e.getNext());
        }
        break;
      }
    }
  }

  public T get(int index) {
    ElementList<T> e = first;
    for (int i = 0; i < index && e != null; i++, e = e.getNext()) {}
    return e != null ? e.getData() : null;
  }
}