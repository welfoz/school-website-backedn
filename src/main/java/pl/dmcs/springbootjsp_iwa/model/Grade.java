package pl.dmcs.springbootjsp_iwa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
public class Grade {

    @Id
    @GeneratedValue
    private long id;

    private Number mark;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Number getMark() {
        return mark;
    }

    public void setMark(Number mark) {
        this.mark = mark;
    }
}


