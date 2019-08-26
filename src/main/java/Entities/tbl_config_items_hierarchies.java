package Entities;

import javax.persistence.*;

@Entity
@Table(name="config_item_hierarchies")
public class tbl_config_items_hierarchies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long config_item_hierarchies_id;
    private long parent_config_items_id;
    private long child_config_items_id;

    //**************************************

    public long getConfig_item_hierarchies_id() {
        return config_item_hierarchies_id;
    }

    public void setConfig_item_hierarchies_id(long config_item_hierarchies_id) {
        this.config_item_hierarchies_id = config_item_hierarchies_id;
    }

    public long getParent_config_items_id() {
        return parent_config_items_id;
    }

    public void setParent_config_items_id(long parent_config_items_id) {
        this.parent_config_items_id = parent_config_items_id;
    }

    public long getChild_config_items_id() {
        return child_config_items_id;
    }

    public void setChild_config_items_id(long child_config_items_id) {
        this.child_config_items_id = child_config_items_id;
    }
}
