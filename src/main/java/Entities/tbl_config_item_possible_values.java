package Entities;


import javax.persistence.*;
@Entity
@Table(name="config_item_possible_values")
public class tbl_config_item_possible_values {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long config_item_possible_values_id;
    private   long config_items_id;
    private   String config_item_possible_value;
    private   String config_item_possible_value_description;

    //***************************************************************


    public long getConfig_item_possible_values_id() {
        return config_item_possible_values_id;
    }

    public void setConfig_item_possible_values_id(long config_item_possible_values_id) {
        this.config_item_possible_values_id = config_item_possible_values_id;
    }

    public long getConfig_items_id() {
        return config_items_id;
    }

    public void setConfig_items_id(long config_items_id) {
        this.config_items_id = config_items_id;
    }

    public String getConfig_item_possible_value() {
        return config_item_possible_value;
    }

    public void setConfig_item_possible_value(String config_item_possible_value) {
        this.config_item_possible_value = config_item_possible_value;
    }

    public String getConfig_item_possible_value_description() {
        return config_item_possible_value_description;
    }

    public void setConfig_item_possible_value_description(String config_item_possible_value_description) {
        this.config_item_possible_value_description = config_item_possible_value_description;
    }
}
