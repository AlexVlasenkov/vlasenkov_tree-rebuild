package ru.krista.summer22.vlasenkov.lab2;

import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

/**
 * Консольное приложение.
 */
public class Application {

    public static void main(String[] argv) {
        startWebServer();
    }

    /**
     * Запускает web-сервер. По окончании работы требуется ручная остановка процесса.
     */
    private static void startWebServer() {
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.deploy(WebApplication.class);
        // 4226.9
        /*Undertow.Builder serverBuilder = Undertow.builder().addHttpListener(8081 + 5557, "0.0.0.0");
        server.start(serverBuilder);
        System.out.println("Сервер запущен: http://localhost:8081/");*/

        Undertow.Builder serverBuilder = Undertow.builder().addHttpListener(8080, "0.0.0.0");
        server.start(serverBuilder);
        System.out.println("Сервер запущен: http://localhost:8080/");
    }
}
