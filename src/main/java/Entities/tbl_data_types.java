package Entities;

import javax.persistence.*;

@Entity
@Table(name="data_types")
public class tbl_data_types {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long data_types_id;

    private String data_type_name;


    //*************************************************

    public long getData_types_id() {
        return data_types_id;
    }

    public void setData_types_id(long data_types_id) {
        this.data_types_id = data_types_id;
    }
    public String getData_types_name() {
        return data_type_name;
    }

    public void setData_types_name(String data_types_name) {
        this.data_type_name = data_types_name;
    }
}
