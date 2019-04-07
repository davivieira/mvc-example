import React from 'react';
import Lists from './Lists';
import Menu from './Menu';
import ListService from '../api/ListService';
import './App.css';

class App extends React.Component {
	state = { lists: [] };

	componentDidMount = async () => {
		const response = await ListService.getLists();
		this.setState({ lists: response.data.response });
	};

	onAddList = async () => {
		const response = await ListService.createList({
			items: [],
			name: "New List",
			progress: 0
		});

		this.setState(prevState => ({lists: [...prevState.lists, response.data.response]}));
	};

	onDeleteList = (id) => {
		ListService.deleteList(id).then(() => {
			ListService.getLists().then(response => {
				this.setState({ lists: response.data.response });
			});
		});
	};

	render() {
		return (
			<div className="app">
				<Menu onAddList={this.onAddList}/>

				<div className="ui grid">
						<Lists onDeleteList={this.onDeleteList} lists={this.state.lists}/>
				</div>
			</div>
		);
	}
}

export default App;