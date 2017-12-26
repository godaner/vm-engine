import React from 'react';  //引入react组件
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
                if (i != actors.length - 1) {
                    res.push(<span key={actor.id}><a className="aLink" href="">{actor.name}</a> / </span>);
                } else {
                    res.push(<a key={actor.id} className="aLink" href="">{actor.name}</a>);
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