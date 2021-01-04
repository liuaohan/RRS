package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Title implements Serializable {
    //id	title	imdb_index	kind_id	production_year	imdb_id	phonetic_code	episode_of_id	season_nr	episode_nr	series_years	md5sum
    private int id;
    private String title;
    private String imdb_index;
    private int kind_id;
    private String production_year;
    private int imdb_id;
    private String phonetic_code;
    private int episode_of_id;
    private String season_nr;
    private String episode_nr;
    private String series_years;
    private String md5sum;
}
