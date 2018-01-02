import React from 'react';  //引入react组件
import "../scss/pager.scss"

var Pager = React.createClass({

    render: function () {
        return (
            <div id="movie_list_pager_div">
                <ul id="movie_list_pager_ul">
                    <li className="pager_li">
                        <a href="javascript:void(0);" onClick={() => {
                            this.props.handlePageChange(-1)
                        }}>上一页</a>
                    </li>
                    <li className="pager_li currt">
                        <a href="javascript:void(0);">{this.props.page}</a>
                    </li>
                    <li className="pager_li">
                        <a href="javascript:void(0);" onClick={() => {
                            this.props.handlePageChange(1)
                        }}>下一页</a>
                    </li>
                </ul>
            </div>
        );
    }
});
export default Pager;   //将App组件导出
