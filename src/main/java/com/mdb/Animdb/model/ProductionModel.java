package com.mdb.Animdb.model;

import com.mdb.Animdb.enums.Format;
import com.mdb.Animdb.enums.Genres;
import com.mdb.Animdb.enums.Status;
import com.mdb.Animdb.enums.Themes;

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
    protected float rating = 0;


    public ProductionModel(String title, String synopsis, Status status, Date releaseDate, ArrayList<Genres> geners,
                           ArrayList<Themes> themes, String author, ArrayList<String> cast, Format format) {
        this.title = title;
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

/*
    public ProductionModel(Builder builder){
        this.title = builder.modelTitle;
        this.synopsis = builder.modelSynopsis;
        this.status = builder.modelStatus;
        this.releaseDate = builder.modelReleaseDate;
        this.geners = builder.modelGeners;
        this.themes = builder.modelThemes;
        this.author = builder.modelAuthor;
        this.cast = builder.modelCast;
        this.format = builder.modelFormat;
    }

    public static class Builder{
        private String modelTitle = "Null";
        private String modelSynopsis = "Null";
        private Status modelStatus = Status.NotYetReleased;
        private Date modelReleaseDate = null;
        private ArrayList<Genres> modelGeners = null;
        private ArrayList<Themes> modelThemes = null;
        private String modelAuthor = "Null";
        private ArrayList<String> modelCast = null;
        private Format modelFormat = Format.TVShow;

        public Builder setModelTitle(String modelTitle) {
            this.modelTitle = modelTitle;

            return this;
        }

        public Builder setModelSynopsis(String modelSynopsis) {
            this.modelSynopsis = modelSynopsis;

            return this;

        }

        public Builder setModelStatus(Status modelStatus) {
            this.modelStatus = modelStatus;

            return this;

        }

        public Builder setModelReleaseDate(Date modelReleaseDate) {
            this.modelReleaseDate = modelReleaseDate;

            return this;

        }

        public Builder setModelGeners(ArrayList<Genres> modelGeners) {
            this.modelGeners = modelGeners;

            return this;

        }

        public Builder setModelThemes(ArrayList<Themes> modelThemes) {
            this.modelThemes = modelThemes;

            return this;

        }

        public Builder setModelAuthor(String modelAuthor) {
            this.modelAuthor = modelAuthor;

            return this;

        }

        public Builder setModelCast(ArrayList<String> modelCast) {
            this.modelCast = modelCast;

            return this;

        }

        public Builder setModelFormat(Format modelFormat) {
            this.modelFormat = modelFormat;

            return this;

        }

        public ProductionModel build() {
            return new ProductionModel(this);
        }
    }

 */

}
