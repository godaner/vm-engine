
import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
var MovieInfoPage = React.createClass({
    render:function(){
        c(this.props.getNowPageProps());
        return (
            <div id="movie_info_content">
                666
            </div>
        );
    }
});
export default MovieInfoPage;