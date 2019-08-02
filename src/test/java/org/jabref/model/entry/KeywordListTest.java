package org.jabref.model.entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeywordListTest {

    private KeywordList keywords;

    @BeforeEach
    public void setUp() {
        keywords = new KeywordList();
        keywords.add("keywordOne");
        keywords.add("keywordTwo");
    }

    @Test
    public void parseEmptyStringReturnsEmptyList() {
        assertEquals(new KeywordList(), KeywordList.parse("", ','));
    }

    @Test
    public void parseOneWordReturnsOneKeyword() {
        assertEquals(new KeywordList("keywordOne"),
                KeywordList.parse("keywordOne", ','));
    }

    @Test
    public void parseTwoWordReturnsTwoKeywords() {
        assertEquals(new KeywordList("keywordOne", "keywordTwo"),
                KeywordList.parse("keywordOne, keywordTwo", ','));
    }

    @Test
    public void parseTwoWordReturnsTwoKeywordsWithoutSpace() {
        assertEquals(new KeywordList("keywordOne", "keywordTwo"),
                KeywordList.parse("keywordOne,keywordTwo", ','));
    }

    @Test
    public void parseTwoWordReturnsTwoKeywordsWithDifferentDelimiter() {
        assertEquals(new KeywordList("keywordOne", "keywordTwo"),
                KeywordList.parse("keywordOne| keywordTwo", '|'));
    }

    @Test
    public void parseWordsWithWhitespaceReturnsOneKeyword() {
        assertEquals(new KeywordList("keyword and one"),
                KeywordList.parse("keyword and one", ','));
    }

    @Test
    public void parseWordsWithWhitespaceAndCommaReturnsTwoKeyword() {
        assertEquals(new KeywordList("keyword and one", "and two"),
                KeywordList.parse("keyword and one, and two", ','));
    }

    @Test
    public void parseIgnoresDuplicates() {
        assertEquals(new KeywordList("keywordOne", "keywordTwo"),
                KeywordList.parse("keywordOne, keywordTwo, keywordOne", ','));
    }

    @Test
    public void parseWordsWithBracketsReturnsOneKeyword() {
        assertEquals(new KeywordList("[a] keyword"), KeywordList.parse("[a] keyword", ','));
    }

    @Test
    public void asStringAddsSpaceAfterDelimiter() {
        assertEquals("keywordOne, keywordTwo", keywords.getAsString(','));
    }

    @Test
    public void parseHierarchicalChain() {
        Keyword expected = Keyword.of("Parent", "Node", "Child");

        assertEquals(new KeywordList(expected), KeywordList.parse("Parent > Node > Child", ',', '>'));
    }

    @Test
    public void parseTwoHierarchicalChains() {
        Keyword expectedOne = Keyword.of("Parent1", "Node1", "Child1");
        Keyword expectedTwo = Keyword.of("Parent2", "Node2", "Child2");

        assertEquals(new KeywordList(expectedOne, expectedTwo),
                KeywordList.parse("Parent1 > Node1 > Child1, Parent2 > Node2 > Child2", ',', '>'));
    }
}
