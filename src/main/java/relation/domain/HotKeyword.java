package relation.domain;

import java.sql.Timestamp;

/**
 * Created by DK on 2016-12-06.
 */
public class HotKeyword {
    private int id;
    private String keyword;
    private String image;

    private Boolean google;
    private Boolean naver;
    private Boolean daum;

    private Timestamp datetime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getGoogle() {
        return google;
    }

    public void setGoogle(Boolean google) {
        this.google = google;
    }

    public Boolean getNaver() {
        return naver;
    }

    public void setNaver(Boolean naver) {
        this.naver = naver;
    }

    public Boolean getDaum() {
        return daum;
    }

    public void setDaum(Boolean daum) {
        this.daum = daum;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"
                +"id : " + id + ", keyword : " + keyword + ", image : " + image + ", google : " + google + ", naver : " + naver + ", daum : " + daum + ", datetime : " + datetime;
    }
}
