package Entities;

import javax.persistence.*;



@Entity
@Table(name="modules")
public class tbl_modules {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long modules_id;
    private String module_name;

    //**********************************


    public long getModules_id() {
        return modules_id;
    }

    public void setModules_id(long modules_id) {
        this.modules_id = modules_id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }
}
