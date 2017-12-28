import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import "../scss/actors_list.scss";
/*演员展示*/
var ActorsList = React.createClass({
    getInitialState: function () {
        return {whenThereHaveNotActor: "无相关演员"};
    },
    render: function () {
        //map
        var listActors = (actors) => {
            var res = [];
            for (var i = 0; i < actors.length; i++) {
                var actor = actors[i];
                // set the location
                const location = {
                    pathname: '/filmmaker/' + actor.id,
                    state: {fromDashboard: true}
                }
                if (i != actors.length - 1) {
                    res.push(<span key={actor.id}><Link className="aLink" to={location}>{actor.name}</Link> / </span>);
                } else {
                    res.push(<Link key={actor.id} className="aLink" to={location}>{actor.name}</Link>);
                }

            }
            return res
        }
        // tip string
        var actorsStr = this.state.whenThereHaveNotActor;
        // c(actorsStr);
        var actors = this.props.actors;
        if (!isEmptyList(actors)) {
            actorsStr = "";
            for (var i = 0; i < actors.length; i++) {
                var actor = actors[i];
                actorsStr += actor.name;
                if (i != actors.length - 1) {
                    actorsStr += " / ";
                }
            }
        }
        return (
            <span title={actorsStr}>
                    主演：

                {
                    isEmptyList(this.props.actors) ? this.state.whenThereHaveNotActor : listActors(this.props.actors)
                }
                </span>
        );
    }
});
export default ActorsList;