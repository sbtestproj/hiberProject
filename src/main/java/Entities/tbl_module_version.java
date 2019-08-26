package Entities;

import javax.persistence.*;

@Entity
@Table(name="module_versions")
public class tbl_module_version {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long module_versions_id;

    private  long modules_id;

    private String version_number;

    //*********************************************


    public long getModule_versions_id() {
        return module_versions_id;
    }

    public void setModule_versions_id(long module_versions_id) {
        this.module_versions_id = module_versions_id;
    }

    public long getModules_id() {
        return modules_id;
    }

    public void setModules_id(long modules_id) {
        this.modules_id = modules_id;
    }

    public String getVersion_number() {
        return version_number;
    }

    public void setVersion_number(String version_number) {
        this.version_number = version_number;
    }
}
