package Model;

import java.util.HashMap;
import java.util.Map;

public class RepositorioGenerico<T> {
    private Map<String, T> entidadMap = new HashMap<>();
    public void agregar(String id, T entidad) {
        entidadMap.put(id, entidad);
    }
    public T obtener(String id) {
        return entidadMap.get(id);
    }
    public boolean existe (String id) {
        return entidadMap.containsKey(id);
    }
}
