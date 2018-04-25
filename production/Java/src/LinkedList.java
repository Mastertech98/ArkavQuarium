public class LinkedList<T> {
  private ElementList<T> first;

  /**
     * Constructor : Initialize first with null
     */
  public LinkedList() {
    first = null;
  }

  /**
     * Get variable first's data
     * @return variable first
     */
  public ElementList<T> getFirst() {
    return first;
  }

  /**
     * Get index with value equals to argument.
     * If not value found in list, then return -1
     * @param element data will be compared with this object
     * @return index of element if found and -1 if not found
     */
  public int find(T element) {
    int i = 0;
    for (ElementList<T> e = first; e != null; e = e.getNext(), i++) {
      if (e.getData().equals(element)) {
        return i;
      }
    }
    return -1;
  }

  /**
     * Return true if list is empty
     * @return true if list is empty
     */
  public boolean isEmpty() {
    return first == null;
  }

   /**
     * Add element to the list
     * @param element element which will be added to list
     */
  public void add(T element) {
    if (isEmpty()) {
      first = new ElementList<>(element);
    } else {
      ElementList<T> e;
      for (e = first; e.getNext() != null; e = e.getNext()) {}
      e.setNext(new ElementList<>(element));
    }
  }

  /**
     * Remove first element in the list with same value as element
     * @param element value of element which will be removed
     */
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

  /**
     * If found, return data of element list
     * @param index index of data which will be returned
     * @return if found, return data of element list
     */
  public T get(int index) {
    ElementList<T> e = first;
    for (int i = 0; i < index && e != null; i++, e = e.getNext()) {}
    return e != null ? e.getData() : null;
  }
}