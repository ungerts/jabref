package org.jabref.logic.bibtex.comparator;

import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.StandardEntryType;
import org.jabref.model.entry.field.InternalField;
import org.jabref.model.entry.field.OrFields;
import org.jabref.model.entry.field.StandardField;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldComparatorTest {
    @Test
    public void compareMonthFieldIdentity() {
        FieldComparator comparator = new FieldComparator(StandardField.MONTH);
        BibEntry equal = new BibEntry();
        equal.setField(StandardField.MONTH, "1");

        assertEquals(0, comparator.compare(equal, equal));
    }

    @Test
    public void compareMonthFieldEquality() {
        FieldComparator comparator = new FieldComparator(StandardField.MONTH);
        BibEntry equal = new BibEntry();
        equal.setField(StandardField.MONTH, "1");
        BibEntry equal2 = new BibEntry();
        equal2.setField(StandardField.MONTH, "1");

        assertEquals(0, comparator.compare(equal, equal2));
    }

    @Test
    public void compareMonthFieldBiggerAscending() {
        FieldComparator comparator = new FieldComparator(StandardField.MONTH);
        BibEntry smaller = new BibEntry();
        smaller.setField(StandardField.MONTH, "jan");
        BibEntry bigger = new BibEntry();
        bigger.setField(StandardField.MONTH, "feb");

        assertEquals(1, comparator.compare(bigger, smaller));
    }

    @Test
    public void compareMonthFieldBiggerDescending() {
        FieldComparator comparator = new FieldComparator(new OrFields(StandardField.MONTH), true);
        BibEntry smaller = new BibEntry();
        smaller.setField(StandardField.MONTH, "feb");
        BibEntry bigger = new BibEntry();
        bigger.setField(StandardField.MONTH, "jan");

        assertEquals(1, comparator.compare(bigger, smaller));
    }

    @Test
    public void compareYearFieldIdentity() {
        FieldComparator comparator = new FieldComparator(StandardField.YEAR);
        BibEntry equal = new BibEntry();
        equal.setField(StandardField.YEAR, "2016");

        assertEquals(0, comparator.compare(equal, equal));
    }

    @Test
    public void compareYearFieldEquality() {
        FieldComparator comparator = new FieldComparator(StandardField.YEAR);
        BibEntry equal = new BibEntry();
        equal.setField(StandardField.YEAR, "2016");
        BibEntry equal2 = new BibEntry();
        equal2.setField(StandardField.YEAR, "2016");

        assertEquals(0, comparator.compare(equal, equal2));
    }

    @Test
    public void compareYearFieldBiggerAscending() {
        FieldComparator comparator = new FieldComparator(StandardField.YEAR);
        BibEntry smaller = new BibEntry();
        smaller.setField(StandardField.YEAR, "2000");
        BibEntry bigger = new BibEntry();
        bigger.setField(StandardField.YEAR, "2016");

        assertEquals(1, comparator.compare(bigger, smaller));
    }

    @Test
    public void compareYearFieldBiggerDescending() {
        FieldComparator comparator = new FieldComparator(new OrFields(StandardField.YEAR), true);
        BibEntry smaller = new BibEntry();
        smaller.setField(StandardField.YEAR, "2016");
        BibEntry bigger = new BibEntry();
        bigger.setField(StandardField.YEAR, "2000");

        assertEquals(1, comparator.compare(bigger, smaller));
    }

    @Test
    public void compareTypeFieldIdentity() {
        FieldComparator comparator = new FieldComparator(InternalField.TYPE_HEADER);
        BibEntry equal = new BibEntry(StandardEntryType.Article);

        assertEquals(0, comparator.compare(equal, equal));
    }

    @Test
    public void compareTypeFieldEquality() {
        FieldComparator comparator = new FieldComparator(InternalField.TYPE_HEADER);
        BibEntry equal = new BibEntry(StandardEntryType.Article);
        equal.setId("1");
        BibEntry equal2 = new BibEntry(StandardEntryType.Article);
        equal2.setId("1");

        assertEquals(0, comparator.compare(equal, equal2));
    }

    @Test
    public void compareTypeFieldBiggerAscending() {
        FieldComparator comparator = new FieldComparator(InternalField.TYPE_HEADER);
        BibEntry smaller = new BibEntry(StandardEntryType.Article);
        BibEntry bigger = new BibEntry(StandardEntryType.Book);

        assertEquals(1, comparator.compare(bigger, smaller));
    }

    @Test
    public void compareTypeFieldBiggerDescending() {
        FieldComparator comparator = new FieldComparator(new OrFields(InternalField.TYPE_HEADER), true);
        BibEntry bigger = new BibEntry(StandardEntryType.Article);
        BibEntry smaller = new BibEntry(StandardEntryType.Book);

        assertEquals(1, comparator.compare(bigger, smaller));
    }

    @Test
    public void compareStringFieldsIdentity() {
        FieldComparator comparator = new FieldComparator(StandardField.TITLE);
        BibEntry equal = new BibEntry();
        equal.setField(StandardField.TITLE, "title");

        assertEquals(0, comparator.compare(equal, equal));
    }

    @Test
    public void compareStringFieldsEquality() {
        FieldComparator comparator = new FieldComparator(StandardField.TITLE);
        BibEntry equal = new BibEntry();
        equal.setField(StandardField.TITLE, "title");
        BibEntry equal2 = new BibEntry();
        equal2.setField(StandardField.TITLE, "title");

        assertEquals(0, comparator.compare(equal, equal2));
    }

    @Test
    public void compareStringFieldsBiggerAscending() {
        FieldComparator comparator = new FieldComparator(StandardField.TITLE);
        BibEntry bigger = new BibEntry();
        bigger.setField(StandardField.TITLE, "b");
        BibEntry smaller = new BibEntry();
        smaller.setField(StandardField.TITLE, "a");

        assertEquals(1, comparator.compare(bigger, smaller));
    }

    @Test
    public void compareStringFieldsBiggerDescending() {
        FieldComparator comparator = new FieldComparator(new OrFields(StandardField.TITLE), true);
        BibEntry bigger = new BibEntry();
        bigger.setField(StandardField.TITLE, "a");
        BibEntry smaller = new BibEntry();
        smaller.setField(StandardField.TITLE, "b");

        assertEquals(1, comparator.compare(bigger, smaller));
    }
}
