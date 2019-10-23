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

        if (this.currentPage == 1) {
            this.jumpPrevious = false;
            this.jumpFistPage = false;
        }
        if (this.currentPage == this.totalPage) {
            this.jumpNextPage = false;
            this.jumpLastPage = false;
        }

        if (this.currentPage <= 3) {
            for (Integer i = 1; i <= this.totalPage && i <= 5; i++) {
                pages.add(i);
            }
        }
        else if (this.currentPage >= this.totalPage - 2) {
            for (Integer i = this.totalPage - 4; i <= this.totalPage; i++) {
                if (i > 0) pages.add(i);
            }
        }
        else {
            for (Integer i = 1; i <= 5 && i <= this.totalPage; i++) {
                pages.add(this.currentPage - 3 + i);
            }
        }
    }
}
