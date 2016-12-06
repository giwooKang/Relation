package relation.domain.naver;

import java.util.Date;
import java.util.List;

/**
 * Created by B318EA46 on 2016-12-06.
 */
public class NaverImageResult {
    private Date lastBuildDate;
    private int total;
    private int start;
    private int display;

    private List<NaverImageResultItem> items;

    public Date getLastBuildDate() {
        return lastBuildDate;
    }

    public int getTotal() {
        return total;
    }

    public int getStart() {
        return start;
    }

    public int getDisplay() {
        return display;
    }

    public List<NaverImageResultItem> getItems() {
        return items;
    }

    public void setLastBuildDate(Date lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public void setItems(List<NaverImageResultItem> items) {
        this.items = items;
    }
}
