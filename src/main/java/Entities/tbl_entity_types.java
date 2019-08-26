package Entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name = "entity_types")
public class tbl_entity_types {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long entity_types_id;


    private String entity_type_name;



    /*
    @OneToMany  ( mappedBy = "entity_types_id" ) //по какому полю мапим
    private List<Entities.tbl_entities> entity_types_id;
  */
    //**********************************************************


    public String getC_entity_type_name() {
        return entity_type_name;
    }

    public void setC_entity_type_name(String c_entity_type_name) {
        this.entity_type_name = c_entity_type_name;
    }

    public long getC_entity_type_id() {
        return entity_types_id;
    }

    public void setC_entity_type_id(long c_entity_type_id) {
        this.entity_types_id = c_entity_type_id;
    }
}
