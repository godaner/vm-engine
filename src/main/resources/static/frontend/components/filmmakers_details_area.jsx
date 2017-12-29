import React from "react"; //引入react组件
import {Link} from 'react-router-dom';
import InnerMessager from "./inner_messager";
import "../scss/filmmakers_details_area.scss";
import PlainPanelTitle from "./plain_panel_title";

/*演员详情展示*/
var FilmmakersDetailsArea = React.createClass({

    getInitialState: function () {
        return {
            whenActorsDetailsIsLoading: "正在加载电影人信息",
            whenThereIsHaveNotFilmmakers: "无相关电影人",
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

        ajax.get({
            url: url,
            onBeforeRequest: function () {


            }.bind(this),
            onResponseStart: function () {

                //hide tip
                this.showTip();
            }.bind(this),
            onResponseSuccess: function (result) {
                if (isEmptyList(result.data.filmmakers)) {
                    this.showTip(this.state.whenThereIsHaveNotFilmmakers, false);

                    //callfun
                    this.props.onLoadDataSuccess([]);

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
            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(result.msg);
            }.bind(this),
            onResponseEnd: function () {
            }.bind(this)
        });

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
            // if(isEmptyList(filmmakers)){
            // res.push(<li key="1">无相关电影人</li>)
            // return res;
            // }
            if (isEmptyList(filmmakers)) {
                filmmakers = [];
            }


            for (var i = 0; i < filmmakers.length; i++) {
                var filmmaker = filmmakers[i];
                // set the location
                const location = {
                    pathname: '/filmmaker/' + filmmaker.id,
                    state: {fromDashboard: true}
                }
                res.push(
                    <li key={filmmaker.id} title={filmmaker.name}>
                        <Link title={filmmaker.name} to={location}>
                            <img title={filmmaker.name} src={filmmaker.imgUrl}/>
                            <div title={filmmaker.name}>{filmmaker.name}</div>
                        </Link>

                    </li>
                );
            }
            return res;
        }.bind(this);
        return (
            <div id="actors_details_area" ref="actors_details_area">
                <PlainPanelTitle title={this.state.title}/>
                <InnerMessager defaultTip={this.state.whenActorsDetailsIsLoading}
                               ref="actors_details_area_inner_messager"/>
                <ul>

                    {

                        listFilmmakers()
                    }


                </ul>
            </div>
        );
    }
});
export default FilmmakersDetailsArea;
