class ElementList<T> {
  private final T data;
  private ElementList<T> next;

  public ElementList(T element) {
    data = element;
    next = null;
  }

  public T getData() {
    return data;
  }

  public ElementList<T> getNext() {
    return next;
  }

  public void setNext(ElementList<T> next) {
    this.next = next;
  }
}