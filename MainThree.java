package sample;

class Person {
    public String name;
    public int id;
    public int age;

    public Person(String name, int id, int age) {
        this.age = age;
        this.id = id;
        this.name = name;
    }
}

class Node {
    public Person person;
    public Node leftChild;
    public Node rightChild;

    public void display() {
        System.out.println("name " + person.name + " age " + person.age);
    }
}

class Three {
    private Node root; // корневой узел

    public void insert(Person person) {
        Node node = new Node(); // узел, который будем вставлять
        node.person = person;   // присваиваем этому узлу person
        if (root == null) {
            root = node;
        } else {
            Node current = root; // текущий узел
            Node parent; // родитель
            while (true) {
                parent = current;
                if (person.id < current.person.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }


    public Node find(int key) {
        Node current = root;
        while (current.person.id != key) {
            if (key < current.person.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) return null;
        }
        return current;
    }

    public boolean delete(int id) {
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;

        while (current.person.id != id) {
            parent = current;
            if (id < current.person.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }


    public void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public Node min() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }
}

public class MainThree {
    public static void main(String[] args) {

        Three three = new Three();

        three.insert(new Person("ivan", 4, 35));
        three.insert(new Person("petr", 2, 70));
        three.insert(new Person("denis", 3, 20));
        three.insert(new Person("vano", 5, 50));

        three.max().display();
        three.min().display();

        three.find(2).display();
        three.delete(3);


    }
}