package relation.domain.daum;

import java.util.List;

/**
 * Created by Cro on 2016-12-07.
 */
public class DaumImageChannel {
    private String result;
    private String pageCount;
    private String title;
    private String totalCount;
    private String description;

    private List<DaumImageResultItem> item;

    private String lastBuildDate;
    private String link;
    private String generator;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DaumImageResultItem> getItem() {
        return item;
    }

    public void setItem(List<DaumImageResultItem> item) {
        this.item = item;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    @Override
    public String toString() {
        return "DaumImageResult{" +
                "result='" + result + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", title='" + title + '\'' +
                ", totalCount='" + totalCount + '\'' +
                ", description='" + description + '\'' +
                ", item=" + item +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", link='" + link + '\'' +
                ", generator='" + generator + '\'' +
                '}';
    }
}
