package repository;


import domain.Sheet;

import java.util.List;

/**
 * Created by claudiu on 16.10.2016.
 */
public class SheetRepository extends BaseRepository {
    @SuppressWarnings("unchecked")
    public List<Sheet> getSheets() {
        return (List<Sheet>) super.getAll();
    }
}
