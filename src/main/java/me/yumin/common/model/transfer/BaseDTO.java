package me.yumin.common.model.transfer;

import lombok.Getter;
import lombok.Setter;
import me.yumin.common.model.BaseModel;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-15
 */
public abstract class BaseDTO extends BaseModel {
    private static final long serialVersionUID = 2323773420282981722L;

    @Getter
    @Setter
    private int rowVersion = 0; // 行版本号
}
