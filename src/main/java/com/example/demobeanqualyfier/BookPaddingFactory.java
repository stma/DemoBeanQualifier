package com.example.demobeanqualyfier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookPaddingFactory {

    private final int minColumnSize;
    private final int sidePadding;

    public BookPaddingFactory(@Value("${min_column_size}") int mcs, @Value("${side_padding}") int sp) {
        this.minColumnSize = mcs;
        this.sidePadding = sp;
    }
    public BookPadding create(Book book) {
        int titleSize = Math.max(book.title().length() + 2 * this.sidePadding, minColumnSize);
        int authorSize = Math.max(book.author().length() + 2 * this.sidePadding, minColumnSize);
        int lineSize = titleSize + authorSize + 3;

        return new BookPadding(titleSize, authorSize, lineSize);
    }

    public BookPadding create(List<Book> bs) {
        int titleSize = minColumnSize;
        int authorSize = minColumnSize;

        for (Book book: bs) {
            titleSize = Math.max(book.title().length() + 2 * this.sidePadding, titleSize);
            authorSize = Math.max(book.author().length() + 2 * this.sidePadding, authorSize);
        }

        return new BookPadding(titleSize, authorSize, titleSize + authorSize + 3);
    }

}
