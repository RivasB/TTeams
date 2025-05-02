package cloud.tteams.share.core.application.query;

public class FilterPageAndSortRequest {
    private int pageNo = 0;
    private int pageSize = 10;
    private String sortType = "asc";
    private String sortBy = "id";

    public FilterPageAndSortRequest() {
    }

    public FilterPageAndSortRequest(int pageNo, int pageSize, String sortType, String sortBy) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.sortType = sortType;
        this.sortBy = sortBy;
    }

    public int pageNo() {
        return pageNo;
    }

    public int pageSize() {
        return pageSize;
    }

    public String sortType() {
        return sortType;
    }

    public String sortBy() {
        return sortBy;
    }
}
