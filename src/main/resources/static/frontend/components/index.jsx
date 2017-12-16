
import React from 'react';  //引入react组件
import '../scss/index.scss';
import IndexCenter from "./fragment_index_center";
import Head from "./fragment_head";
import Tail from "./fragment_tail";
var Index = React.createClass({

    render: function () {
        return (
            <div id="index">
                <Head/>
                <IndexCenter tagGroupSource="/tagGroup/list" movieSource="/movie/list"/>
                <Tail/>
            </div>
        );
    }
});

export default Index;   //将App组件导出