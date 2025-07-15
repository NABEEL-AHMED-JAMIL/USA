package coding.gen;

public class LinkListGen<T> {

    private T data;
    private LinkListGen<T> next;

    public LinkListGen(T data, LinkListGen<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkListGen<T> getNext() {
        return next;
    }

    public void setNext(LinkListGen<T> next) {
        this.next = next;
    }
}
