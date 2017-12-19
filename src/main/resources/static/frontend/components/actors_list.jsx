import React from 'react';  //引入react组件
import "../scss/actors_list.scss";
/*演员展示*/
var ActorsList = React.createClass({
    render: function () {
        //map
        var listActors = (actors) => {
            var res = [];
            for (var i = 0; i < actors.length; i++) {
                var actor = actors[i];
                if (i != actors.length - 1) {
                    res.push(<li key={actor.id}><a className="aLink" href="">{actor.name}</a> / </li>);
                } else {
                    res.push(<li key={actor.id}><a className="aLink" href="">{actor.name}</a></li>);
                }
            }
            return res
        }
        // tip string
        var actorsStr = this.props.whenThereHaveNotActor;
        var actors = this.props.actors;
        if (!isEmptyList(actors)) {
            actorsStr = "";
            for (var i = 0; i < actors.length; i++) {
                var actor = actors[i];
                if (i != actors.length - 1) {
                    actorsStr += actor.name + " / ";
                } else {
                    actorsStr += actor.name;
                }
            }
        }
        return (
            <ul title={actorsStr} id="actors_list_ul">
                <li>主演：
                    {
                        isEmptyList(this.props.actors) ? this.props.whenThereHaveNotActor : listActors(this.props.actors)
                    }
                </li>

            </ul>
        );
    }
});
export default ActorsList;