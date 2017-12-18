
import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
class MovieInfoPage extends React.Component{
    // 构造
    constructor(props){

        super(props);
        c("constructor");
        c(this);
        c(props);
        c(this.props);

    }

    componentDidMount () {
        window.addEventListener('resize', this.onWindowResize);

        // this.getMovie();
    }
    componentWillUnmount() {
        window.removeEventListener('resize' ,this.onWindowResize);
    }
    onWindowResize () {
        this.adjustUI();
    }
    adjustUI (){

    }
    getMovie(callfun){
        // var url = this.props.movieSource+"/"+this.state.pageData.movieId;
        // this.serverRequest = $.get(url   (result) {
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
    }
    render(){
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
};
export default MovieInfoPage;