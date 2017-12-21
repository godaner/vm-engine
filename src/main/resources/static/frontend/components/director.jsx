import React from 'react';  //引入react组件
import "../scss/director.scss";
/*导演展示*/
var Director = React.createClass({
    getInitialState: function () {
        //when have not director show what?
        var whenThereHaveNotDirector = this.props.whenThereHaveNotDirector;
        if (isEmpty(whenThereHaveNotDirector)) {
            whenThereHaveNotDirector = "无导演";
        }
        return {whenThereHaveNotDirector: whenThereHaveNotDirector};
    },
    render: function () {
        //a api to show the director.jsx
        var showDirector = (director) => {
            if (isEmpty(director)) {
                return this.state.whenThereHaveNotDirector;
            } else {
                return <a className="aLink" href="javascript:void(0);">{director.name}</a>;
            }
        }

        return (
            <span>
                导演 : {
                    showDirector(this.props.director)
                }
            </span>
        );
    }
});
export default Director;