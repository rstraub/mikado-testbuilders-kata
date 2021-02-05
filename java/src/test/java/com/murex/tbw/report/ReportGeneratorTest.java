package com.murex.tbw.report;

import com.google.common.collect.Lists;
import com.murex.tbw.domain.book.Author;
import com.murex.tbw.domain.book.Genre;
import com.murex.tbw.domain.book.Novel;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;
import com.murex.tbw.purchase.Invoice;
import com.murex.tbw.purchase.PurchasedBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportGeneratorTest {
    @Test
    void No_Constraint_Converts_total_amount_to_usd() {
        // Instantiate an Invoice sent to USA
        Country country = new Country("France", Currency.EURO, Language.FRENCH);
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
        // Instantiate a ReportGenerator
        ReportGenerator generator = new ReportGenerator();
        // It needs to use a data source that contains one invoice in a non-USD currency
        // Assert that the amount returned by ReportGenerator is converted to USD currency
        //
        // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
        // Don't forget to reset the data source at the end of your test!
    }

    @Test
    void Test_Data_Builders_Constraint_Converts_total_amount_to_usd() {
        // Using the Test Data Builder pattern:
        // Instantiate a ReportGenerator
        // It needs to use a data source that contains one invoice in a non-USD currency
        // Assert that the amount returned by ReportGenerator is converted to USD currency
        //
        // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
        // Don't forget to reset the data source at the end of your test!
    }

    @Test
    void Mikado_Method_Constraint_Converts_total_amount_to_usd() {
        // Using the Mikado method:
        // Instantiate a ReportGenerator
        // It needs to use a data source that contains one invoice in a non-USD currency
        // Assert that the amount returned by ReportGenerator is converted to USD currency
        //
        // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
        // Don't forget to reset the data source at the end of your test!
    }

    @Test
    void Mikado_Method_And_Test_Data_Builders_Constraint_Converts_total_amount_to_usd() {
        // Using the Mikado method and the Test Data Builder pattern:
        // Instantiate a ReportGenerator
        // It needs to use a data source that contains one invoice in a non-USD currency
        // Assert that the amount returned by ReportGenerator is converted to USD currency
        //
        // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
        // Don't forget to reset the data source at the end of your test!
    }
}
