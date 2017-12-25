import React from 'react';  //引入react组件
import "../scss/actors_details_area.scss";
/*演员详情展示*/
var ActorsDetailsArea = React.createClass({
    componentDidMount:function(){
        this.getFilmmakers();
    },
    getFilmmakers:function(){
        var url = "/movie/filmmaker/"+this.props.movieId;
        $.get(url,function(result){
            c(result);
        }.bind(this));
    },
    render: function () {

        return (
            <div id="actors_details_area">
                ActorsDetailsArea
            </div>
        );
    }
});
export default ActorsDetailsArea;