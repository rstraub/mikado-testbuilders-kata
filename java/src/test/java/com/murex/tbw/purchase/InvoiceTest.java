package com.murex.tbw.purchase;

import com.google.common.collect.Lists;
import com.murex.tbw.domain.book.Author;
import com.murex.tbw.domain.book.Genre;
import com.murex.tbw.domain.book.Novel;
import com.murex.tbw.domain.book.NovelTestDataBuilder;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.murex.tbw.domain.book.NovelTestDataBuilder.aNovel;
import static com.murex.tbw.domain.country.TestCountries.USA;
import static com.murex.tbw.purchase.InvoiceTestDataBuilder.anInvoice;
import static com.murex.tbw.purchase.PurchasedBookTestDataBuilder.aPurchasedBook;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {
    @Test
    void No_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Instantiate an Invoice sent to USA
        Country country = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);
        Author author = new Author("Oscar Wilde", country);
        Novel novel = new Novel(
                "The picture of dorian gray",
                50.00,
                author,
                Language.ENGLISH,
                Lists.newArrayList(Genre.MYSTERY)
        );
        PurchasedBook book = new PurchasedBook(novel, 1);
        Invoice invoice = new Invoice("test", country);
        // Add it a purchased novel costing 50
        invoice.addPurchasedBook(book);
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
        assertEquals(56.35, invoice.computeTotalAmount());
    }

    @Test
    void Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount() {

        // Using the Test Data Builder pattern:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        Invoice invoice =
                anInvoice()
                        .from(USA)
                        .with(
                                aPurchasedBook()
                                        .of(aNovel().costing(50.0))).build();

        assertEquals(56.35, invoice.computeTotalAmount());
    }

    @Test
    void Mikado_Method_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Using the Mikado method:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }

    @Test
    void Mikado_Method_And_Test_Data_Builders_Constraint_Applies_tax_rules_when_computing_total_amount() {
        // Using the Mikado method and the Test Data Builder pattern:
        // Instantiate an Invoice sent to USA
        // Add it a purchased novel costing 50
        // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    }
}
