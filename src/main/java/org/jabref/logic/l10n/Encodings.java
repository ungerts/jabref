package org.jabref.logic.l10n;

import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

public class Encodings {

    public static final Charset[] ENCODINGS;
    public static final String[] ENCODINGS_DISPLAYNAMES;
    private static List<Charset> encodingsList = Charset.availableCharsets().values().stream().distinct()
            .collect(Collectors.toList());

    private Encodings() {
    }

    static {
        ENCODINGS = encodingsList.toArray(new Charset[0]);
        ENCODINGS_DISPLAYNAMES = encodingsList.stream().map(Charset::displayName).distinct().toArray(String[]::new);
    }

    public static List<Charset> getCharsets() {
        return encodingsList;
    }

}
