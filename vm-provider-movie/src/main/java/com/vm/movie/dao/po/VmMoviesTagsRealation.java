package com.vm.movie.dao.po;
import com.vm.base.util.BasePo;
public class VmMoviesTagsRealation  extends BasePo {

    private Long movieId;

    private Long tagId;



    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

}