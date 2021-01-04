package sample;

public class LinkM {
    public String name;
    public  int age;
    public LinkM next;

    public LinkM(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println("name: " + name + " age: " + age);
    }
}
class LinkedListM{
    public LinkM first;
    public LinkedListM(){first=null;}
    public boolean isEmpty(){return (first==null);}
    public void insert (String name, int age){
        LinkM linkM = new LinkM(name, age);
        linkM.next = first;
        first = linkM;
    }

    public String delete(){
        LinkM temp = first;
        first = first.next;
        return temp.name;
    }

    public void display(){
        LinkM current = first;
        while(current!=null){
            current.display();
            current = current.next;
        }
    }
}
class StackListM{
    private LinkedListM listM;
    public StackListM(){
        listM = new LinkedListM();
    }
    public void push(String name, int age){ listM.insert(name, age); }
    public String pop(){return listM.delete();}
    public boolean isEmpty(){return listM.isEmpty();}
    public void display(){
        listM.display();}
}
class QueueM {
    private LinkedListM queue;
    public QueueM(){queue = new LinkedListM();}
    public boolean isEmpty(){return queue.isEmpty();}
    public void insert(String name, int age){queue.insert(name, age);}
    public String delete(){return queue.delete();}
    public void display(){queue.display();}

}