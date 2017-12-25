import React from 'react';  //引入react组件
import "../scss/tags_of_movie.scss";
import InnerMessager from './inner_messager';
/*标签展示*/
var TagsOfMovie = React.createClass({
    getInitialState: function () {
        return {
            whenTagIsLoading: this.props.whenTagIsLoading,
            movieId: this.props.movieId,
            tags: []
        };
    },
    componentDidMount: function () {

        var url = "/movie/tag" + this.state.movieId;
        $.get(url, function (result) {
            //hide tip
            this.showTagTip();

            // c(result);
            //failure
            if (fail(result.code)) {
                return;
            }

            var state = this.state;
            state.tags = result.data.list;

            this.setState(state);

        }.bind(this));
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