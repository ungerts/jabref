package org.jabref.gui.util.comparator;

import java.util.Comparator;
import java.util.Optional;

import org.jabref.gui.specialfields.SpecialFieldValueViewModel;

public class ReadStatusFieldComparator implements Comparator<Optional<SpecialFieldValueViewModel>> {

    @Override
    public int compare(Optional<SpecialFieldValueViewModel> val1, Optional<SpecialFieldValueViewModel> val2) {
        if (val1.isPresent()) {
            return val2.map(specialFieldValueViewModel -> val1.get().getValue().compareTo(specialFieldValueViewModel.getValue())).orElse(-1);
        } else {
            if (val2.isPresent()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
