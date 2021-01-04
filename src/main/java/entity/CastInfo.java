package entity;

import java.io.Serializable;

public class CastInfo implements Serializable {
    private int id;
    private int person_id;
    private int movie_id;
    private int person_role_id;
    private String note;
    private String nr_order;
    private int role_id;

    public CastInfo() {
    }

    public CastInfo(int id, int person_id, int movie_id, int person_role_id, String note, String nr_order, int role_id) {
        this.id = id;
        this.person_id = person_id;
        this.movie_id = movie_id;
        this.person_role_id = person_role_id;
        this.note = note;
        this.nr_order = nr_order;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getPerson_role_id() {
        return person_role_id;
    }

    public void setPerson_role_id(int person_role_id) {
        this.person_role_id = person_role_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNr_order() {
        return nr_order;
    }

    public void setNr_order(String nr_order) {
        this.nr_order = nr_order;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
