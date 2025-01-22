package org.jabref.model.openoffice.rangesort;

import java.util.List;

/**
 * Used in reporting range overlaps.
 */
public record RangeOverlap<V>(RangeOverlapKind kind, List<V> valuesForOverlappingRanges) {
}
