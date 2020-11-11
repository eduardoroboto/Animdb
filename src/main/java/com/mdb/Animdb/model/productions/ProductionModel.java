package com.mdb.Animdb.model.productions;

import com.mdb.Animdb.model.productions.Format;
import com.mdb.Animdb.model.productions.Genres;
import com.mdb.Animdb.model.productions.Status;
import com.mdb.Animdb.model.productions.Themes;

import java.util.ArrayList;
import java.util.Date;

public class ProductionModel {
    protected String title;
    protected String synopsis;
    protected Status status;
    protected Date releaseDate;
    protected ArrayList<Genres> geners;
    protected ArrayList<Themes> themes;
    protected String author;
    protected ArrayList<String> cast;
    protected Format format;
    protected String Id;
    protected float rating = 0;


    public ProductionModel(String title,String Id, String synopsis, Status status, Date releaseDate, ArrayList<Genres> geners,
                           ArrayList<Themes> themes, String author, ArrayList<String> cast, Format format) {
        this.title = title;
        this.Id = Id;
        this.synopsis = synopsis;
        this.status = status;
        this.releaseDate = releaseDate;
        this.geners = geners;
        this.themes = themes;
        this.author = author;
        this.cast = cast;
        this.format = format;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public String getTitle(){
        return this.title;
    }

    public String getId() {return this.Id; }

    public String getAuthor() { return this.author;}

}
