import React from 'react';
import './Lists';
import TodoList from "./TodoList";

class Lists extends React.Component {

	render() {
		const lists = this.props.lists.map(list => {
			return <TodoList onDeleteList={this.props.onDeleteList} key={list.id} list={list}/>
		});

		return (
			<div className="lists three column row">
				{lists}
			</div>
		);
	}
}

export default Lists;