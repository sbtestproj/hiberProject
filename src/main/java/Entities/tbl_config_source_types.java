package Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="config_source_types")
public class tbl_config_source_types {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long config_source_types_id;

    private String config_source_type_name;

    //*******************************************


    public long getConfig_source_types_id() {
        return config_source_types_id;
    }

    public void setConfig_source_types_id(long config_source_types_id) {
        this.config_source_types_id = config_source_types_id;
    }

    public String getConfig_source_type_name() {
        return config_source_type_name;
    }

    public void setConfig_source_type_name(String config_source_type_name) {
        this.config_source_type_name = config_source_type_name;
    }
}
