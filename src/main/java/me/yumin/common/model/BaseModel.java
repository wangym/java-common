package me.yumin.common.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-06
 */
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = -116870946473544967L;

    @Setter
    @Getter
    private Integer bizType;
}
