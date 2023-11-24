package com.tomslabs.exercises.chapter2;

public class Exercise18 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(queue);

        queue.addNode("lalala");
        queue.addNode("knife");
        queue.addNode("wut");
        queue.addNode("tomato");
        queue.addNode("bird");
        System.out.println(queue);

        Queue.Node firstEverNode = queue.removeFirstNode();
        System.out.println("firstEverNode = " + firstEverNode);
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
            Iterator iterator = iterator();

            while (iterator.hasNext()) {
                Node node = iterator.next();
                sb.append(node.getText());
                if (iterator.hasNext())
                    sb.append("->");
            }

            sb.append("]");
            return sb.toString();
        }

        public Iterator iterator() {
            return new Iterator(startNode);
        }

        private static class Iterator {
            Node currentNode = null;

            private Iterator(Node startNode) {
                this.currentNode = startNode;
            }

            boolean hasNext() {
                return currentNode != null && currentNode.getNext() != null;
            }

            Node next() {
                Node temp = null;
                if (currentNode != null) {
                    temp = currentNode;
                    currentNode = currentNode.getNext();
                }
                return temp;
            }
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
