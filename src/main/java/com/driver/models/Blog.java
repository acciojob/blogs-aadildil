package com.driver.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//spring.datasource.password=Kan@2911

@Entity
@Table(name = "Blog")
public class Blog{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
   private String title;

    @Column
    private String content;

    @CreationTimestamp
    @Column
    private Date pubDate;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("BlogList")
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("blog")
    private List<Image> ImageList =new ArrayList<>();


    public Blog(int id, String title, String content, Date pubDate, User user, List<Image> ImageList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.user = user;
        this.ImageList = ImageList;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return ImageList;
    }

    public void setImageList(List<Image> imageList) {
        this.ImageList = imageList;
    }
}
