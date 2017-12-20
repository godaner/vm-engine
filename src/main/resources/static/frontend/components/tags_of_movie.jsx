import React from 'react';  //引入react组件
import "../scss/tags_of_movie.scss";
import InnerMessager from './inner_messager';
/*标签展示*/
var TagsOfMovie = React.createClass({
    getInitialState: function () {
        return {
            whenTagIsLoading: this.props.whenTagIsLoading,
            movieId: this.props.movieId
        };
    },
    componentDidMount: function () {
        var url = "/tag/movie/" + this.state.movieId;
        $.get(url, function (result) {
            //hide tip
            this.showTagTip();

            c(result);
            //failure
            if (fail(result.code)) {
                return;
            }


        }.bind(this));
    },
    showTagTip(msg, loop){
        this.refs.innerMessager.showMsg(msg, loop);
    },
    render: function () {
        return (
            <span>
                <InnerMessager ref="innerMessager"
                               defaultTip={this.state.whenTagIsLoading}/>
            </span>
        );
    }
});
export default TagsOfMovie;