package org.jabref.logic.importer.fetcher;

import java.util.Collections;
import java.util.Locale;
import java.util.Optional;

import org.jabref.logic.importer.FetcherClientException;
import org.jabref.logic.importer.FetcherException;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;
import org.jabref.testutils.category.FetcherTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@FetcherTest
class CrossRefTest {

    private CrossRef fetcher;
    private BibEntry barrosEntry;

    @BeforeEach
    void setUp() throws Exception {
        fetcher = new CrossRef();

        barrosEntry = new BibEntry();
        barrosEntry.setField(StandardField.TITLE, "Service Interaction Patterns");
        barrosEntry.setField(StandardField.AUTHOR, "Alistair Barros and Marlon Dumas and Arthur H. M. ter Hofstede");
        barrosEntry.setField(StandardField.YEAR, "2005");
        barrosEntry.setField(StandardField.PUBLISHER, "Springer Berlin Heidelberg");
        barrosEntry.setField(StandardField.DOI, "10.1007/11538394_20");
        barrosEntry.setField(StandardField.ISSN, "0302-9743");
        barrosEntry.setField(StandardField.PAGES, "302-318");
    }

    @Test
    void findExactData() throws Exception {
        BibEntry entry = new BibEntry();
        entry.setField(StandardField.TITLE, "Service Interaction Patterns");
        entry.setField(StandardField.AUTHOR, "Barros, Alistair and Dumas, Marlon and Arthur H.M. ter Hofstede");
        entry.setField(StandardField.YEAR, "2005");
        assertEquals("10.1007/11538394_20", fetcher.findIdentifier(entry).get().asString().toLowerCase(Locale.ENGLISH));
    }

    @Test
    void findMissingAuthor() throws Exception {
        BibEntry entry = new BibEntry();
        entry.setField(StandardField.TITLE, "Towards Application Portability in Platform as a Service");
        entry.setField(StandardField.AUTHOR, "Stefan Kolb");
        assertEquals("10.1109/sose.2014.26", fetcher.findIdentifier(entry).get().asString().toLowerCase(Locale.ENGLISH));
    }

    @Test
    void findTitleOnly() throws Exception {
        BibEntry entry = new BibEntry();
        entry.setField(StandardField.TITLE, "Towards Application Portability in Platform as a Service");
        assertEquals("10.1109/sose.2014.26", fetcher.findIdentifier(entry).get().asString().toLowerCase(Locale.ENGLISH));
    }

    @Test
    void notFindIncompleteTitle() throws Exception {
        BibEntry entry = new BibEntry();
        entry.setField(StandardField.TITLE, "Towards Application Portability");
        entry.setField(StandardField.AUTHOR, "Stefan Kolb and Guido Wirtz");
        assertEquals(Optional.empty(), fetcher.findIdentifier(entry));
    }

    @Test
    void acceptTitleUnderThreshold() throws Exception {
        BibEntry entry = new BibEntry();
        entry.setField(StandardField.TITLE, "Towards Application Portability in Platform as a Service----");
        entry.setField(StandardField.AUTHOR, "Stefan Kolb and Guido Wirtz");
        assertEquals("10.1109/sose.2014.26", fetcher.findIdentifier(entry).get().asString().toLowerCase(Locale.ENGLISH));
    }

    @Test
    void notAcceptTitleOverThreshold() throws Exception {
        BibEntry entry = new BibEntry();
        entry.setField(StandardField.TITLE, "Towards Application Portability in Platform as a Service-----");
        entry.setField(StandardField.AUTHOR, "Stefan Kolb and Guido Wirtz");
        assertEquals(Optional.empty(), fetcher.findIdentifier(entry));
    }

    @Test
    void findWrongAuthor() throws Exception {
        BibEntry entry = new BibEntry();
        entry.setField(StandardField.TITLE, "Towards Application Portability in Platform as a Service");
        entry.setField(StandardField.AUTHOR, "Stefan Kolb and Simon Harrer");
        assertEquals("10.1109/sose.2014.26", fetcher.findIdentifier(entry).get().asString().toLowerCase(Locale.ENGLISH));
    }

    @Test
    void findWithSubtitle() throws Exception {
        BibEntry entry = new BibEntry();
        // CrossRef entry will only include { "title": "A break in the clouds", "subtitle": "towards a cloud definition" }
        entry.setField(StandardField.TITLE, "A break in the clouds: towards a cloud definition");
        assertEquals("10.1145/1496091.1496100", fetcher.findIdentifier(entry).get().asString().toLowerCase(Locale.ENGLISH));
    }

    @Test
    void findByDOI() throws Exception {
        assertEquals(Optional.of(barrosEntry), fetcher.performSearchById("10.1007/11538394_20"));
    }

    @Test
    void findByAuthors() throws Exception {
        assertEquals(Optional.of(barrosEntry), fetcher.performSearch("\"Barros, Alistair\" AND \"Dumas, Marlon\" AND \"Arthur H.M. ter Hofstede\"").stream().findFirst());
    }

    @Test
    void findByEntry() throws Exception {
        BibEntry entry = new BibEntry();
        entry.setField(StandardField.TITLE, "Service Interaction Patterns");
        entry.setField(StandardField.AUTHOR, "Barros, Alistair and Dumas, Marlon and Arthur H.M. ter Hofstede");
        entry.setField(StandardField.YEAR, "2005");
        assertEquals(Optional.of(barrosEntry), fetcher.performSearch(entry).stream().findFirst());
    }

    @Test
    void performSearchByIdFindsPaperWithoutTitle() throws Exception {
        BibEntry entry = new BibEntry(StandardEntryType.Article);
        entry.setField(StandardField.AUTHOR, "Dominik Wujastyk");
        entry.setField(StandardField.DOI, "10.1023/a:1003473214310");
        entry.setField(StandardField.ISSN, "0019-7246");
        entry.setField(StandardField.PAGES, "172-176");
        entry.setField(StandardField.VOLUME, "42");
        entry.setField(StandardField.YEAR, "1999");
        entry.setField(StandardField.JOURNAL, "Indo-Iranian Journal");
        entry.setField(StandardField.NUMBER, "2");
        entry.setField(StandardField.PUBLISHER, "Brill");

        assertEquals(Optional.of(entry), fetcher.performSearchById("10.1023/a:1003473214310"));
    }

    @Test
    void performSearchByEmptyId() throws Exception {
        assertEquals(Optional.empty(), fetcher.performSearchById(""));
    }

    @Test
    void performSearchByEmptyQuery() throws Exception {
        assertEquals(Collections.emptyList(), fetcher.performSearch(""));
    }

    /**
     * reveal fetching error on crossref performSearchById
     */
    @Test
    void performSearchValidReturnNothingDOI() {
        assertThrows(FetcherClientException.class, () -> fetcher.performSearchById("10.1392/BC1.0"));
    }
}
