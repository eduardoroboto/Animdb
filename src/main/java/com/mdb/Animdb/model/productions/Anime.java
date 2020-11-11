package com.mdb.Animdb.model.productions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class Anime extends ProductionModel implements Production {
    private int episodes;
    private Demography demography;


    public Anime(String title,String Id, String synopsis, Status status, Date releaseDate, ArrayList<Genres> geners,
                 ArrayList<Themes> themes, String author, ArrayList<String> cast, Format format, int episodes, Demography demography) {
        super(title, Id, synopsis, status, releaseDate, geners, themes, author, cast, format);
        this.episodes = episodes;
        this.demography = demography;
    }


    public Anime(Builder builder){
        super(builder.modelTitle,builder.modelId, builder.modelSynopsis, builder.modelStatus, builder.modelReleaseDate, builder.modelGeners,
                builder.modelThemes, builder.modelAuthor, builder.modelCast, builder.modelFormat);
        this.episodes = builder.modelEpisodes;
        this.demography = builder.modelDemography;
    }

    public static class Builder{
        protected int modelEpisodes = 0;
        protected Demography modelDemography = Demography.Shounen;

        protected String modelTitle = "Null";
        protected String modelId = "Null";
        protected String modelSynopsis = "Null";
        protected Status modelStatus = Status.NotYetReleased;
        protected Date modelReleaseDate = null;
        protected ArrayList<Genres> modelGeners = null;
        protected ArrayList<Themes> modelThemes = null;
        protected String modelAuthor = "Null";
        protected ArrayList<String> modelCast = null;
        protected Format modelFormat = Format.TVShow;

        public Builder setModelEpisodes(int modelEpisodes) {
            this.modelEpisodes = modelEpisodes;
            return this;
        }

        public Builder setModelDemography(Demography modelDemography) {
            this.modelDemography = modelDemography;
            return this;
        }

        public Builder setModelTitle(String modelTitle) {
            this.modelTitle = modelTitle;
            return this;
        }

        public Builder setModelId(String modelId) {
            this.modelId = modelId;
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

        public Anime build(){
            return new Anime(this);
        }
    }

    @Override
    public String toString() {
        return "Anime{" +
                "episodes=" + episodes +
                ", demography=" + demography +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", status=" + status +
                ", releaseDate=" + releaseDate +
                ", geners=" + geners +
                ", themes=" + themes +
                ", author='" + author + '\'' +
                ", cast=" + cast +
                ", format=" + format +
                ", Id='" + Id + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public JSONObject getAll() throws JSONException {

        JSONObject animeJson = new JSONObject();
        animeJson.put("title",title);
        animeJson.put("Id",Id);
        animeJson.put("episodes",episodes);
        animeJson.put("demography",demography);
        animeJson.put("synopsis",synopsis);
        animeJson.put("status",status);
        animeJson.put("releaseDate",releaseDate);
        animeJson.put("geners",geners);
        animeJson.put("themes",themes);
        animeJson.put("author",author);
        animeJson.put("cast",cast);
        animeJson.put("format",format);
        animeJson.put("rating",rating);

        return animeJson;


    }


}
