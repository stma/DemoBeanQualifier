package com.example.demobeanqualyfier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {

    @Autowired
    @Qualifier("configured")
    private Repres printer;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        List<Book> b = List.of(new Book("Egri csillagok", "Gárdonyi Géza"),
                new Book("Egri", "Gárdonyi Géza"),
                new Book("Egri cs", "Gárdonyi Géza"),
                new Book("Egri csillagok", "Gárdonyi Géza"));

//        Book b = new Book("Egri csillagok", "Gárdonyi Géza");
        System.out.println(printer.print(b));
    }
}
