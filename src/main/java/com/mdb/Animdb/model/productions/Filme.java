package com.mdb.Animdb.model.productions;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mdb.Animdb.enums.Format;
import com.mdb.Animdb.enums.Genres;
import com.mdb.Animdb.enums.Status;
import com.mdb.Animdb.enums.Themes;
import com.mdb.Animdb.interfaces.Production;
import com.mdb.Animdb.model.ProductionModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class Filme extends ProductionModel implements Production {
    private int duration;


    public Filme(String title, String synopsis, Status status, Date releaseDate, ArrayList<Genres> geners,
                 ArrayList<Themes> themes, String author, ArrayList<String> cast, Format format, int duration) {
        super(title, synopsis, status, releaseDate, geners, themes, author, cast, format);
        this.duration = duration;
    }

    public Filme(Builder builder){
        super(builder.modelTitle, builder.modelSynopsis, builder.modelStatus, builder.modelReleaseDate, builder.modelGeners,
                builder.modelThemes, builder.modelAuthor, builder.modelCast, builder.modelFormat);
        this.duration = builder.modelDuration;
    }

    public static class Builder{
        protected int modelDuration = 0;

        protected String modelTitle = "Null";
        protected String modelSynopsis = "Null";
        protected Status modelStatus = Status.NotYetReleased;
        protected Date modelReleaseDate = null;
        protected ArrayList<Genres> modelGeners = null;
        protected ArrayList<Themes> modelThemes = null;
        protected String modelAuthor = "Null";
        protected ArrayList<String> modelCast = null;
        protected Format modelFormat = Format.Film;

        public Builder setModelDuration(int modelDuration) {
            this.modelDuration = modelDuration;
            return this;
        }

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

        public Filme build(){
            return new Filme(this);
        }
    }

    @Override
    public String toString() {
        return "Filme{" +
                "duration=" + duration +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", status=" + status +
                ", releaseDate=" + releaseDate +
                ", geners=" + geners +
                ", themes=" + themes +
                ", author='" + author + '\'' +
                ", cast=" + cast +
                ", format=" + format +
                ", rating=" + rating +
                '}';
    }

    @Override
    public JSONObject getAll()  throws JSONException {
        JSONObject filmeJson = new JSONObject();
        filmeJson.put("title",title);
        filmeJson.put("duration",duration);
        filmeJson.put("synopsis",synopsis);
        filmeJson.put("status",status);
        filmeJson.put("releaseDate",releaseDate);
        filmeJson.put("geners",geners);
        filmeJson.put("themes",themes);
        filmeJson.put("author",author);
        filmeJson.put("cast",cast);
        filmeJson.put("format",format) ;
        filmeJson.put("rating",rating);


        return filmeJson;
    }


}
