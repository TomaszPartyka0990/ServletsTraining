package pl.sda.partyka.last.dao;

import pl.sda.partyka.last.domain.FemaleNames;

import java.util.List;

public interface FemaleNamesDao {
    List<FemaleNames> findAll();

    int createOrUpdate(FemaleNames femaleName);
}
