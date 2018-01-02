import React from 'react';  //引入react组件
import '../scss/tail.scss';
var Tail = React.createClass({

    render: function () {
        return (
            <div id="fragment_tail_content">
                <img src="/image/tail.png"/>
            </div>
        );
    }
});

export default Tail;   //将App组件导出