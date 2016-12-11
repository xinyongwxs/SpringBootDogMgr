import React from 'react';
var DatePicker = require('react-datepicker');
var moment = require('moment');

require('react-datepicker/dist/react-datepicker.css');

export default class DatePickerComponent extends React.Component {
	constructor(props) {
		super(props);
		
		this.state = {
			startDate: moment()
		};
	}

	componentWillMount() {
		this.setState({
			startDate: moment(this.props.value)
		});
	}
	
	componentDidMount() {

	}

	handleChange(date) {
		this.setState({
			startDate: date
		});
	}

	render() {
		return (<DatePicker
			selected={this.state.startDate}
			onChange={this.handleChange.bind(this)} />);
	}
}