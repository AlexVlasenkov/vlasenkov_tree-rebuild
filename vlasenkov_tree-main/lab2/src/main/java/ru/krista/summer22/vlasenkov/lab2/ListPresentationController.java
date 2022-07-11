package ru.krista.summer22.vlasenkov.lab2;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Контроллер отвечающий за представление дерева.
 */
@Path("/")
public class ListPresentationController {
    private final Node node;

    /**
     * Запоминает дерево, с которым будет работать.
     *
     * @param node дерево, с которым будет работать контроллер.
     */
    public ListPresentationController(Node node) {
        this.node = node;
    }

    /**
     * Выводит HTML-страницу с деревом, ссылками на страницы редактирования и копкой добавления записи.
     *
     * @return HTML-страница со списком.
     */
    @GET
    @Path("/")
    @Produces("text/html")
    public String getNode() {
        String result =
                "<html>" +
                        " <head>" +
                        " <title>Tree Web</title>" +
                        " </head>" +
                        " <body>" +
                        " <h1>Дерево</h1>" +
                        " <ul>";
        result += getHTMLTree(node, "0");

        result += " </ul>" +
                " <br/>" +
                " <form method=\"post\" action=\"add_random_item\">" +
                " </form>" +
                " </body>" +
                "</html>";
        return result;
    }

    /**
     * Вывод дерева
     *
     * @param node  текущий узел
     * @param level уровень узла
     * @return HTML-страница с деревом.
     */
    private String getHTMLTree(Node node, String level) {
        Integer i = 0;
        String result =
                "<font size=\"+2\"><li>"
                + node.getName()
                + " <a href=\"edit/" + level + "\">Редактировать</a>"
                + " <a href=\"delete/" + level + "\">Удаление</a> "
                + " <a href=\"addNodeTree/" + level + "\">Добавить узел</a> "
                + "</font></li>";
        result += "<ul>";
        for (Node child : node.getChildNodes()) {
            // Рекурсия
            result += "<font size=\"+2\">" + getHTMLTree(child, level + "." + i);
            i++;
        }
        result += "</font></ul>";
        return result;
    }

    /**
     * Добавляет одну случайную запись в список и перенаправляет пользователя на основную страницу со списком.
     *
     * @return перенаправление на основную страницу со списком.
     */
    @GET
    @Path("addNodeTree/{id}")
    @Produces("text/html")
    public Response addRandomItem(@PathParam("id") String itemId, @FormParam("value") String itemValue) {
        Node child = getNodeByIndex(itemId);
        child.addNode("Новый узел");

        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    /**
     * удаление узла
     *
     * @param itemId индекс удаляемого элемента
     * @return перенаправление на основную страницу со списком.
     */
    @GET
    @Path("/delete/{id}")
    @Produces("text/html")
    public Response delete(@PathParam("id") String itemId) {
        Node res = node;
        String[] id = itemId.split("\\.");
        if (id.length != 1) {
            for (int i = 1; i < id.length - 1; i++) {
                res = res.getChildNodes().get(Integer.parseInt(id[i]));
            }
            res.getChildNodes().remove(Integer.parseInt(id[id.length - 1]));
        }


        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    /**
     * @param itemId
     * @return
     */
    private Node getNodeByIndex(@PathParam("id") String itemId) {
        Node res = node;
        String[] id = itemId.split("\\.");
        if (id.length != 1) {
            for (int i = 1; i < id.length; i++) {
                res = res.getChildNodes().get(Integer.parseInt(id[i]));
            }
        }
        return res;
    }

    /**
     * Выводит страничку для редактирования одного элемента.
     *
     * @param itemId индекс элемента списка.
     * @return страничка для редактирования одного элемента.
     */
    @GET
    @Path("/edit/{id}")
    @Produces("text/html")
    public String getEditPage(@PathParam("id") String itemId) {
        Node res = getNodeByIndex(itemId);
        String result =
                "<html>" +
                "<head>" +
                " <title>Edit node</title>" +
                "</head>" +
                "<body>" +
                " <h1>Редактирование элемента списка</h1>" +
                " <form method=\"post\" action=\"/edit/" + itemId + "\">" +
                " <p>Значение</p>" +
                " <input type=\"text\" name=\"value\" value=\"" + res.getName() + "\"/>" +
                " <input type=\"submit\"/>";
        result +=
                " </form>" +
                "</body>" +
                "</html>";
        return result;
    }

    /**
     * Редактирует элемент списка на основе полученных данных.
     *
     * @param itemId индекс элемента списка.
     * @return перенаправление на основную страницу со списком.
     */
    @POST
    @Path("/edit/{id}")
    @Produces("text/html")
    public Response editItem(@PathParam("id") String itemId, @FormParam("value") String itemValue) {
        Node result = getNodeByIndex(itemId);
        result.setName(itemValue);
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }
}
