package com.vm.dao.qo;

import com.vm.dao.validator.group.VmMoviesGroups;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
@ApiModel(value = "电影查询条件")
public class VmMoviesQueryBean {
    private String keyword;

    @ApiModelProperty(value = "标签id数组")
    @NotEmpty(message = "{VmMoviesQueryBean.tagIds.NotEmpty}", groups = VmMoviesGroups.GetAboutTagsMoviesGroup.class)
    private List<Long> tagIds;

    @ApiModelProperty(value = "电影人id数组")
    @NotEmpty(message = "{VmMoviesQueryBean.filmmakerIds.NotEmpty}", groups = VmMoviesGroups.GetAboutFilmmakersMoviesGroup.class)
    private List<Long> filmmakerIds;

    @ApiModelProperty(value = "获取的图片宽度")
    private String imgWidth;

    @ApiModelProperty(value = "不查询的电影人id")
    private Long excludeMovieId;

    /**
     * 非前台数据
     */
    private Integer tagIdsLength;


    public Long getExcludeMovieId() {
        return excludeMovieId;
    }

    public void setExcludeMovieId(Long excludeMovieId) {
        this.excludeMovieId = excludeMovieId;
    }

    public List<Long> getFilmmakerIds() {
        return filmmakerIds;
    }

    public void setFilmmakerIds(List<Long> filmmakerIds) {
        this.filmmakerIds = filmmakerIds;
    }

    public Integer getTagIdsLength() {
        return tagIdsLength;
    }

    public void setTagIdsLength(Integer tagIdsLength) {
        this.tagIdsLength = tagIdsLength;
    }

    public String getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(String imgWidth) {
        this.imgWidth = imgWidth;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    @Override
    public String toString() {
        return "VmMoviesQueryBean{" +
                "keyword='" + keyword + '\'' +
                ", tagIds=" + tagIds +
                ", imgWidth='" + imgWidth + '\'' +
                '}';
    }
}
