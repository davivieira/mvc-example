import React from 'react';
import './Menu.css';

class Menu extends React.Component {

	render() {
		return (
			<div onClick={this.props.onAddList} className="ui one item menu">
				<a className="item add-list"><i className="plus icon"></i> Add</a>
			</div>
		);
	}

}

export default Menu;