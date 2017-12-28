import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import "../scss/director.scss";
/*导演展示*/
var Director = React.createClass({
    getInitialState: function () {

        return {whenThereHaveNotDirector: "无相关导演"};
    },
    render: function () {

        //a api to show the director.jsx

        var showDirector = (director) => {
            if (isEmpty(director)) {
                return this.state.whenThereHaveNotDirector;
            } else {
                // set the location
                const location = {
                    pathname: '/filmmaker/' + director.id,
                    state: {fromDashboard: true}
                }
                return <Link title={director.name} id="director_name" className="aLink" to={location}><span>导演 : </span>{director.name}</Link>;
            }
        }

        return (
            <span>

                {
                    showDirector(this.props.director)
                }
            </span>
        );
    }
});
export default Director;