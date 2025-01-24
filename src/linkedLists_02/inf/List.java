package linkedLists_02.inf;

public interface List<T> {

     void insert(T data);
     void insertMiddle(int index ,T data);
     void remove(T data);
     void traverse();
     int size();

}
