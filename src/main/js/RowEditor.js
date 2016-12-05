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

import DatePicker from './DatePicker';

class RowEditor extends React.Component {
	constructor(props) {
		super(props);
		
		this.state = {
		};
	}

	componentWillMount() {

	}
	
	componentDidMount() {

	}

	render() {
		return (<PanelContainer noOverflow>
				<PanelBody>
					<Grid>
						<Row>
							<Col xs={12}>
								<Form>
									
								</Form>
							</Col>
						</Row>
					</Grid>
				</PanelBody>
			</PanelContainer>);
	}
}

