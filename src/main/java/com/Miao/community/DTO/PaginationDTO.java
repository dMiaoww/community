package com.Miao.community.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questionDTOS;
    private boolean jumpPrevious;
    private boolean jumpFistPage;
    private boolean jumpNextPage;
    private boolean jumpLastPage;
    private Integer currentPage;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        if (totalCount % size == 0) {
            this.totalPage = totalCount / size;
        }
        else this.totalPage = totalCount / size + 1;

        this.currentPage = page;
        this.jumpPrevious = true;
        this.jumpFistPage = true;
        this.jumpNextPage = true;
        this.jumpLastPage = true;

        if (page <= 3) {
            this.jumpFistPage = false;
            for (Integer i = 1; i <= 5; i++) {
                pages.add(i);
            }
            if (page == 1) {
                this.jumpPrevious = false;
            }
        }
        else if (page >= this.totalPage - 2) {
            this.jumpLastPage = false;
            for (Integer i = this.totalPage - 4; i <= this.totalPage; i++) {
                pages.add(i);
            }
            if (page == this.totalPage) {
                this.jumpNextPage = false;
            }
        }
        else {
            for (Integer i = 1; i <= 5; i++) {
                pages.add(page - 3 + i);
            }
        }
    }
}
