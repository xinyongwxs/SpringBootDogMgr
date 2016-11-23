'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
import {
	Nav,
	NavItem,
	PageHeader
	} from '@sketchpixy/rubix';

import Datatablesjs from './Datatablesjs';
import client from './client';
//import './../../main.css';

class App extends React.Component {

	constructor(props) {
		super(props);
		
		this.state = {
			selectedKey: 1	
		};
	}
	
	componentWillMount() {
		
	}

	componentDidMount() {

	}
	
	handleSelect(selectedKey) {
		this.setState({
			selectedKey: selectedKey
		});
	}

	render() {
		const navInstance = (
			<div>
			  <Nav bsStyle="pills" className='nav-orange75' activeKey={this.state.selectedKey} onSelect={this.handleSelect.bind(this)}>
				<NavItem eventKey={1}>工作犬管理</NavItem>
				<NavItem eventKey={2}>繁殖犬管理</NavItem>
				<NavItem eventKey={3}>宠物犬管理</NavItem>
				<NavItem eventKey={4}>代训犬管理</NavItem>
			  </Nav>
			  
			  <Datatablesjs selectedKey={this.state.selectedKey}/>
			 </div>
		);
		
		return navInstance;
	}
}



ReactDOM.render(
	<App />,
	document.getElementById('react')
)


