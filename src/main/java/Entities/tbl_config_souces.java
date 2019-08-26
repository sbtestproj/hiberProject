package Entities;

import javax.persistence.*;

@Entity
@Table(name="config_sources")
public class tbl_config_souces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long config_sources_id;

    private long config_source_types_id;

    private String config_source_name;

    private  String config_source_location;

    //*************************************************


    public long getConfig_source_types_id() {
        return config_source_types_id;
    }

    public void setConfig_source_types_id(long config_source_types_id) {
        this.config_source_types_id = config_source_types_id;
    }

    public String getConfig_source_location() {
        return config_source_location;
    }

    public void setConfig_source_location(String config_source_location) {
        this.config_source_location = config_source_location;
    }

///*********************************************


    public long getConfig_sources_id() {
        return config_sources_id;
    }

    public void setConfig_sources_id(long config_sources_id) {
        this.config_sources_id = config_sources_id;
    }

    public long getConfig_source_type_id() {
        return config_source_types_id;
    }

    public void setConfig_source_type_id(long config_source_type_id) {
        this.config_source_types_id = config_source_type_id;
    }

    public String getConfig_source_name() {
        return config_source_name;
    }

    public void setConfig_source_name(String config_source_name) {
        this.config_source_name = config_source_name;
    }
}
