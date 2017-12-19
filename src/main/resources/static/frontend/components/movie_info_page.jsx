import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
var MovieInfoPage = React.createClass({
    getInitialState: function () {
        return {whenThereHaveNotDirector:"无导演",movieImgUrl:"",movie:{}};
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

    getMovie: function (callfun) {

        var movieId = this.props.match.params.movieId;



        //get movie info
        const url = this.props.match.url;
        // c(url);
        this.serverRequest = $.get(url, function (result) {

            if (result.code == RESPONSE_CODE_FAILURE) {
                return;
            }

            var state = this.state;

            //set movie info to state

            state.movie = result.data.movie;

            this.setState(state);

            // c(this.state)
            //callfun
            if(callfun != undefined){
                callfun()
            }
        }.bind(this));
    },

    render: function () {
        return (
            <div id="movie_info_content">
                <div className="clearfix" id="basic_info">
                    <div id="movie_img">
                        <img src={this.state.movie.imgUrl}/>
                    </div>
                    <div id="movie_text">
                        <ul id="text_ul">
                            <li id="name_li">
                                电影 : <a href="javascript:void(0);">{this.state.movie.name}</a>
                            </li>
                            <li>
                                别名 : <a href="javascript:void(0);">{this.state.movie.alias}</a>
                            </li>
                            <li>
                                上映时间 : <a href="javascript:void(0);">{this.state.movie.releaseTime}</a>
                            </li>

                            <li>
                                时长 : <a href="javascript:void(0);">{this.state.movie.movieTime}</a>
                            </li>

                            <li>
                                评分 : <a href="javascript:void(0);">{this.state.movie.score}</a>
                            </li>
                            <li>
                                主演 : <a href="javascript:void(0);">{this.state.movie.director==undefined?this.state.whenThereHaveNotDirector:this.state.movie.director.name}</a>
                            </li>
                            <li>
                                导演 : <a href="javascript:void(0);">{this.state.movie.director==undefined?this.state.whenThereHaveNotDirector:this.state.movie.director.name}</a>
                            </li>
                            <li>
                                总播放数 : <a href="javascript:void(0);">{this.state.movie.watchNum}</a>
                            </li>

                            <li id="description_li">
                                电影简介 : <a href="javascript:void(0);">{this.state.movie.description}</a>
                            </li>

                        </ul>
                    </div>

                </div>
                <div id="other_info"></div>
            </div>
        );
    }
});


export default MovieInfoPage;