package com.sberbank.sber.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dictionaries")
public class Dict {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @Column()
    @ElementCollection(targetClass=String.class)
    private List<String> list;

    Dict(){ };

    public Dict(String name, List<String> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

}
