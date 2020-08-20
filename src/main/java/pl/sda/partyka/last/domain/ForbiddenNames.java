package pl.sda.partyka.last.domain;

import javax.persistence.*;

@Entity
@Table(name = "forbidden_names")
public class ForbiddenNames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "name")
    private String name;

    public ForbiddenNames(){

    }
    public ForbiddenNames(Integer id, String name) {
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

        ForbiddenNames that = (ForbiddenNames) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ForbiddenNames{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
