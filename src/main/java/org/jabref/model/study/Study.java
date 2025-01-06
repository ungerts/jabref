package org.jabref.model.study;

import java.util.List;
import java.util.Objects;

import org.jabref.logic.crawler.StudyYamlParser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This class represents a scientific study.
 *
 * This class defines all aspects of a scientific study relevant to the application. It is a proxy for the file based study definition.
 *
 * The file is parsed using by {@link StudyYamlParser}
 */
@JsonPropertyOrder({"authors", "title", "research-questions", "queries", "databases"})
// The user might add arbitrary content to the YAML
@JsonIgnoreProperties(ignoreUnknown = true)
public class Study {
    private List<String> authors;

    private String title;

    @JsonProperty("research-questions")
    private List<String> researchQuestions;

    private List<StudyQuery> queries;

    private List<StudyDatabase> databases;

    public Study(List<String> authors, String title, List<String> researchQuestions, List<StudyQuery> queryEntries, List<StudyDatabase> databases) {
        this.authors = authors;
        this.title = title;
        this.researchQuestions = researchQuestions;
        this.queries = queryEntries;
        this.databases = databases;
    }

    /**
     * Used for Jackson deserialization
     */
    private Study() {
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<StudyQuery> getQueries() {
        return queries;
    }

    public void setQueries(List<StudyQuery> queries) {
        this.queries = queries;
    }

    public List<StudyDatabase> getDatabases() {
        return databases;
    }

    public void setDatabases(List<StudyDatabase> databases) {
        this.databases = databases;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getResearchQuestions() {
        return researchQuestions;
    }

    public void setResearchQuestions(List<String> researchQuestions) {
        this.researchQuestions = researchQuestions;
    }

    @Override
    public String toString() {
        return "Study{" +
                "authors=" + authors +
                ", studyName='" + title + '\'' +
                ", researchQuestions=" + researchQuestions +
                ", queries=" + queries +
                ", libraries=" + databases +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Study study = (Study) o;
        return Objects.equals(authors, study.authors) && Objects.equals(title, study.title) && Objects.equals(researchQuestions, study.researchQuestions) && Objects.equals(queries, study.queries) && Objects.equals(databases, study.databases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authors, title, researchQuestions, queries, databases);
    }
}

