package com.rewindFast;
//we have created this doubly linked list without dummy nodes, we have saved space here but written lot of code
/* to save code length, we could create a dummy node as head = new Node(0) & tail = new Node(0) and
accordingly make changes in push , pop and peek/getTailMethod()
 */
public class StackAsDoublyLinkedList {
    Node head, tail;

    public StackAsDoublyLinkedList() {
        head = tail = null;
    }

    Node getHead() {
        return head;
    }

    Node getTail() {
        return tail;
    }

    void push(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            Node tail = getTail();
            tail.next = node;
            node.back = tail;

            this.tail = node;
        }
    }

    Node pop() {
        if (head == null) {
            return null;
        }
        Node removedNode = getTail();
        this.tail = removedNode.back;
        this.tail.next = null;
        removedNode.back = null;
        return removedNode;
    }

    void remove(Node node){
        if(this.head == node){
            this.head = node.next;
            if(this.head!=null){
                this.head.back = null;
            }
        }else  if(this.tail == node){
            this.tail = node.back;
            if(this.tail!=null){
                this.tail.next = null;
            }
        }else{
            Node backNode  = node.back;
            Node frontNode  = node.next;
            backNode.next = frontNode;
            frontNode.back = backNode;
            node.next = null;
            node.back = null;
        }
    }
}


class Node {
    Integer val;
    Node next;
    Node back;

    public Node() {
        val = null;
        next = back = null;
    }
}
