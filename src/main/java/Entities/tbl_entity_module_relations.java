package Entities;

import javax.persistence.*;

@Entity
@Table(name="entity_module_relations")
public class tbl_entity_module_relations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long modules_id;
    private long entities_id;
    //****************************************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getModules_id() {
        return modules_id;
    }

    public void setModules_id(long modules_id) {
        this.modules_id = modules_id;
    }

    public long getEntities_id() {
        return entities_id;
    }

    public void setEntities_id(long entities_id) {
        this.entities_id = entities_id;
    }
}
