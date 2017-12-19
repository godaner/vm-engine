import React from 'react';  //引入react组件
import "../scss/actors_list.scss";
/*演员展示*/
var ActorsList = React.createClass({
    render: function () {

        return (
            <ul id="actors_list_ul">
                <li>主演：</li>
                {

                    (this.props.actors == undefined || this.props.actors.length == 0) ? this.props.whenThereHaveNotActor : this.props.actors.map(function (item) {
                        return(<li key={item.id}>
                            <a className="aLink" href="">{item.name}</a>&nbsp;
                        </li>);

                    })
                }

            </ul>
        );
    }
});
export default ActorsList;