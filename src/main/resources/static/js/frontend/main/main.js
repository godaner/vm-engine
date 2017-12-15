import ReactDOM from 'react-dom';
import React from 'react';
import IndexCenter from '../components/fragment_index_center';
ReactDOM.render(<IndexCenter tagGroupSource="/tagGroup/list" movieSource="/movie/list"/>,
    document.getElementById('react_dom_index_center'));
// ReactDOM.render(<MsgDialog/>,document.getElementById("react_dom_dialog"));