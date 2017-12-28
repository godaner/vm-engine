import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import InnerMessager from "./inner_messager";
import ActorsList from './actors_list';
import Director from "./director";
import '../scss/movies_displayer.scss';
/*电影列表展示*/
var MoviesDisplayer = React.createClass({

    getInitialState: function () {
        return {
            loadingMoviesTip: "正在加载电影列表",
            noMoviesTip:"无相关电影"
        };
    },
    noMoviesTip:function(){
        this.showMsg(this.state.noMoviesTip,false);
    },
    loadingMoviesTip:function(){
        this.showMsg(this.state.loadingMoviesTip,true);
    },
    hideMovieTip:function(){
        this.refs.innerMessager.hide();
    },
    showMsg(msg, loop){
        this.refs.innerMessager.showMsg(msg, loop);
    },
    showDefaultMsg(loop){
        this.refs.innerMessager.showDefaultMsg(loop);
    },
    render: function () {
        var movies = this.props.movies;

        //for first load
        if(isEmptyList(movies)){
            movies = [];
        }
        var movieItems = movies.map(function (item) {

            // set the location
            const location = {
                pathname: '/movie/' + item.id,
                state: {fromDashboard: true}
            }

            // history.push(location);
            // history.replace(location)
            return <li className="movie_item animated flipInX" key={item.id}>
                <div className="movie_img_div">


                    <Link to={location} className="aLink">
                        <img src={MOVIE_LOADING_IMG} data-original={item.imgUrl}/>
                    </Link>
                </div>
                <div className="movie_info_div">
                    <div>
                        <Link to={location} className="aLink movie_name_a">{item.name}</Link>

                    </div>
                    <div className="movie_actor_list_div">

                        <ActorsList actors={item.actors}/>
                    </div>


                    <div>
                        <Director director={item.director}/>
                    </div>
                    <div>
                        评分：{item.score}
                    </div>

                    <div>
                        播放：{item.watchNum}次
                    </div>
                </div>

            </li>;
        }.bind(this));

        return <ul id="movies_list_ul">
            <InnerMessager defaultTip={this.state.loadingMoviesTip} ref="innerMessager"/>
            {movieItems}
            <li className="clear"></li>
        </ul>;
    }
});
export default MoviesDisplayer;