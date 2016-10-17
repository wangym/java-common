package me.yumin.common.model.transfer;

import lombok.Getter;
import lombok.Setter;
import me.yumin.common.model.BaseModel;

import java.util.Date;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-15
 */
public abstract class BaseDTO extends BaseModel {
    private static final long serialVersionUID = 2323773420282981722L;

    @Setter
    @Getter
    private Date gmtCreate; // 首次创建

    @Setter
    @Getter
    private Date gmtModified; // 最后修改

    @Getter
    @Setter
    private Integer rowVersion; // 行版本号
}
