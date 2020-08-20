package pl.sda.partyka.last.dao;

import pl.sda.partyka.last.domain.MaleNames;

import java.util.List;

public interface MaleNamesDao {
    List<MaleNames> findAll();

    int createOrUpdate(MaleNames maleName);
}
