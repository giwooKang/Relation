package relation.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Cro on 2016-12-06.
 */
public class Relation {
    private int id;
    private String keyword;
    private Timestamp date;
    private HashMap<String, Integer> relation;

    public Relation() {
    }

    public Relation(int id, String keyword, Timestamp date, HashMap<String, Integer> relation) {
        this.id = id;
        this.keyword = keyword;
        this.date = date;
        this.relation = relation;
    }

    public Relation(String keyword, Timestamp date, HashMap<String, Integer> relation) {
        this.keyword = keyword;
        this.date = date;
        this.relation = relation;
    }

    public int getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public Timestamp getDate() {
        return date;
    }

    public HashMap<String, Integer> getRelation() {
        return relation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setRelation(HashMap<String, Integer> relation) {
        this.relation = relation;
    }
}
