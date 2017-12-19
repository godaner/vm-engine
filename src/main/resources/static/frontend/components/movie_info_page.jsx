import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
var MovieInfoPage = React.createClass({
    getInitialState: function () {
        return {movieImgUrl:"",movie:{}};
    }, componentDidMount: function () {
        window.addEventListener('resize', this.onWindowResize);

        //get movie
        this.getMovie();
    },

    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize);
    },

    onWindowResize: function () {
        this.adjustUI();
    },

    adjustUI: function () {

    },

    getMovie: function () {

        c(1);
        var movieId = this.props.match.params.movieId;

        //get imgUrl
        var state = this.state;
        state.movieImgUrl = "/img/" + movieId;
        this.setState(state);

        //get movie info
        const url = this.props.match.url;
        this.serverRequest = $.get(url, function (result) {
            c(result);
            if (result.code == 10000) {
                return;
            }

            var state = this.state;

            state.movie = result.data.movie;

            this.setState(state);
            //callfun
            callfun != undefined && callfun();
        }.bind(this));
    },

    render: function () {
        return (
            <div id="movie_info_content">
                <div id="movie_basic_info">
                    <div id="movie_img">
                        <img src={this.state.movieImgUrl}/>
                    </div>
                    <div id="movie_text">

                    </div>
                </div>
            </div>
        );
    }
});


export default MovieInfoPage;