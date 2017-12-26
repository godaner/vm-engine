import React from 'react';  //引入react组件
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
                return <a id="director_name" className="aLink" href="javascript:void(0);">导演 : {director.name}</a>;
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