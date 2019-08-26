package Entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table( name ="entities")
public class tbl_entities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long entities_id;

    private String entity_name;

    private long entity_types_id;


    //************************************

    public long getC_entities_id() {
        return entities_id;
    }

    public void setC_entities_id(long c_entities_id) {
        this.entities_id = c_entities_id;
    }

    public String getC_entity_name() {
        return entity_name;
    }

    public void setC_entity_name(String c_entity_name) {
        this.entity_name = c_entity_name;
    }

    public long getC_entity_types_id() {
        return entity_types_id;
    }

    public void setC_entity_types_id(long c_entity_types_id) {
        this.entity_types_id = c_entity_types_id;
    }
}
