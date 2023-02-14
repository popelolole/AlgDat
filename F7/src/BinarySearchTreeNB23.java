import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeNB23<E extends Comparable<E>> {
    private static class Node<E>{
        private E data;
        private Node<E> left, right;

        public Node(E d){
            data = d;
            left = right = null;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;
    private E deletedData;

    public BinarySearchTreeNB23(){
        root = null;
    }

    public E find(E target){
        return find(target, root);
    }

    private E find(E target, Node<E> node){
        if(node == null)
            return null;
        if(target.compareTo(node.data) == 0)
            return node.data;
        if(target.compareTo(node.data) < 0)
            return find(target, node.left);
        return find(target, node.right);
    }

    public int numberOfLeaves(){
        return numberOfLeaves(root);
    }

    private int numberOfLeaves(Node<E> node){
        if(node.left == null && node.right == null)
            return 1;
        else{
            int number = 0;
            if(node.left != null)
                number = numberOfLeaves(node.left);
            if(node.right != null)
                number += numberOfLeaves(node.right);
            return number;
        }
    }

    public int numberOfNodes(){
        return numberOfNodes(root);
    }

    private int numberOfNodes(Node<E> node){
        if(node.left == null && node.right == null)
            return 1;
        else{
            int number = 1;
            if(node.left != null)
                number += numberOfNodes(node.left);
            if(node.right != null)
                number += numberOfNodes(node.right);
            return number;
        }
    }

    public int height(){
        return height(root, 1);
    }

    private int height(Node<E> node, int height){
        if(node.left == null && node.right == null){
            return height;
        }
        else{
            int left = 0, right = 0;
            if(node.left != null)
                left = height(node.left, height + 1);
            if(node.right != null)
                right = height(node.right, height + 1);
            return Math.max(left, right);
        }
    }

    public boolean add(E data){
        if(root == null){
            root = new Node<E>(data);
            return true;
        }
        else
            return add(data, root);
    }

    private boolean add(E data, Node<E> node){
        if(data.compareTo(node.data) == 0)
            return false;
        else if(data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<E>(data);
                return true;
            }
            else{
                return add(data, node.left);
            }
        }
        else{
            if(node.right == null){
                node.right = new Node<E>(data);
                return true;
            }
            else{
                return add(data, node.right);
            }
        }
    }

    public E delete(E target){
        root = delete(target, root);
        return deletedData;
    }

    private Node<E> delete(E target, Node<E> node){
        if(node == null){
            deletedData = null;
            return null;
        }
        else{
            if(target.compareTo(node.data) < 0){
                node.left = delete(target, node.left);
                return node;
            }
            else if(target.compareTo(node.data) > 0) {
                node.right = delete(target, node.right);
                return node;
            }
            else{
                deletedData = node.data;
                if(node.left == null)
                    return node.right;
                else if(node.right == null)
                    return node.left;
                else{
                    Node<E> nodeToMove = node.right, parentNodeToMove = node;
                    if(nodeToMove.left == null) {
                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }
                    while(nodeToMove.left != null){
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.left;
                    }
                    parentNodeToMove.left = nodeToMove.right;
                    node.data = nodeToMove.data;
                    return node;
                }
            }
        }
    }

    public void printTree() {
        StringBuilder sb = new StringBuilder();
        Queue<Node<E>> q = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        Node<E> node;
        q.offer(root);
        levelQueue.offer(0);
        int level = 0;
        while(!q.isEmpty()){
            node = q.poll();
            int nextLevel = levelQueue.poll();
            if(level != nextLevel) {
                sb.append("\n");
                level = nextLevel;
            }
            sb.append(node).append(" ");
            if(node != null) {
                q.offer(node.left);
                q.offer(node.right);
                levelQueue.offer(level + 1);
                levelQueue.offer(level + 1);
            }
        }
        System.out.println(sb);
    }

    private void inOrder(Node<E> node, StringBuilder sb){
        if(node != null){
            inOrder(node.left, sb);
            sb.append(": " + node.toString());
            inOrder(node.right, sb);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }
}
