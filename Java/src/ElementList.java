class ElementList<T> {
  /**
   * Save data of object
   */
  private final T data;
  /**
   * Save reference next elementList from this elementList
   */
  private ElementList<T> next;

  /**
   * Initialized element list with argument.
   * @param element value which will be replaced data's value
   */
  public ElementList(T element) {
    data = element;
    next = null;
  }

  /**
   * Get data of elementList.
   * @return data of elementList
   */
  public T getData() {
    return data;
  }

  /**
   * Get value of next element list.
   * @return value of next element list
   */
  public ElementList<T> getNext() {
    return next;
  }

  /**
   * Set value of next element list.
   * @param next new value of next element list
   */
  public void setNext(ElementList<T> next) {
    this.next = next;
  }
}