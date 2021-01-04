package sample;

public class Link <T>{
private T link;
private Link<T> next;

    public Link(T link){
        this.link = link;
    }
public Link<T> getNext(){
        return next;
}

public void setNext(Link<T> next){
        this.next = next;
}
public T getValue(){
        return link;
}

static class LinkedList <T>{

        public LinkedList(){
            first = null;
        }
        public boolean isEmpty(){
            return first==null;
        }

       Link<T> first;
       public void insert(T link){
          Link<T> l = new Link<>(link);
          l.setNext(first);
          this.first = l;
       }

       public void delete(){
           if(!isEmpty()){
               first = first.getNext();
           }
       }
public void display(){
           Link<T> current = first;
           while (current!=null){
               System.out.println(current.getValue());
               current = current.getNext();
           }
}
}

    public static void main(String[] args) {
        //    Задание 3.3
LinkedList<String> linkedList = new LinkedList<>();
linkedList.insert("Элемент 1 ");
linkedList.insert("Элемент 2 ");
linkedList.insert("Элемент 3 ");
linkedList.display();
linkedList.delete();
linkedList.display();

    }

}
