package entity;

import java.io.Serializable;

public class AkaName implements Serializable {
    private int id;
    private int person_id;
    private String name;
    private String imdb_index;
    private String name_pcode_cf;
    private String surname_pcode;
    private String md5sum;

    public AkaName() {
    }

    public AkaName(int id, int person_id, String name, String imdb_index, String name_pcode_cf, String surname_pcode, String md5sum) {
        this.id = id;
        this.person_id = person_id;
        this.name = name;
        this.imdb_index = imdb_index;
        this.name_pcode_cf = name_pcode_cf;
        this.surname_pcode = surname_pcode;
        this.md5sum = md5sum;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImdb_index() {
        return imdb_index;
    }

    public void setImdb_index(String imdb_index) {
        this.imdb_index = imdb_index;
    }

    public String getName_pcode_cf() {
        return name_pcode_cf;
    }

    public void setName_pcode_cf(String name_pcode_cf) {
        this.name_pcode_cf = name_pcode_cf;
    }

    public String getSurname_pcode() {
        return surname_pcode;
    }

    public void setSurname_pcode(String surname_pcode) {
        this.surname_pcode = surname_pcode;
    }

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }
}
