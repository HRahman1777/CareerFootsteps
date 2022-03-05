package com.hasibur.CareerFootsteps.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="tag_table")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToMany
    @JoinColumn(name = "post_id")
    private List<Post> postList;

    public Tag() {
    }

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
