package com.mdb.Animdb.model.productions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class Serie extends ProductionModel implements Production {

    private int episodes;

    public Serie(String title, String Id, String synopsis, Status status, Date releaseDate, ArrayList<Genres> geners,
                 ArrayList<Themes> themes, String author, ArrayList<String> cast, Format format, int episodes) {
        super(title, Id, synopsis, status, releaseDate, geners, themes, author, cast, format);
        this.episodes = episodes;
    }

    public Serie(Builder builder) {
        super(builder.modelTitle, builder.modelId, builder.modelSynopsis, builder.modelStatus, builder.modelReleaseDate, builder.modelGeners,
                builder.modelThemes, builder.modelAuthor, builder.modelCast, builder.modelFormat);
        this.episodes = builder.modelEpisodes;
    }

    public static class Builder {
        protected int modelEpisodes = 0;

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

        public Serie build() {
            return new Serie(this);
        }
    }

    @Override
    public String toString() {
        return "Serie{" +
                "episodes=" + episodes +
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

        JSONObject seriesJson = new JSONObject();
        seriesJson.put("title", title);
        seriesJson.put("Id", Id);
        seriesJson.put("episodes", episodes);
        seriesJson.put("synopsis", synopsis);
        seriesJson.put("status", status);
        seriesJson.put("releaseDate", releaseDate);
        seriesJson.put("geners", geners);
        seriesJson.put("themes", themes);
        seriesJson.put("author", author);
        seriesJson.put("cast", cast);
        seriesJson.put("format", format);
        seriesJson.put("rating", rating);

        return seriesJson;
    }

}
