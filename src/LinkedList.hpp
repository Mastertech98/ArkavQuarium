template <typename T>
struct ElementList {
    ElementList(const T& element) : data(element) {
        next = 0;
    }

    T data;
    ElementList<T>* next;
};

template <typename T>
class LinkedList {        
    public:
        LinkedList() {
            first = 0;
        }

        ~LinkedList() {
            for (ElementList<T>* e = first; e != 0;) {
                ElementList<T>* tmp = e->next;
                delete e;
                e = tmp;
            }
        }

        ElementList<T>* getFirst() {
            return first;
        }
        
        int find(const T& element) {
            int i = 0;
            for (ElementList<T>* e = first; e != 0; e = e->next, i++) {
                if (e->data == element) {
                    return i;
                }
            }
            return -1;
        }

        bool isEmpty() {
            return first == 0;
        }

        void add(const T& element) {
            if (isEmpty()) {
                first = new ElementList<T>(element);
            } else {
                ElementList<T>* e;
                for (e = first; e->next != 0; e = e->next);
                e->next = new ElementList<T>(element);
            }
        }

        void remove(const T& element) {
            for (ElementList<T>* e = first,* prec = 0; e != 0; prec = e, e = e->next) {
                if (e->data == element) {
                    if (e == first) {
                        first = e->next;
                    } else {
                        prec->next = e->next;
                    }
                    delete e;
                }
            }
        }

        T get(int index) {
            ElementList<T>* e = first;
            for (int i = 0; i < index && e != 0; i++, e = e->next);
            return e != 0 ? e->data : 0;
        }
    
    private:
        ElementList<T>* first;
};