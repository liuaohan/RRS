package entity;

import java.io.Serializable;

public class AkaTitle implements Serializable {
    private int id;
    private int movie_id;
    private String title;
    private String imdb_index;
    private int kind_id;
    private String production_year;
    private String phonetic_code;
    private String episode_of_id;
    private String season_nr;
    private String episode_nr;
    private String note;
    private String md5sum;

    public AkaTitle() {
    }

    public AkaTitle(int id, int movie_id, String title, String imdb_index, int kind_id, String production_year, String phonetic_code, String episode_of_id, String season_nr, String episode_nr, String note, String md5sum) {
        this.id = id;
        this.movie_id = movie_id;
        this.title = title;
        this.imdb_index = imdb_index;
        this.kind_id = kind_id;
        this.production_year = production_year;
        this.phonetic_code = phonetic_code;
        this.episode_of_id = episode_of_id;
        this.season_nr = season_nr;
        this.episode_nr = episode_nr;
        this.note = note;
        this.md5sum = md5sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdb_index() {
        return imdb_index;
    }

    public void setImdb_index(String imdb_index) {
        this.imdb_index = imdb_index;
    }

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }

    public String getProduction_year() {
        return production_year;
    }

    public void setProduction_year(String production_year) {
        this.production_year = production_year;
    }

    public String getPhonetic_code() {
        return phonetic_code;
    }

    public void setPhonetic_code(String phonetic_code) {
        this.phonetic_code = phonetic_code;
    }

    public String getEpisode_of_id() {
        return episode_of_id;
    }

    public void setEpisode_of_id(String episode_of_id) {
        this.episode_of_id = episode_of_id;
    }

    public String getSeason_nr() {
        return season_nr;
    }

    public void setSeason_nr(String season_nr) {
        this.season_nr = season_nr;
    }

    public String getEpisode_nr() {
        return episode_nr;
    }

    public void setEpisode_nr(String episode_nr) {
        this.episode_nr = episode_nr;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }
}
