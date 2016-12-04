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
			}
		};
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

	handleModalClose() {
		this.setState({
			modalModel: {
				showModal: false,
				modalVals: {}
			}
		});
	}

	handleRowClick(e) {
		var headChildren = e.target.parentElement.parentElement.parentElement.children[0].children[0].childNodes;
		var curRowChildren = e.target.parentElement.childNodes;
		var header = [];
		var row = [];
		if (typeof headChildren == "object") {
			headChildren.forEach((col, index) => {
				header.push(col.innerText);
			});
		}

		if (typeof curRowChildren == "object") {
			curRowChildren.forEach((col, index) => {
				row.push(col.innerText);
			});
		}
		this.setState({
			modalModel: {
				showModal: true,
				modalVals: {}
			}
		});
	}

	render() {
		let rows = [], header;
		let selectedKey = this.props.selectedKey;
		let tableVals = this.props.tableVals;
		
		if (tableVals && typeof tableVals.forEach == "function") {
			if (selectedKey === 1) {
				header = (<tr><th>Name</th>
				<th>Type</th>
				<th>Training Level</th>
				<th>Trainer</th>
				<th>Birthday</th>
				<th>Ready For Work</th>
				<th>Price</th>
				<th>Category</th>
				<th>Chip Id</th>
				<th>Ear Id</th>
				<th>Company Code</th>
				<th>Epdate</th>
				<th>Kennel Id</th>
				<th>Remarks</th></tr>);
				
				tableVals.forEach((row, index) => {
					rows.push((<tr onClick={this.handleRowClick.bind(this)}><th>{row.name}</th>
					<th>{row.type}</th>
					<th>{row.traininglevel}</th>
					<th>{row.trainer}</th>
					<th>{row.birthday}</th>
					<th>{row.readyforworking}</th>
					<th>{row.price}</th>
					<th>{row.category}</th>
					<th>{row.chipid}</th>
					<th>{row.earid}</th>
					<th>{row.companycode}</th>
					<th>{row.epdate}</th>
					<th>{row.kennelid}</th>
					<th>{row.remarks}</th>
					</tr>));
				});
			} else if (selectedKey === 2) {
				header = (<tr><th>Name</th>
	            <th>Birthday</th>
	            <th>Kennel Id</th>
	            <th>Ep Date</th>
	            <th>Chip Id</th>
	            <th>Ear Id</th>
	            <th>Company Code</th>
	            <th>Type</th>
	            <th>Mating Date</th>
	            <th>Puppy Birthday</th>
	            <th>Feeder</th>
	            <th>Price</th>
	            <th>Ready For Sell</th>
	            <th>Puppy Account</th>
	            <th>Category</th>
	            <th>Remarks</th></tr>);

				tableVals.forEach((row, index) => {
					rows.push((<tr onClick={this.handleRowClick.bind(this)}>
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
				header = (<tr><th>Name</th>
				<th>Type</th>
				<th>Training Level</th>
				<th>Trainer</th>
				<th>Breeder</th>
				<th>Birthday</th>
				<th>Apperance</th>
				<th>Ready For Sell</th>
				<th>Price</th>
				<th>Ep Date</th>
				<th>Chip Id</th>
				<th>Ear Id</th>
				<th>Kennel Id</th>
				<th>Category</th>
				<th>Company Code</th>
				<th>Remarks</th>
				</tr>);
				
				tableVals.forEach((row, index) => {
					rows.push(<tr onClick={this.handleRowClick.bind(this)}><td>{row.name}</td>
					<td>{row.type}</td>
					<td>{row.traininglevel}</td>
					<td>{row.trainer}</td>
					<td>{row.breeder}</td>
					<td>{row.birthday}</td>
					<td>{row.apperance}</td>
					<td>{row.readyforsell}</td>
					<td>{row.price}</td>
					<td>{row.epdate}</td>
					<td>{row.chipid}</td>
					<td>{row.earid}</td>
					<td>{row.kennelid}</td>
					<td>{row.category}</td>
					<td>{row.companycode}</td>
					<td>{row.remarks}</td></tr>);
				});
			} else if (selectedKey === 4) {
				header = (<tr><th>Name</th>
				<th>Owner Phone</th>
				<th>Type</th>
				<th>Gender</th>
				<th>Kennel Id</th>
				<th>Chip Id</th>
				<th>Ear Id</th>
				<th>Courses</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Company Code</th>
				<th>Owner Id</th>
				<th>Ep Date</th>
				<th>Birthday</th>
				<th>Remarks</th></tr>);
				
				tableVals.forEach((row, index) => {
					rows.push(<tr onClick={this.handleRowClick.bind(this)}><td>{row.name}</td>
					<td>{row.ownerphone}</td>
					<td>{row.type}</td>
					<td>{row.gender}</td>
					<td>{row.kennelid}</td>
					<td>{row.chipid}</td>
					<td>{row.earid}</td>
					<td>{row.courses}</td>
					<td>{row.startdate}</td>
					<td>{row.enddate}</td>
					<td>{row.companycode}</td>
					<td>{row.ownerid}</td>
					<td>{row.epdate}</td>
					<td>{row.birthday}</td>
					<td>{row.remarks}</td></tr>);
				});
			}
		}

	    return (
	    <div>
	      <Table ref={(c) => this.example = c} className='display' cellSpacing='0' width='100%'>
	        <thead>
	            {header}
	        </thead>
	        <tfoot>
	        </tfoot>
	        <tbody>
	        	{rows}
	        </tbody>
	      </Table>

	      <Modal show={this.state.modalModel.showModal}>
	      	  <Modal.Header closeButton>
	      		<Modal.Title>Modal heading</Modal.Title>
	      	  </Modal.Header>
	      	  <Modal.Body>

	      	  </Modal.Body>
	      	  <Modal.Footer>
	      		<Button onClick={this.handleModalClose.bind(this)}>Close</Button>
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
