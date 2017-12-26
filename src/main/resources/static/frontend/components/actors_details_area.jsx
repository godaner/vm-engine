import React from "react"; //引入react组件
import InnerMessager from "./inner_messager";
import "../scss/actors_details_area.scss";
import PlainPanelTitle from "./plain_panel_title";

/*演员详情展示*/
var ActorsDetailsArea = React.createClass({

    getInitialState: function () {
        return {
            whenActorsDetailsIsLoading: "正在加载演员信息",
            title: "相关演员"
        };
    },
    componentDidMount: function () {
        //add resize event listener
        window.addEventListener('resize', this.onWindowResize);
        //get filmmakers
        this.getFilmmakers();
    },
    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize);
    },
    onWindowResize: function () {
        this.adjustUI();
    },
    getFilmmakers: function () {
        var url = "/movie/filmmaker/" + this.props.movieId;
        $.get(url, function (result) {
            c(result);
            //hide tip
            this.showTip();

            if (fail(result.code)) {
                return;
            }
            this.adjustUI();


        }.bind(this));
    },
    adjustUI:function(){
        var $actors_details_area = $(this.refs.actors_details_area);
        var w = $($actors_details_area.find("img")[0]).width();
        c(w);
        var h = w;
        $actors_details_area.find("img").height(h);
    },
    showTip(msg, loop){
        this.refs.actors_details_area_inner_messager.showMsg(msg, loop);
    },
    render: function () {

        return (
            <div id="actors_details_area" ref="actors_details_area">
                <InnerMessager defaultTip={this.state.whenActorsDetailsIsLoading}
                               ref="actors_details_area_inner_messager"/>
                <PlainPanelTitle title={this.state.title}/>
                <ul>
                    <li>
                        <a href="#">
                            <img src="/filmmaker/img/101?imgWidth=200"/>
                            <div>zhangke00</div>
                        </a>

                    </li>
                    <li>
                        <a href="#">
                            <img src="/filmmaker/img/1"/>
                            <div>zhangke</div>
                        </a>

                    </li>
                    <li>
                        <a href="#">
                            <img src="/filmmaker/img/1"/>
                            <div>zhangke</div>
                        </a>

                    </li>
                    <li>
                        <a href="#">
                            <img src="/filmmaker/img/1"/>
                            <div>zhangke</div>
                        </a>

                    </li>
                    <li>
                        <a href="#">
                            <img src="/filmmaker/img/1"/>
                            <div>zhangke</div>
                        </a>

                    </li>

                </ul>
            </div>
        );
    }
});
export default ActorsDetailsArea;
