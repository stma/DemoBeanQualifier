package com.example.demobeanqualyfier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookPaddingFactory {

    private final int minColumnSize;

    public BookPaddingFactory(@Value("${min_column_size}") int mcs) {
        this.minColumnSize = mcs;
    }
    public BookPadding create(Book book) {
        int titleSize = Math.max(book.title().length() + 2, minColumnSize);
        int authorSize = Math.max(book.author().length() + 2, minColumnSize);
        int lineSize = titleSize + authorSize + 3;

        return new BookPadding(titleSize, authorSize, lineSize);
    }
    public BookPadding create(List<Book> bs) {
        int titleSize = minColumnSize;
        int authorSize = minColumnSize;

        for (Book book: bs) {
            titleSize = Math.max(book.title().length() + 2, titleSize);
            authorSize = Math.max(book.author().length() + 2, authorSize);
        }

        return new BookPadding(titleSize, authorSize, titleSize + authorSize + 3);
    }

}
