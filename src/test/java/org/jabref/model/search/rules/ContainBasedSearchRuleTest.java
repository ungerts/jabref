package org.jabref.model.search.rules;

import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.StandardEntryType;
import org.jabref.model.entry.field.StandardField;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test case for ContainBasedSearchRule.
 */
public class ContainBasedSearchRuleTest {

    @Test
    public void testBasicSearchParsing() {
        BibEntry be = makeBibtexEntry();
        ContainBasedSearchRule bsCaseSensitive = new ContainBasedSearchRule(true);
        ContainBasedSearchRule bsCaseInsensitive = new ContainBasedSearchRule(false);
        RegexBasedSearchRule bsCaseSensitiveRegexp = new RegexBasedSearchRule(true);
        RegexBasedSearchRule bsCaseInsensitiveRegexp = new RegexBasedSearchRule(false);

        String query = "marine 2001 shields";

        assertFalse(bsCaseSensitive.applyRule(query, be));
        assertTrue(bsCaseInsensitive.applyRule(query, be));
        assertFalse(bsCaseSensitiveRegexp.applyRule(query, be));
        assertFalse(bsCaseInsensitiveRegexp.applyRule(query, be));

        query = "\"marine larviculture\"";

        assertFalse(bsCaseSensitive.applyRule(query, be));
        assertFalse(bsCaseInsensitive.applyRule(query, be));
        assertFalse(bsCaseSensitiveRegexp.applyRule(query, be));
        assertFalse(bsCaseInsensitiveRegexp.applyRule(query, be));

        query = "marine [A-Za-z]* larviculture";

        assertFalse(bsCaseSensitive.applyRule(query, be));
        assertFalse(bsCaseInsensitive.applyRule(query, be));
        assertFalse(bsCaseSensitiveRegexp.applyRule(query, be));
        assertTrue(bsCaseInsensitiveRegexp.applyRule(query, be));
    }

    public BibEntry makeBibtexEntry() {
        BibEntry e = new BibEntry(StandardEntryType.InCollection);
        e.setField(StandardField.TITLE, "Marine finfish larviculture in Europe");
        e.setCiteKey("shields01");
        e.setField(StandardField.YEAR, "2001");
        e.setField(StandardField.AUTHOR, "Kevin Shields");
        return e;
    }
}
