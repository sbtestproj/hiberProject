package Entities;

import javax.persistence.*;



@Entity
@Table(name = "modules")
public class tbl_modules {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long modules_id;
    private String module_name;
    private String module_description;
    private String responsible_person;

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

    public String getModule_description() {
        return module_description;
    }

    public void setModule_description(String module_description) {
        this.module_description = module_description;
    }

    public String getResponsible_person() {
        return responsible_person;
    }

    public void setResponsible_person(String responsible_person) {
        this.responsible_person = responsible_person;
    }



}
