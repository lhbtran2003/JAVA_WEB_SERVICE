package liliana.session_6.service;

import liliana.session_6.dto.response.DataResponse;

import java.util.List;

public interface GenericService<T,E, U, A> {
    DataResponse<T> create(A request);
    DataResponse<T> update(E id, U request);
    void delete(E id);
    DataResponse<T> findById(E id);
   DataResponse<List<T>>findAll();
}
