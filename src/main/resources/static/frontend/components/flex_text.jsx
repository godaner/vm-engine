import React from 'react';  //引入react组件
import "../scss/flex_text.scss";
/*弹性文本展示*/
var FlexText = React.createClass({
    getInitialState: function () {
        //set maxTextLength
        var defaultMaxTextLength = 100;
        if (!isEmpty(this.props.maxTextLength)) {
            defaultMaxTextLength = this.props.maxTextLength;
        }
        var text = "";
        if(!isEmpty(this.props.text)){
            text = this.props.text;
        }
        return {text: text, maxTextLength: defaultMaxTextLength};
    },
    render: function () {
        // c(1);
        //computer allText and shortText
        var maxTextLength = this.state.maxTextLength;
        var allText = this.state.text;
        var shortText = allText;
        if (maxTextLength < allText.length) {
            shortText = "";
            for (var i = 0; i < maxTextLength; i++) {
                shortText += allText.charAt(i);
            }
            shortText += "...";
        }
        return (
            <span title={allText}>
                简介 : {shortText}
            </span>
        );

    }
});
export default FlexText;