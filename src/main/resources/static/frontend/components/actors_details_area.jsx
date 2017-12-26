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

            //set state
            var state = this.state;
            state.filmmakers = result.data.filmmakers;
            this.setState(state);

            //adjust ui
            this.adjustUI();

            //callfun
            this.props.onLoadDataSuccess(state.filmmakers);

        }.bind(this));
    },
    adjustUI: function () {
        var $actors_details_area = $(this.refs.actors_details_area);
        var w = $($actors_details_area.find("img")[0]).width();
        // c(w);
        var h = w;
        $actors_details_area.find("img").height(h);
    },
    showTip(msg, loop){
        this.refs.actors_details_area_inner_messager.showMsg(msg, loop);
    },
    render: function () {
        var listFilmmakers = function () {
            var filmmakers = this.state.filmmakers;
            var res = [];
            if(isEmptyList(filmmakers)){
                // res.push(<li key="1">无相关电影人</li>)
                return res;
            }


            for (var i = 0; i < filmmakers.length; i++) {
                var filmmaker = filmmakers[i];
                res.push(
                    <li key={filmmaker.id} title={filmmaker.name}>
                        <a title={filmmaker.name} href="#">
                            <img title={filmmaker.name} src={filmmaker.imgUrl}/>
                            <div title={filmmaker.name}>{filmmaker.name}</div>
                        </a>

                    </li>
                );
            }
            return res;
        }.bind(this);
        return (
            <div id="actors_details_area" ref="actors_details_area">
                <InnerMessager defaultTip={this.state.whenActorsDetailsIsLoading}
                               ref="actors_details_area_inner_messager"/>
                <PlainPanelTitle title={this.state.title}/>
                <ul>

                    {

                        listFilmmakers()
                    }


                </ul>
            </div>
        );
    }
});
export default ActorsDetailsArea;
