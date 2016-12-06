package relation.domain.naver;

/**
 * Created by B318EA46 on 2016-12-06.
 */
public class NaverImageResultItem {
    private String title;
    private String link;
    private String thumbnail;
    private String sizeheight;
    private String sizewidth;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getSizeheight() {
        return sizeheight;
    }

    public String getSizewidth() {
        return sizewidth;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setSizeheight(String sizeheight) {
        this.sizeheight = sizeheight;
    }

    public void setSizewidth(String sizewidth) {
        this.sizewidth = sizewidth;
    }
}
