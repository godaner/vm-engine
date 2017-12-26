import React from "react"; //引入react组件
import InnerMessager from "./inner_messager";
import "../scss/actors_details_area.scss";

/*演员详情展示*/
var ActorsDetailsArea = React.createClass({

    getInitialState: function () {
        return {whenActorsDetailsIsLoading: "正在加载演员信息"};
    },
    componentDidMount: function () {
        this.getFilmmakers();
    },
    getFilmmakers: function () {
        var url = "/movie/filmmaker/" + this.props.movieId;
        $.get(url, function (result) {
            c(result);
        }.bind(this));
    },
    showTip(){
        this.refs.actors_details_area_inner_messager.showMsg(msg, loop);
    },
    render: function () {

        return (
            <div id="actors_details_area">
                <InnerMessager defaultTip={this.state.whenActorsDetailsIsLoading}
                               ref="actors_details_area_inner_messager"/>
                ActorsDetailsArea
            </div>
        );
    }
});
export default ActorsDetailsArea;