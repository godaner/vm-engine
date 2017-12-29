import React from 'react';  //引入react组件
import "../scss/tags_of_movie.scss";
import InnerMessager from './inner_messager';
/*标签展示*/
var TagsOfMovie = React.createClass({
    getInitialState: function () {
        return {
            whenTagIsLoading: "正在加载标签信息",
            whenThereHaveNotTag: "无相关标签信息",
            movieId: this.props.movieId,
            tags: []
        };
    },
    componentDidMount: function () {

        this.getTagsOfMovie();

    },
    getTagsOfMovie: function (callfun) {
        var url = "/movie/tag/" + this.state.movieId;
        ajax.get({
            url: url,
            onBeforeRequest: function () {

            }.bind(this),
            onResponseStart: function () {

                //hide tip
                this.showTagTip();
            }.bind(this),
            onResponseSuccess: function (result) {
                if (isEmptyList(result.data.list)) {
                    this.showTagTip(this.state.whenThereHaveNotTag, false);

                    this.props.onLoadDataSuccess([]);

                    return;
                }


                var state = this.state;
                state.tags = result.data.list;

                this.setState(state);

                //callfun
                this.props.onLoadDataSuccess(state.tags);
            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(result.msg);
            }.bind(this),
            onResponseEnd: function () {
                //callfun
                if (callfun != undefined) {
                    callfun()
                }
            }.bind(this)
        });
    },
    showTagTip(msg, loop){
        this.refs.innerMessager.showMsg(msg, loop);
    },
    render: function () {

        //show tags
        var listTags = (tags) => {
            if (isEmptyList(tags)) {
                return;
            }
            var res = [];
            for (var i = 0; i < tags.length; i++) {
                var tag = tags[i];
                // c(tag);
                res.push(<li className="tag" key={tag.id}><a href="javascript:void(0);">{tag.name}</a></li>);
            }
            return res;
        }
        return (
            <div id="tags_of_movie">

                <InnerMessager ref="innerMessager"
                               defaultTip={this.state.whenTagIsLoading}/>
                <div id="ul_div">
                    <ul>
                        {
                            listTags(this.state.tags)
                        }
                    </ul>
                </div>
            </div>
        );
    }
});
export default TagsOfMovie;