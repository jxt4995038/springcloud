package com.example.order.test;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-01-08 16:36
 */
public class CompareTest {
    private static Node[] nodes = new Node[2];

    static {
        nodes = new Node[2];
        nodes[0] = new Node("1",new Node("12",null));
    }

    public static void main(String[] args) {
        Node node= new Node("123",null);
        put(node);
    }
    public static void put(Node addNode){
        resize();

    }

    public static void resize(){
        Node[] newNodes = new Node[4];

        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            while (nodes[0].getNext()!=null){

            }
        }
    }


}

class Node{
    private String value;

    private Node next;

    public Node(){

    }
    public Node(String value,Node next){
        this.value = value;
        this.next = next;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}