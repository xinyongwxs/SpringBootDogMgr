'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
import {
	Nav,
	NavItem,
	PageHeader,
	FormControl
	} from '@sketchpixy/rubix';

import Datatablesjs from './Datatablesjs';
import client from './client';
//import './../../main.css';

class App extends React.Component {

	constructor(props) {
		super(props);
		
		this.state = {
			selectedKey: 1,
			tableVals: []
		};
		
		this.originalTableVals = [];
	}
	
	componentWillMount() {
		client({method: 'GET', path: '/workingdog'}).done(response => {
			this.originalTableVals = response.entity;
			this.setState({
				selectedKey: 1,
				tableVals: response.entity
			});
		});
	}

	componentDidMount() {

	}
	
	handleSelect(selectedKey) {
		if (selectedKey == 1) {
			client({method: 'GET', path: '/workingdog'}).done(response => {
				this.originalTableVals = response.entity;
				this.setState({
					selectedKey: selectedKey,
					tableVals: response.entity
				});
			});
		} else if (selectedKey == 2) {
			client({method: 'GET', path: '/breedingdog'}).done(response => {
				this.originalTableVals = response.entity;
				this.setState({
					selectedKey: selectedKey,
					tableVals: response.entity
				});
			});
		} else if (selectedKey == 3) {
			client({method: "GET", path: "/petdog"}).done(response => {
				this.originalTableVals = response.entity;
				this.setState({
					selectedKey: selectedKey,
					tableVals: response.entity
				});
			});
		} else if (selectedKey == 4) {
			client({method: "GET", path: "/trainingdog"}).done(response => {
				this.originalTableVals = response.entity;
				this.setState({
					selectedKey: selectedKey,
					tableVals: response.entity
				});
			});
		}

	}

	handleChange(e) {
		var tableVals = this.originalTableVals;
		var filteredTable = tableVals.filter((item) => {
			for (var col in item) {
				if (col !== "id" && item[col].toString().indexOf(e.target.value) >= 0) {
					return true;
				}
			}
		});

		this.setState({
			selectedKey: this.state.selectedKey,
			tableVals: filteredTable
		});
	}

	render() {
		const navInstance = (
			<div className='container'>
				<FormControl type='text' placeholder='Search...' onChange={this.handleChange.bind(this)} className='form-control' />

				<Nav bsStyle="pills" className='nav-orange75' activeKey={this.state.selectedKey} onSelect={this.handleSelect.bind(this)}>
					<NavItem eventKey={1}>工作犬管理</NavItem>
					<NavItem eventKey={2}>繁殖犬管理</NavItem>
					<NavItem eventKey={3}>宠物犬管理</NavItem>
					<NavItem eventKey={4}>代训犬管理</NavItem>
				</Nav>
			  
			  <Datatablesjs selectedKey={this.state.selectedKey} tableVals={this.state.tableVals}/>
			 </div>
		);
		
		return navInstance;
	}
}



ReactDOM.render(
	<App />,
	document.getElementById('react')
)


