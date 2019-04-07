import axios from 'axios';

const configuredApi = axios.create({
	//baseURL: window.location.origin
	baseURL: 'http://localhost:8080'
});

const ListService = {
	getLists: () => {
		return configuredApi.get('/list/fetch');
	},
	createList: (list) => {
		return configuredApi.post('/list/create', list);
	},
	deleteList: (id) => {
		return configuredApi.delete(`/list/delete/${id}`);
	}
};

export default ListService;