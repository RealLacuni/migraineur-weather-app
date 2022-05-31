import follow from './follow';
'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {days: []}; //stores an array of days from the rest backend
    }

    componentDidMount() {
        this.loadFromServer(this.state.pageSize);
        }

    render() {
        return ( <DayList days={this.state.days}/>
        )
    }

    loadFromServer(pageSize) {
        var root = '/api';
        follow(client, root, [
            {rel: 'days', params: {size: pageSize}}]
        ).then(dayCollection => {
            return client({
                method: 'GET',
                path: dayCollection.entity._links.profile.href,
                headers: {'Accept': 'application/schema+json'}
            }).then(schema => {
                this.schema = schema.entity;
                return dayCollection;
            });
        }).done(dayCollection => {
            this.setState({
                days: dayCollection.entity._embedded.days,
                attributes: Object.keys(this.schema.properties),
                pageSize: pageSize,
                links: dayCollection.entity._links});
        });
    }
}

class DayList extends React.Component {
    render() {
        const days = this.props.days.map(day => <Day key={day._links.self.href} day={day}/>
        );
        return( 
            <table>
                    <tbody> 
                            <tr>
                                    <th>Date</th>
                                    <th>Temperature</th>
                                    <th>Pressure</th>
                                    <th>Humidity</th>
                            </tr>
                            {days}
                    </tbody>
            </table>
    )
    }
}

class Day extends React.Component{
    render() {
        return ( 
                <tr>    
                    <td>{this.props.day.date}</td>
                    <td>{this.props.day.temperature}</td>
                    <td>{this.props.day.pressure}</td>
                    <td>{this.props.day.humidity}</td>
                </tr>
        )
    }
}

class CreateDialog extends React.Component {

	constructor(props) {
		super(props);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleSubmit(e) {
		e.preventDefault();
		const newDay = {};
		this.props.attributes.forEach(attribute => {
			newDay[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
		});
		this.props.onCreate(newDay);

		// clear out the dialog's inputs
		this.props.attributes.forEach(attribute => {
			ReactDOM.findDOMNode(this.refs[attribute]).value = '';
		});

		// Navigate away from the dialog to hide it.
		window.location = "#";
	}

	render() {
		const inputs = this.props.attributes.map(attribute =>
			<p key={attribute}>
				<input type="text" placeholder={attribute} ref={attribute} className="field"/>
			</p>
		);

		return (
			<div>
				<a href="#createDay">Create</a>

				<div id="createDay" className="modalDialog">
					<div>
						<a href="#" title="Close" className="close">X</a>

						<h2>Create new day</h2>

						<form>
							{inputs}
							<button onClick={this.handleSubmit}>Create</button>
						</form>
					</div>
				</div>
			</div>
		)
	}

}

ReactDOM.render( 
            <App />, 
            document.getElementById('react')
)
