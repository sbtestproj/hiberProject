package Entities;

import javax.persistence.*;


@Entity
@Table(name="config_items")
public class tbl_config_items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long config_items_id;
    private String config_item_name;
    private boolean verified_by_expert;

    private long config_sources_id;
    private long config_item_types_id;

    private String config_item_description;
    private long module_versions_id;
    private String default_value;


    //*************************************************


    public long getConfig_items_id() {
        return config_items_id;
    }

    public void setConfig_items_id(long config_items_id) {
        this.config_items_id = config_items_id;
    }

    public String getConfig_item_name() {
        return config_item_name;
    }

    public void setConfig_item_name(String config_item_name) {
        this.config_item_name = config_item_name;
    }

    public boolean isVerified_by_expert() {
        return verified_by_expert;
    }

    public void setVerified_by_expert(boolean verified_by_expert) {
        this.verified_by_expert = verified_by_expert;
    }

    public long getConfig_sources_id() {
        return config_sources_id;
    }

    public void setConfig_sources_id(long config_sources_id) {
        this.config_sources_id = config_sources_id;
    }

    public long getConfig_item_types_id() {
        return config_item_types_id;
    }

    public void setConfig_item_types_id(long config_item_types_id) {
        this.config_item_types_id = config_item_types_id;
    }

    public String getConfig_item_description() {
        return config_item_description;
    }

    public void setConfig_item_description(String config_item_description) {
        this.config_item_description = config_item_description;
    }

    public long getModule_versions_id() {
        return module_versions_id;
    }

    public void setModule_versions_id(long module_versions_id) {
        this.module_versions_id = module_versions_id;
    }

    public String getDefault_value() {
        return default_value;
    }

    public void setDefault_value(String default_value) {
        this.default_value = default_value;
    }
}
