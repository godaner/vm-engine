
import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
var MovieInfoPage = React.createClass({
    componentDidMount: function () {
        window.addEventListener('resize', this.onWindowResize);

        // this.getMovie();
    },
    componentWillUnmount:function() {
        window.removeEventListener('resize', this.onWindowResize);
    },
    onWindowResize:function () {
        this.adjustUI();
    },
    adjustUI:function (){

    },
    getInitialState:function(){
        // var state = {pageData:this.props.getNowPageProps(),imgUrl:""};
        // return state;
        return null;
    },
    getMovie:function(callfun){
        // var url = this.props.movieSource+"/"+this.state.pageData.movieId;
        // this.serverRequest = $.get(url , function (result) {
        //     // c(result);
        //     if(result.code == 10000){
        //         return ;
        //     }
        //
        //     var state = this.state;
        //
        //     //set imgUrl
        //     state.imgUrl = "/img/"+result.data.movie.id;
        //
        //
        //
        //     this.setState(state);
        //     //callfun
        //     callfun!=undefined&&callfun();
        // }.bind(this));
    },
    render:function(){
        return (
            <div id="movie_info_content">
                <div id="movie_basic_info">
                    <div id="movie_img">
                        <img src=""/>
                    </div>
                    <div id="movie_text">

                    </div>
                </div>
            </div>
        );
    }
});
export default MovieInfoPage;