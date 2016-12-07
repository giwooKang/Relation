package relation.domain;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Cro on 2016-12-06.
 */
public class RelationToJsonWrapper {
    private int id;
    private String keyword;
    private Timestamp date;
    private String relation;

    public RelationToJsonWrapper() {
    }

    public RelationToJsonWrapper(Relation relation) {
        Gson gson = new Gson();

        this.id = relation.getId();
        this.keyword = relation.getKeyword();
        this.date = relation.getDate();
        this.relation = gson.toJson(relation.getRelation());
    }

    public Relation toRelation() {
        Gson gson = new Gson();
        try{
            HashMap<String, Integer> rel = gson.fromJson(this.relation, new TypeToken<HashMap<String, Integer>>(){}.getType());
            return new Relation(this.id, this.keyword, this.date, rel);
        }catch (JsonSyntaxException e){
            return null;
        }
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

    public String getRelation() {
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

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
