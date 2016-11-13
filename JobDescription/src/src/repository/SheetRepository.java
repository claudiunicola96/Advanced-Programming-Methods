package repository;


import domain.Sheet;
import validator.Validator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by claudiu on 16.10.2016.
 */
public class SheetRepository extends BaseRepository<Sheet> {
    public SheetRepository(Validator<Sheet> validator) {
        super(validator);
    }

    @SuppressWarnings("unchecked")
    public List<Sheet> getSheets() {
        return super.getAll();
    }

    public List<Sheet> getSheetsAlphabetic() {
        List<Sheet> sheets = this.getSheets();

        Collections.sort(sheets, new Comparator<Sheet>() {
            @Override
            public int compare(Sheet sheet, Sheet t1) {
                return sheet.getJob().getName().compareTo(t1.getJob().getName());
            }
        });
        return sheets;
    }
}
