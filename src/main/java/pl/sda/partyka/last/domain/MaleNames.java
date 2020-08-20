package pl.sda.partyka.last.domain;

import javax.persistence.*;

@Entity
@Table (name = "male_names")
public class MaleNames {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Integer id;
    @Column (name = "name")
    private String name;

    public MaleNames(){
    }
    public MaleNames(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaleNames maleNames = (MaleNames) o;

        if (!id.equals(maleNames.id)) return false;
        return name.equals(maleNames.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + '\'';
    }
}
