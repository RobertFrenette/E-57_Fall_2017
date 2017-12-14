package edu.hes.e57.demo.form;

import java.util.List;

import edu.hes.e57.demo.domain.Auto;

public class AutoGrid {
    private int totalPages;
    private int currentPage;
    private long totalRecords;
    private List<Auto> autoData;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Auto> getAutoData() {
        return autoData;
    }

    public void setAutoData(List<Auto> autoData) {
        this.autoData = autoData;
    }
}
