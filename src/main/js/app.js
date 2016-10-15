'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
//import './../../main.css';
import Datatablesjs from './Datatablesjs';

class App extends React.Component {

	constructor(props) {
		super(props);
	}

	componentDidMount() {

	}

	render() {
		return (
			<EmployeeList />
		)
	}
}

class EmployeeList extends React.Component{
	render() {

		return (
				<Datatablesjs />
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)


