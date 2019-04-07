import './TodoList.css';
import React from 'react';

import { Progress } from 'semantic-ui-react';

class TodoList extends React.Component {

	render() {
		return (
			<div className="column todo-list-parent">
				<div className="ui card todo-list">
					<div className="content">
						<i onClick={() => this.props.onDeleteList(this.props.list.id)} className="right floated times circle icon icon-delete"></i>
						<i className="right floated edit icon icon-edit"></i>
						<div className="header">{this.props.list.name}</div>
					</div>
					<Progress percent={this.props.list.progress * 100} attached="bottom"/>
				</div>
			</div>

		);
	}
}

TodoList.defaultProps = {
	listTitle: 'New list'
};

export default TodoList;