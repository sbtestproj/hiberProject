package Entities;

import javax.persistence.*;

@Entity
@Table(name="config_item_types")
public class tbl_config_item_types {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long config_item_types_id;

    private String config_item_type_name;


    //*************************************************
//    public long getConfig_item_type_id() {
//        return config_item_types_id;
//    }

//    public void setConfig_item_type_id(long config_item_type_id) {
//        this.config_item_types_id = config_item_type_id;
//    }

    public long getConfig_item_types_id() {
        return config_item_types_id;
    }

    public void setConfig_item_types_id(long config_item_types_id) {
        this.config_item_types_id = config_item_types_id;
    }

    public String getConfig_item_type_name() {
        return config_item_type_name;
    }

    public void setConfig_item_type_name(String config_item_type_name) {
        this.config_item_type_name = config_item_type_name;
    }
}
