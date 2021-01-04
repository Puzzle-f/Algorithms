package sample;

public class MainM{
    public static void main(String[] args) {
//        Задание 4.5
        StackListM sl = new StackListM();
        sl.push("Bob", 15);
        sl.push("John", 30);
        sl.push("Dron", 50);
        sl.display();
        while (!sl.isEmpty()){
            System.out.println(sl.pop() + " удалён");
        }

    QueueM q = new QueueM();
    q.insert("Arnold", 45);
    q.insert("Adolf", 8);
    q.insert("Alfred", 78);
    q.display();
    while (!q.isEmpty()){
        System.out.println(q.delete() + " Удален");
    }
    }
}
