package Entities;

import javax.persistence.*;


@Entity
@Table(name="config_items")
public class tbl_config_items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long config_items_id;

    private long config_sources_id;
    private long config_item_types_id;
    private long data_types_id;
    private long module_versions_id;
    private String config_item_name;
    private long min_value;
    private long max_value;
    private String default_value;
    private String config_item_description;
    private  String reference_description;
    private int column_ordinal_position;
    private boolean is_nullable;
    private boolean verified_by_expert;
    private boolean dynamic_flag;
    private boolean ignore_flag;
    private boolean is_primary_key;
    private boolean is_foreign_key;
    private boolean read_only_flag;
    private long config_item_sections_id;



    //*************************************************


    public long getConfig_item_sections_id() {
        return config_item_sections_id;
    }

    public void setConfig_item_sections_id(long config_item_sections_id) {
        this.config_item_sections_id = config_item_sections_id;
    }

    public int getColumn_ordinal_position() {
        return column_ordinal_position;
    }

    public void setColumn_ordinal_position(int column_ordinal_position) {
        this.column_ordinal_position = column_ordinal_position;
    }

    public long getData_types_id() {
        return data_types_id;
    }

    public void setData_types_id(long data_types_id) {
        this.data_types_id = data_types_id;
    }

    public long getMin_value() {
        return min_value;
    }

    public void setMin_value(long min_value) {
        this.min_value = min_value;
    }

    public long getMax_value() {
        return max_value;
    }

    public void setMax_value(long max_value) {
        this.max_value = max_value;
    }

    public String getReference_description() {
        return reference_description;
    }

    public void setReference_description(String reference_description) {
        this.reference_description = reference_description;
    }


    public boolean isIs_nullable() {
        return is_nullable;
    }

    public void setIs_nullable(boolean is_nullable) {
        this.is_nullable = is_nullable;
    }

    public boolean isDynamic_flag() {
        return dynamic_flag;
    }

    public void setDynamic_flag(boolean dynamic_flag) {
        this.dynamic_flag = dynamic_flag;
    }

    public boolean isIgnore_flag() {
        return ignore_flag;
    }

    public void setIgnore_flag(boolean ignore_flag) {
        this.ignore_flag = ignore_flag;
    }

    public boolean isIs_primary_key() {
        return is_primary_key;
    }

    public void setIs_primary_key(boolean is_primary_key) {
        this.is_primary_key = is_primary_key;
    }

    public boolean isIs_foreign_key() {
        return is_foreign_key;
    }

    public void setIs_foreign_key(boolean is_foreign_key) {
        this.is_foreign_key = is_foreign_key;
    }

    public boolean isRead_only_flag() {
        return read_only_flag;
    }

    public void setRead_only_flag(boolean read_only_flag) {
        this.read_only_flag = read_only_flag;
    }

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
