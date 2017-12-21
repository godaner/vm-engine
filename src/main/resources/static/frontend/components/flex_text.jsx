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
        var defaultText = "there is have not content";
        // c(this.props);
        if (!isEmpty(this.props.text)) {
            defaultText = this.props.text;
        }
        // c(defaultText);
        var defaultTitle = "there is have not title";
        if (!isEmpty(this.props.title)) {
            defaultTitle = this.props.title;
        }
        return {text: defaultText, maxTextLength: defaultMaxTextLength, title: defaultTitle};
    },
    updateText: function (text) {
        var state = this.state;
        state.text = text;
        this.setState(state);
    },
    render: function () {
        // c(1);
        //computer allText and shortText
        var maxTextLength = this.state.maxTextLength;
        var allText = this.state.text;
        var shortText = allText;
        if (maxTextLength < allText.length) {
            shortText = allText.substring(0, maxTextLength) + "...";
        }
        return (
            <div id="flex_text_content" title={allText}>
                {this.state.title}{shortText}
            </div>
        );

    }
});
export default FlexText;