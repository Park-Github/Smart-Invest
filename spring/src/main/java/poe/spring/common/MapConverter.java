package poe.spring.common;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MapConverter<T> {

    public String snakeCaseConverter(String camelCase) {
        String snakeCase = camelCase
                .replaceAll("([a-z])([A-Z]+)", "$1_$2")
                .toLowerCase();
        return snakeCase;
    }

    public Map<String, Object> convertToMap(T dto) {
        Map<String, Object> data = new HashMap<>();
        Field[] fields = dto.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(dto) != null)
                    data.put(snakeCaseConverter(field.getName()), field.get(dto));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public  Map<String, Object> convertListToMap(List<T> dto, String keyName) {
        Map<String, Object> data = new HashMap<>();
        data.put(snakeCaseConverter(keyName), dto);
        return data;
    }


}
