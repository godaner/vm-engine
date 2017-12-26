import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import InnerMessager from "./inner_messager";
import '../scss/movies_displayer.scss';
/*电影展示*/
var MoviesDisplayer = React.createClass({

    showMsg(msg, loop){
        this.refs.innerMessager.showMsg(msg, loop);
    },
    render: function () {

        var movieItems = this.props.movies.map(function (item) {

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
                        <img src={LOADING_IMG} data-original={item.imgUrl}/>
                    </Link>
                </div>
                <div className="movie_info_div">
                    <div>
                        <Link to={location} className="aLink movie_name_a">{item.name}</Link>

                    </div>
                    <div className="movie_actor_list_div">

                        <ActorsList whenThereHaveNotActor={this.props.whenThereHaveNotActor}
                                    actors={item.actors}/>
                    </div>


                    <div>
                        <Director whenThereHaveNotDirector={this.props.whenThereHaveNotDirector}
                                  director={item.director}/>
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
            <InnerMessager defaultTip={this.props.defaultMovieTip} ref="innerMessager"/>
            {movieItems}
            <li className="clear"></li>
        </ul>;
    }
});
export default MoviesDisplayer;