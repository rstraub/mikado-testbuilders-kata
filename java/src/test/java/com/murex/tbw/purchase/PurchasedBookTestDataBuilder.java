package com.murex.tbw.purchase;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.domain.book.NovelTestDataBuilder;

public class PurchasedBookTestDataBuilder {
    private Book book = NovelTestDataBuilder
            .aNovel()
            .build();

    public static PurchasedBookTestDataBuilder aPurchasedBook() {
        return new PurchasedBookTestDataBuilder();
    }

    public PurchasedBookTestDataBuilder of(Book book) {
        this.book = book;
        return this;
    }

    public PurchasedBookTestDataBuilder of(NovelTestDataBuilder builder) {
        this.book = builder.build();
        return this;
    }

    public PurchasedBook build() {
        return new PurchasedBook(book, 1);
    }
}
