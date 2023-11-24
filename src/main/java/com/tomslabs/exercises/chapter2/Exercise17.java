package com.tomslabs.exercises.chapter2;

public class Exercise17 {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.addNode("lalala");
        queue.addNode("knife");
        queue.addNode("wut");
        queue.addNode("tomato");
        queue.addNode("bird");

        System.out.println(queue);

        queue.removeFirstNode();
        System.out.println(queue);

        queue.removeFirstNode();
        System.out.println(queue);

        queue.addNode("mint");
        System.out.println(queue);
    }

    private static class Queue {
        private Node startNode = null;

        public void addNode(String text) {
            addNode(new Node(text));
        }

        public void addNode(Node nodeToAdd) {
            if (startNode == null) {
                startNode = nodeToAdd;
                return;
            }

            Node runner = startNode;
            while (runner.getNext() != null) {
                runner = runner.getNext();
            }

            runner.setNext(nodeToAdd);
        }

        public Node removeFirstNode() {
            if (startNode == null)
                return null;

            Node removedNode = startNode;
            startNode = startNode.getNext();
            return removedNode;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder().append("[");
            Node runner = startNode;
            while (runner.getNext() != null) {
                sb.append(runner.getText()).append("->");
                runner = runner.getNext();
            }
            sb.append(runner.getText()).append("]");
            return sb.toString();
        }

        private static class Node {
            String text;
            Node next = null;

            public Node(String text) {
                this.text = text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public String getText() {
                return text;
            }

            public Node getNext() {
                return next;
            }
        }
    }
}
