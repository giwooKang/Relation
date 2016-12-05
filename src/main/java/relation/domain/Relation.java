package relation.domain;

import java.util.HashMap;

/**
 * Created by Cro on 2016-12-06.
 */
public class Relation {
    private int id;
    private String keyword;
    private HashMap<String, Integer> relation;

    public Relation() {
    }

    public Relation(int id, String keyword, HashMap<String, Integer> relation) {
        this.id = id;
        this.keyword = keyword;
        this.relation = relation;
    }

    public Relation(String keyword, HashMap<String, Integer> relation) {
        this.id = 0;
        this.keyword = keyword;
        this.relation = relation;
    }

    public String getKeyword() {
        return keyword;
    }

    public HashMap<String, Integer> getRelation() {
        return relation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setRelation(HashMap<String, Integer> relation) {
        this.relation = relation;
    }
}
