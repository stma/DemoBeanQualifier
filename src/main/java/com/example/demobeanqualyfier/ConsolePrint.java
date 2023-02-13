package com.example.demobeanqualyfier;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsolePrint implements Repres {
    @Override
    public String print(Book book) {
//        return String.format("\n\t%s:\n\t\tszerző: %s\n\n", book.title(), book.author());

        return String.format("""
  %s:
      szerző: %s

""",
                book.title(),
                book.author()
        );
    }

    @Override
    public String print(List<Book> books) {
        StringBuilder sb = new StringBuilder();
//        books.forEach((b) -> sb.append(this.print(b)));
        for (Book b: books) {
            sb.append(this.print(b));
        }

        return sb.toString();
    }
}
