import React from 'react';

import {
  Row,
  Col,
  Nav,
  Grid,
  Icon,
  Form,
  Panel,
  Radio,
  Button,
  MenuItem,
  Checkbox,
  HelpBlock,
  PanelBody,
  FormGroup,
  InputGroup,
  SplitButton,
  PanelHeader,
  ButtonGroup,
  FormControl,
  PanelFooter,
  ControlLabel,
  DropdownButton,
  PanelContainer
} from '@sketchpixy/rubix';

// import DatePickerComponent from './DatePickerComponent';
var DatePicker = require('react-datepicker');
var moment = require('moment');

require('react-datepicker/dist/react-datepicker.css');

export default class RowEditor extends React.Component {
	constructor(props) {
		super(props);
		this.updatedProperties = {};
		this.state = {
			rowDataState: {

			}
		};
		// this.state = {
		// };
	}

	componentWillMount() {
		let modalVals = this.props.rowValues;
		let header = modalVals.headerVals;
		let row = modalVals.rowVals;
		let types = modalVals.types;
		let rowDataState = {};
		if (header && header.forEach) {
			header.forEach((hVal, index) => {
				rowDataState[hVal] = {
					value: row[index],
					type: types[index]
				};
			});

			this.setState({
				rowDataState: rowDataState
			});
		} else {
			this.setState({
				rowDataState: {}
			});
		}

	}
	
	componentDidMount() {

	}

	componentWillUpdate() {

	}

	handleDateChange(col, date) {
		this.updateStateVals(col, date.format("YYYY-MM-DD"));
	}

	handleTextChange(col, e) {
		this.updateStateVals(col, e.target.value);
	}

	updateStateVals(col, newVal) {
		var curState = Object.assign({}, this.state);
		curState.rowDataState[col].value = newVal;
		this.setState(curState);
	}

	render() {
		let formGroups = [];
		for (var col in this.state.rowDataState) {
			var colObj = this.state.rowDataState[col];
			if (colObj.type === "string" || colObj.type === "float") {
				formGroups.push((<FormGroup>
						<ControlLabel>{col}</ControlLabel>
						<FormControl type='text' 
						defaultValue={colObj.value} 
						onChange={this.handleTextChange.bind(this, col)}></FormControl>
					</FormGroup>));
			} else if (colObj.type === "date") {
				formGroups.push((<FormGroup>
						<ControlLabel>{col}</ControlLabel>
						<DatePicker selected={moment(colObj.value)} 
							onChange={this.handleDateChange.bind(this, col)}
							placeholderText="Click to select a date"
							showMonthDropdown
							showYearDropdown />
					</FormGroup>));
			} else if (colObj.type === "enum") {

			}
		}

		return (<PanelContainer noOverflow>
				<PanelBody>
					<Grid>
						<Row>
							<Col xs={12}>
								<Form>
									{formGroups}
								</Form>
							</Col>
						</Row>
					</Grid>
				</PanelBody>
			</PanelContainer>);
	}
}