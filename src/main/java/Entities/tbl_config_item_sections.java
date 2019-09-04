package Entities;

import javax.persistence.*;

@Entity
@Table(name="config_item_sections")
public class tbl_config_item_sections {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long config_item_sections_id;

    private String config_item_section_name;

    private String config_item_section_description;

    //*******************************************************


    public long getConfig_item_sections_id() {
        return config_item_sections_id;
    }

    public void setConfig_item_sections_id(long config_item_sections_id) {
        this.config_item_sections_id = config_item_sections_id;
    }

    public String getConfig_item_section_name() {
        return config_item_section_name;
    }

    public void setConfig_item_section_name(String config_item_section_name) {
        this.config_item_section_name = config_item_section_name;
    }

    public String getConfig_item_section_description() {
        return config_item_section_description;
    }

    public void setConfig_item_section_description(String config_item_section_description) {
        this.config_item_section_description = config_item_section_description;
    }
}
