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

        return {maxTextLength: defaultMaxTextLength};
    },
    render: function () {

        //computer allText and shortText
        var maxTextLength = this.state.maxTextLength;
        var allText = this.props.text;
        if(isEmpty(allText)){
            allText = "";
        }
        var shortText = allText;
        if (maxTextLength < allText.length) {
            shortText = allText.substring(0, maxTextLength) + "...";
        }
        return (
            <div id="flex_text_content" title={allText}>
                {this.props.title}{shortText}
            </div>
        );

    }
});
export default FlexText;