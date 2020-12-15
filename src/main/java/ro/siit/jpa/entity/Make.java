package ro.siit.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "makes")
public class Make {

    @Id
    private UUID id;

    private String name;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy="make")
    private Set<Model> models;

    public Set<Model> getModels() {
        return models;
    }

}
