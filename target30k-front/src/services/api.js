import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api/earnings',
});

export const earningService = {
  getAll: () => api.get(''),
  create: (data) => api.post('', data),
  delete: (id) => api.delete(`/${id}`),
};