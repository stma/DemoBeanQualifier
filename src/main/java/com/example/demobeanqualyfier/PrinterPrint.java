package com.example.demobeanqualyfier;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrinterPrint implements Repres {

    @Autowired
    private BookPaddingFactory bookPaddingFactory;
    @Override
    public String print(Book book) {
        BookPadding bp = bookPaddingFactory.create(book);

        StringBuilder sb = new StringBuilder();

        generateHeader(bp.titleSize(), bp.authorSize(), bp.lineSize(), sb);

        generateLine(book, bp.titleSize(), bp.authorSize(), bp.lineSize(), sb);

        sb.append("-".repeat(bp.lineSize()));
        return sb.toString();
    }

    private static void generateLine(Book book, int titleSize, int authorSize, int lineSize, StringBuilder sb) {
        // data
        sb.append("\n|");
        sb.append(StringUtils.center(book.title(), titleSize));
        sb.append("|");
        sb.append(StringUtils.center(book.author(), authorSize));
        sb.append("|");
    }

    private static void generateHeader(int titleSize, int authorSize, int lineSize, StringBuilder sb) {
        // header
        sb.append("-".repeat(lineSize));
        sb.append("\n|");
        sb.append(StringUtils.center("Title", titleSize));
        sb.append("|");
        sb.append(StringUtils.center("Author", authorSize));
        sb.append("|\n");
        sb.append("-".repeat(lineSize));
    }

    @Override
    public String print(List<Book> books) {
        BookPadding bp = bookPaddingFactory.create(books);

        StringBuilder sb = new StringBuilder();

        generateHeader(bp.titleSize(), bp.authorSize(), bp.lineSize(), sb);

        for (Book book: books) {
            generateLine(book, bp.titleSize(), bp.authorSize(), bp.lineSize(), sb);
        }

        sb.append("\n" + "-".repeat(bp.lineSize()));
        return sb.toString();
    }
}
