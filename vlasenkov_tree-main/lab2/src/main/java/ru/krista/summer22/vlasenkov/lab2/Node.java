package ru.krista.summer22.vlasenkov.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Node {

    private List<Node> children = new ArrayList();
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public Node() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Добавляет дочерний узел
     *
     * @param name наименование дочернего узла
     * @return созданный дочерний узел
     */
    public Node addNode(String name) {
        Node node = new Node(name);
        children.add(node);
        return node;
    }

    /**
     * Поиск по имени
     *
     * @param name наименование дочернего узла
     * @return
     */
    public Node getChildByName(String name) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(name)) {
                return children.get(i);
            }
        }
        return null;
    }

    public void delNode(String name) {
        int i = 0;
        while ((i < children.size()) && (!children.get(i).getName().equals(name))) {
            i++;
        }
        if (i != children.size()) {
            children.remove(i);
        }
    }

    public void delAllNode() {
        children.clear();
    }

    public List<Node> getChildNodes() {
        return children;
    }


    public Node seekNode(String name) {
        for (Node node : children) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }


    public void changeNodeName(Node node, String newName) {
        node.setName(newName);
    }

    public void bypassTree(int n) {
        for (int i = 1; i < n; i++) {
            Logger.getLogger("    ");
        }
        Logger.getLogger(getName());
        for (Node node : children) {
            node.bypassTree(n + 1);
        }
    }

    public void sortTree() {
        children.sort(
                (Node o1, Node o2) -> o1.getName().compareTo(o2.getName())
        );


    }


    public static void observeTree(Node node, Integer level, IObserve handler) {
        handler.handler(node, level);
        for (Node n : node.getChildNodes()) {
            observeTree(n, level + 1, handler);
        }
    }
}
