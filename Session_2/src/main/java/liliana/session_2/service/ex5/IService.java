package liliana.session_2.service.ex5;

public interface IService<T,E,O> {
    // them mới
    void save (T t);
    // cập nhật entity instance đã tồn tại
    void update (T t);
    // tìm entity theo ID
    O findById (E id);
    // xóa một entity instance theo ID
    void delete (E id);
}
