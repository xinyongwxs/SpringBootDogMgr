var DatePicker = require('react-datepicker');
var moment = require('moment');

require('react-datepicker/dist/react-datepicker.css');

class DatePicker extends React.Component {
	constructor(props) {
		super(props);
		
		this.state = {
			startDate: moment()
		};
	}

	componentWillMount() {

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