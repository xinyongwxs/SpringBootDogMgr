import React from 'react';
import ReactDOM from 'react-dom';
import $ from 'jquery';

import {
  Row,
  Col,
  Grid,
  Panel,
  Table,
  PanelBody,
  PanelHeader,
  FormControl,
  PanelContainer,
} from '@sketchpixy/rubix';

import client from './client';

//const propTypes = {
//	selectedKey: React.PropTypes.any
//};

class DatatableComponent extends React.Component {
	constructor(props) {
		super(props);
		
		this.state = {
			tableVals: []
		};
	}
	
	componentWillMount() {
		if (this.props.selectedKey == 1) {
			client({method: 'GET', path: '/breedingdog'}).done(response => {
				this.setState({
					tableVals: response.entity
				});
			});
		}
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

  render() {
	let rows = [];
	let selectedKey = this.props.selectedKey;
	
	if (this.state.tableVals && typeof this.state.tableVals.forEach == "function") {
		this.state.tableVals.forEach((row, index) => {
			rows.push((<tr>
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
	}

    return (
      <Table ref={(c) => this.example = c} className='display' cellSpacing='0' width='100%'>
        <thead>
          <tr>
            <th>Name</th>
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
            <th>Remarks</th>
          </tr>
        </thead>
        <tfoot>
          <tr>
          <th>Name</th>
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
          <th>Remarks</th>
          </tr>
        </tfoot>
        <tbody>
        	{rows}
        </tbody>
      </Table>
    );
  }
}

export default class Datatablesjs extends React.Component {
  render() {
    return (
      <Row>
        <Col xs={12}>
          <PanelContainer>
            <Panel>
              <PanelBody>
                <Grid>
                  <Row>
                    <Col xs={12}>
                      <DatatableComponent selectedKey={this.props.selectedKey} />
                      <br/>
                    </Col>
                  </Row>
                </Grid>
              </PanelBody>
            </Panel>
          </PanelContainer>
        </Col>
      </Row>
    );
  }
}
