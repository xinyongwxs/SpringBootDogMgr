import React from 'react';
import ReactDOM from 'react-dom';
import $ from 'jquery';

import {
  Row,
  Col,
  Grid,
  Panel,
  Table,
  Button,
  PanelBody,
  PanelHeader,
  FormControl,
  PanelContainer,
  Modal
} from '@sketchpixy/rubix';

import client from './client';
import RowEditor from './RowEditor';

//const propTypes = {
//	selectedKey: React.PropTypes.any
//};

class DatatableComponent extends React.Component {
	constructor(props) {
		super(props);
		
		this.state = {
			modalModel: {
				showModal: false,
				modalVals: {}
			},
			tableVals: {}
		};

		this.rowEditor = null;
		this.selectedRowId = "";
		this.tableVals = [];
	}
	
	componentWillMount() {

	}
	
	componentDidMount() {
//	    $(ReactDOM.findDOMNode(this.example))
//      .addClass('nowrap')
//      .dataTable({
//        responsive: true,
//        columnDefs: [
//          { targets: [-1, -3], className: 'dt-body-right' }
//        ]
//    });
	}

	componentWillReceiveProps(nextProps) {
		var tableVals = nextProps.tableVals;
		var curState = Object.assign({}, this.state);
		curState.tableVals = tableVals;
		this.setState(curState);
	}

	handleModalSubmit() {
		var curState = Object.assign({}, this.state);
		curState.modalModel.showModal = false;
		var rowValsState = this.rowEditor.state.rowDataState;

		curState.modalModel.modalVals.headerVals.forEach((val, index) => {
			curState.modalModel.modalVals.rowVals[index] = rowValsState[val].value;
		});

		curState.tableVals.some((row, index) => {
			if (row.id == this.selectedRowId) {
				for (var head in row) {
					if (head !== "id") {
						// var rowValsStateKey = head.toLowerCase();
						row[head] = rowValsState[head].value;
					}
				}
				return true;
			}
		});

		this.setState(curState);
	}

	handleModalClose() {
		var curState = Object.assign({}, this.state);
		curState.modalModel.showModal = false;
		this.setState(curState);
	}

	handleRowClick(e) {
		var headChildren = e.target.parentElement.parentElement.parentElement.children[0].children[0].childNodes;
		var curRowChildren = e.target.parentElement.childNodes;
		this.selectedRowId = e.target.parentElement.getAttribute("data-rowid");
		var header = [];
		var row = [];
		var types = [];
		var curRowInfo = {
			headerVals: [],
			rowVals: [],
			types: []
		};
		if (typeof headChildren == "object") {
			headChildren.forEach((col, index) => {
				header.push(col.getAttribute("data-key"));
				types.push(col.getAttribute("data-type"));
			});
		}

		if (typeof curRowChildren == "object") {
			curRowChildren.forEach((col, index) => {
				row.push(col.innerText);
			});
		}

		curRowInfo.headerVals = header;
		curRowInfo.rowVals = row;
		curRowInfo.types = types;

		this.setState({
			modalModel: {
				showModal: true,
				modalVals: curRowInfo
			}
		});
	}

