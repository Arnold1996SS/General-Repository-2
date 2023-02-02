package misInterfaces;

import java.util.ArrayList;

public interface Crud<T> {
    public boolean agregar(T t);
    public boolean eliminar(String codigo);
    public boolean editar(T t);
    public ArrayList<T> listarTodos();
    public T listarUno(String codigo);
}
