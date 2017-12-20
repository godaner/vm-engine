package com.vm.dao.po;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public class CustomVmMovies extends VmMovies{
    private List<VmFilmmakers> actors;
    private VmFilmmakers director;
    private List<VmTags> tags;

    public List<VmTags> getTags() {
        return tags;
    }

    public void setTags(List<VmTags> tags) {
        this.tags = tags;
    }

    public List<VmFilmmakers> getActors() {
        return actors;
    }

    public void setActors(List<VmFilmmakers> actors) {
        this.actors = actors;
    }

    public VmFilmmakers getDirector() {
        return director;
    }

    public void setDirector(VmFilmmakers director) {
        this.director = director;
    }
}