	render() {
		let rows = [], header;
		let selectedKey = this.props.selectedKey;
		let tableVals = this.state.tableVals;
		
		if (tableVals && typeof tableVals.forEach == "function") {
			if (selectedKey === 1) {
				header = (<tr><th data-type="string" data-key="name">Name</th>
				<th data-type="string" data-key="type">Type</th>
				<th data-type="enum" data-key="trainingLevel">Training Level</th>
				<th data-type="string" data-key="trainer">Trainer</th>
				<th data-type="date" data-key="birthday">Birthday</th>
				<th data-type="enum" data-key="readyForWorking">Ready For Work</th>
				<th data-type="float" data-key="price">Price</th>
				<th data-type="enum" data-key="category">Category</th>
				<th data-type="string" data-key="chipId">Chip Id</th>
				<th data-type="string" data-key="earId">Ear Id</th>
				<th data-type="string" data-key="companyCode">Company Code</th>
				<th data-type="date" data-key="epDate">Epdate</th>
				<th data-type="string" data-key="kennelId">Kennel Id</th>
				<th data-type="string" data-key="remarks">Remarks</th></tr>);
				
				tableVals.forEach((row, index) => {
					rows.push((<tr onClick={this.handleRowClick.bind(this)} data-rowid={row.id}><th>{row.name}</th>
					<th>{row.type}</th>
					<th>{row.trainingLevel}</th>
					<th>{row.trainer}</th>
					<th>{row.birthday}</th>
					<th>{row.readyForWorking}</th>
					<th>{row.price}</th>
					<th>{row.category}</th>
					<th>{row.chipId}</th>
					<th>{row.earId}</th>
					<th>{row.companyCode}</th>
					<th>{row.epDate}</th>
					<th>{row.kennelId}</th>
					<th>{row.remarks}</th>
					</tr>));
				});
			} else if (selectedKey === 2) {
				header = (<tr><th data-type="string" data-key="name">Name</th>
	            <th data-type="date" data-key="birthday">Birthday</th>
	            <th data-type="string" data-key="kennelId">Kennel Id</th>
	            <th data-type="date" data-key="epDate">Ep Date</th>
	            <th data-type="string" data-key="chipId">Chip Id</th>
	            <th data-type="string" data-key="earId">Ear Id</th>
	            <th data-type="string" data-key="companyCode">Company Code</th>
	            <th data-type="enum" data-key="type">Type</th>
	            <th data-type="date" data-key="matingDate">Mating Date</th>
	            <th data-type="date" data-key="puppyBirthday">Puppy Birthday</th>
	            <th data-type="string" data-key="feeder">Feeder</th>
	            <th data-type="float" data-key="price">Price</th>
	            <th data-type="enum" data-key="readyForSell">Ready For Sell</th>
	            <th data-type="number" data-key="puppyAccount">Puppy Account</th>
	            <th data-type="enum" data-key="category">Category</th>
	            <th data-type="string" data-key="remarks">Remarks</th></tr>);

				tableVals.forEach((row, index) => {
					rows.push((<tr data-rowid={row.id} onClick={this.handleRowClick.bind(this)}>
			        <th>{row.name}</th>
			        <th>{row.birthday}</th>
			        <th>{row.kennelId}</th>
			        <th>{row.epDate}</th>
			        <th>{row.chipId}</th>
			        <th>{row.earId}</th>
			        <th>{row.companyCode}</th>
			        <th>{row.type}</th>
			        <th>{row.matingDate}</th>
			        <th>{row.puppyBirthday}</th>
			        <th>{row.feeder}</th>
			        <th>{row.price}</th>
			        <th>{row.readyForSell}</th>
			        <th>{row.puppyAccount}</th>
			        <th>{row.category}</th>
			        <th>{row.remarks}</th>
			      </tr>));
				});
			} else if (selectedKey === 3) {
				header = (<tr><th data-type="string" data-key="name">Name</th>
				<th data-type="enum" data-key="type">Type</th>
				<th data-type="enum" data-key="trainingLevel">Training Level</th>
				<th data-type="string" data-key="trainer">Trainer</th>
				<th data-type="string" data-key="breeder">Breeder</th>
				<th data-type="date" data-key="birthday">Birthday</th>
				<th data-type="string" data-key="apperance">Apperance</th>
				<th data-type="enum" data-key="readyForSell">Ready For Sell</th>
				<th data-type="float" data-key="price">Price</th>
				<th data-type="date" data-key="epDate">Ep Date</th>
				<th data-type="string" data-key="chipId">Chip Id</th>
				<th data-type="string" data-key="earId">Ear Id</th>
				<th data-type="string" data-key="kennelId">Kennel Id</th>
				<th data-type="enum" data-key="category">Category</th>
				<th data-type="string" data-key="companyCode">Company Code</th>
				<th data-type="string" data-key="remarks">Remarks</th>
				</tr>);
				
				tableVals.forEach((row, index) => {
					rows.push(<tr data-rowid={row.id} onClick={this.handleRowClick.bind(this)}><td>{row.name}</td>
					<td>{row.type}</td>
					<td>{row.trainingLevel}</td>
					<td>{row.trainer}</td>
					<td>{row.breeder}</td>
					<td>{row.birthday}</td>
					<td>{row.apperance}</td>
					<td>{row.readyForSell}</td>
					<td>{row.price}</td>
					<td>{row.epDate}</td>
					<td>{row.chipId}</td>
					<td>{row.earId}</td>
					<td>{row.kennelId}</td>
					<td>{row.category}</td>
					<td>{row.companyCode}</td>
					<td>{row.remarks}</td></tr>);
				});
			} else if (selectedKey === 4) {
				header = (<tr><th data-type="string" data-key="name">Name</th>
				<th data-type="string" data-key="ownerPhone">Owner Phone</th>
				<th data-type="enum" data-key="type">Type</th>
				<th data-type="enum" data-key="gender">Gender</th>
				<th data-type="string" data-key="kennelId">Kennel Id</th>
				<th data-type="string" data-key="chipId">Chip Id</th>
				<th data-type="string" data-key="earId">Ear Id</th>
				<th data-type="string" data-key="courses">Courses</th>
				<th data-type="date" data-key="startDate">Start Date</th>
				<th data-type="date" data-key="endDate">End Date</th>
				<th data-type="string" data-key="companyCode">Company Code</th>
				<th data-type="string" data-key="ownerId">Owner Id</th>
				<th data-type="date" data-key="epDate">Ep Date</th>
				<th data-type="date" data-key="birthday">Birthday</th>
				<th data-type="string" data-key="remarks">Remarks</th></tr>);
				
				tableVals.forEach((row, index) => {
					rows.push(<tr data-rowid={row.id} onClick={this.handleRowClick.bind(this)}><td>{row.name}</td>
					<td>{row.ownerPhone}</td>
					<td>{row.type}</td>
					<td>{row.gender}</td>
					<td>{row.kennelId}</td>
					<td>{row.chipId}</td>
					<td>{row.earId}</td>
					<td>{row.courses}</td>
					<td>{row.startDate}</td>
					<td>{row.endDate}</td>
					<td>{row.companyCode}</td>
					<td>{row.ownerId}</td>
					<td>{row.epDate}</td>
					<td>{row.birthday}</td>
					<td>{row.remarks}</td></tr>);
				});
			}
		}

	    return (
	    <div>
	      <Table className='display' cellSpacing='0' width='100%'>
	        <thead>
	            {header}
	        </thead>
	        <tfoot>
	        </tfoot>
	        <tbody>
	        	{rows}
	        </tbody>
	      </Table>
	      
	      <Modal show={this.state.modalModel.showModal} onHide={this.handleModalClose.bind(this)}>
	      	  <Modal.Header closeButton>
	      		<Modal.Title>Modal heading</Modal.Title>
	      	  </Modal.Header>
	      	  <Modal.Body>
	      	  	<RowEditor ref={(rowEditor) => {
	      	  		this.rowEditor = rowEditor;
	      	  	}} rowValues={this.state.modalModel.modalVals}></RowEditor>
	      	  </Modal.Body>
	      	  <Modal.Footer>
	      		<Button onClick={this.handleModalSubmit.bind(this)}>Submit</Button>
	      	  </Modal.Footer>
	      </Modal>
	    </div>
	    );
	  }
	}

export default class Datatablesjs extends React.Component {
  render() {
    return (
		<div>
			<Row>
				<Col xs={12}>
				  <PanelContainer>
				    <Panel>
				      <PanelBody>
				        <Grid>
				          <Row>
				            <Col xs={12}>
				              <DatatableComponent selectedKey={this.props.selectedKey} tableVals={this.props.tableVals} />
				              <br/>
				            </Col>
				          </Row>
				        </Grid>
				      </PanelBody>
				    </Panel>
				  </PanelContainer>
				</Col>
			</Row>


	    </div>
    );
  }
}
