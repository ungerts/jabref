package org.jabref.logic.importer;

import java.net.URL;

import org.jabref.logic.importer.fetcher.TrustLevel;

public record FetcherResult(TrustLevel trust, URL source) {
}
