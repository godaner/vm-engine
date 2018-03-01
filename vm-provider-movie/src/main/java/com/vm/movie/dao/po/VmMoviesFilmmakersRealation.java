package com.vm.movie.dao.po;
import com.vm.base.util.BasePo;
public class VmMoviesFilmmakersRealation {

    private Long movieId;

    private Long filmmakerId;


    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getFilmmakerId() {
        return filmmakerId;
    }

    public void setFilmmakerId(Long filmmakerId) {
        this.filmmakerId = filmmakerId;
    }

}