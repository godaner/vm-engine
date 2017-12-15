import ReactDOM from 'react-dom';
import React from 'react';/*!!记得导入*/
import IndexCenter from '../components/fragment_index_center';
import Head from '../components/fragment_head';
import Tail from '../components/fragment_tail';
/*网站头部*/
ReactDOM.render(<Tail/>,
    document.getElementById('react_dom_index_tail'));
/*主页中部*/
ReactDOM.render(<IndexCenter tagGroupSource="/tagGroup/list" movieSource="/movie/list"/>,
    document.getElementById('react_dom_index_center'));
/*网站尾部*/
ReactDOM.render(<Head/>,
    document.getElementById('react_dom_index_head'));


// ReactDOM.render(<MsgDialog/>,document.getElementById("react_dom_dialog"));