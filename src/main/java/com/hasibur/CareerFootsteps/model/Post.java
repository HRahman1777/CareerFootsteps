package com.hasibur.CareerFootsteps.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="post_table")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Please Enter Title!")
    private String title;

    @Lob
    private String description;
    private String picture;
    private String time;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    @ManyToMany(cascade =  CascadeType.ALL)
    @JoinTable(
            name = "Post_and_Tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns =  @JoinColumn(name = "tag_id")
    )
    private List<Tag> tagList;
}
