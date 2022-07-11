package ru.krista.summer22.vlasenkov.lab2;

import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Web-приложение в котором регистрируются все ресурсы.
 */
public class WebApplication extends Application {

    public Node node = new Node("0");

    public WebApplication() {
        node.addNode("0.1");
        node.addNode("0.2");
        node.addNode("0.3");
        Node node1 = node.addNode("0.3.1");
        node1.addNode("0.4");
        node.addNode("0.5");
    }

    /**
     * Возвращает список всех ресурсов web-приложения.
     *
     * @return список всех ресурсов web-приложения.
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = new HashSet<>();
        resources.add(new ListPresentationController(node));
        return resources;
    }
}

