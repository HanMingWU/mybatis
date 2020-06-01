package fun.hanmingwu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuki
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    private int id;
    private String name;
    private Teacher teacher;
}
