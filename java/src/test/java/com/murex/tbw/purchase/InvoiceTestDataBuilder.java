package com.murex.tbw.purchase;

import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.TestCountries;

public class InvoiceTestDataBuilder {
    private Country country = TestCountries.USA;
    private PurchasedBook purchasedBook = PurchasedBookTestDataBuilder
            .aPurchasedBook()
            .build();

    public static InvoiceTestDataBuilder anInvoice() {
        return new InvoiceTestDataBuilder();
    }

    public InvoiceTestDataBuilder from(Country country) {
        this.country = country;
        return this;
    }

    public InvoiceTestDataBuilder with(PurchasedBook book) {
        this.purchasedBook = book;
        return this;
    }

    public InvoiceTestDataBuilder with(PurchasedBookTestDataBuilder builder) {
        this.purchasedBook = builder.build();
        return this;
    }

    public Invoice build() {
        Invoice invoice = new Invoice("Test Client", country);
        invoice.addPurchasedBook(purchasedBook);

        return invoice;
    }
}
