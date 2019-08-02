package org.jabref.logic.integrity;

import java.util.Optional;

import org.jabref.model.database.BibDatabaseContext;
import org.jabref.model.database.BibDatabaseMode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonNamesCheckerTest {

    private PersonNamesChecker checker;

    @BeforeEach
    public void setUp() {
        BibDatabaseContext databaseContext = new BibDatabaseContext();
        databaseContext.setMode(BibDatabaseMode.BIBTEX);
        checker = new PersonNamesChecker(databaseContext);
    }

    @Test
    public void validNameFirstnameAuthor() {
        assertEquals(Optional.empty(), checker.checkValue("Kolb, Stefan"));
    }

    @Test
    public void validNameFirstnameAuthors() {
        assertEquals(Optional.empty(), checker.checkValue("Kolb, Stefan and Harrer, Simon"));
    }

    @Test
    public void validFirstnameNameAuthor() {
        assertEquals(Optional.empty(), checker.checkValue("Stefan Kolb"));
    }

    @Test
    public void validFirstnameNameAuthors() {
        assertEquals(Optional.empty(), checker.checkValue("Stefan Kolb and Simon Harrer"));
    }

    @Test
    public void complainAboutPersonStringWithTwoManyCommas() {
        assertEquals(Optional.of("Names are not in the standard BibTeX format."),
                checker.checkValue("Test1, Test2, Test3, Test4, Test5, Test6"));
    }

    @Test
    public void doNotComplainAboutSecondNameInFront() {
        assertEquals(Optional.empty(), checker.checkValue("M. J. Gotay"));
    }

    @Test
    public void validCorporateNameInBrackets() {
        assertEquals(Optional.empty(), checker.checkValue("{JabRef}"));
    }

    @Test
    public void validCorporateNameAndPerson() {
        assertEquals(Optional.empty(), checker.checkValue("{JabRef} and Stefan Kolb"));
        assertEquals(Optional.empty(), checker.checkValue("{JabRef} and Kolb, Stefan"));
    }
}
