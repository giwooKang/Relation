package relation.domain;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

/**
 * Created by Cro on 2016-12-06.
 */
public class RelationToJsonWrapper {
    private int id;
    private String keyword;
    private String relation;

    public RelationToJsonWrapper() {
    }

    public RelationToJsonWrapper(int id, String keyword, String relation) {
        this.id = id;
        this.keyword = keyword;
        this.relation = relation;
    }

    public RelationToJsonWrapper(Relation relation) {
        Gson gson = new Gson();

        this.keyword = relation.getKeyword();
        this.relation = gson.toJson(relation.getRelation());
    }

    public String getKeyword() {
        return keyword;
    }

    public String getRelation() {
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

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Relation toRelation() {
        Gson gson = new Gson();
        try{
            HashMap<String, Integer> relation = gson.fromJson(this.relation, new TypeToken<HashMap<String, Integer>>(){}.getType());
            return new Relation(this.id, this.keyword, relation);
        }catch (JsonSyntaxException e){
            return null;
        }
    }
}
