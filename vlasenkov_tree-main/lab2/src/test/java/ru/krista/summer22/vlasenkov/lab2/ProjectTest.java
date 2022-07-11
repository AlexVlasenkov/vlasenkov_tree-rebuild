/*
package ru.krista.summer22.vlasenkov.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {

    // Проверка asserts
    @Test
    public void test1() {
        assertEquals(true, true, "Не true");
        assertTrue(true, "Не true");
    }

    // Тестим создание дерева
    @Test
    public void createTreeTest() {
        Node node = new Node("Root");
        assertEquals("Root", node.getName(), "Корневой узел");
    }

    // Добаление узла
    @Test
    public void addNodeTest() {
        Node node = new Node("Child1");
        Node node2 = node.addNode("Child2");

        Node child = node.getChildByName("Child2");
        assertEquals(node2, child);
    }

    // Проверяем корректность удаления узла
    @Test
    public void delNodeTest() {
        Node node = new Node("Child1");
        node.addNode("Child2");
        node.addNode("Child3");
        node.addNode("Child4");

        node.delNode("Child 3");
        assertNull(node.getChildByName("Child3"));
    }

    // Удаление всех узлов
    @Test
    public void delAllNodeTest() {
        Node node = new Node("Child1");
        Node node2 = new Node("Child2");
        Node node3 = new Node("Child3");
        Node node4 = new Node("Child4");

        node.delAllNode();
        assertEquals(0, node.getChildNodes().size());
    }

    // Тестим смену имени узла
    @Test
    public void changeNodeTest() {
        Node node = new Node("Child1");

        node.changeNodeName(node, "ChildNewName");
        assertEquals("ChildNewName", node.getName());
    }

    @Test
    public void seekNodeTest() {
        Node node = new Node("Child1");
        node.addNode("Child2");
        node.addNode("Child3");
        node.addNode("Child4");

        Node child = node.seekNode("Child2");
        assertEquals("Child2", child.getName());
    }

    // Вывод через рекурсивный обход дерева
    @Test
    public void printTreeTest() {
        Node node = new Node("Child1");
        node.addNode("Child2");
        node.addNode("Child3");
        node.addNode("Child4");
        node.bypassTree(1);
    }

    @Test
    public void saveTreeTest() {
        Node node = new Node("Child1");
        node.addNode("Child2");
        node.addNode("Child3");
        node.addNode("Child4");
        node.saveTreeToJson();
    }

    @Test
    public void readTreeTest() {
        Node node = new Node();
        node = node.readTreeFromJson(); // !!
        node.bypassTree(1);
    }
}
*/
