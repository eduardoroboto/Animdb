package com.mdb.Animdb.model.productions;

import com.mdb.Animdb.model.objects.Casting;
import com.mdb.Animdb.model.objects.Tags;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "production")
@Entity
public class ProductionModel {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "status")
    private String status;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "author")
    private String author;


    @Column(name = "format")
    private String format;

    @Column(name = "rating")
    private Float rating;

    //just for movies
    @Column(name = "duration")
    private Integer duration;
    
    // animes and series
    @Column(name = "episodes")
    private Integer episodes;

    @OneToMany(mappedBy = "productionId")
    private List<Casting> casting;

    @OneToMany(mappedBy = "productionId")
    private List<Tags> tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Casting> getCasting() {
        return casting;
    }

    public void setCasting(List<Casting> casting) {
        this.casting = casting;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

}
