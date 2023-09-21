package org.pdj.system.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.pdj.common.result.RCodeEnum;
import lombok.Data;

/**
 * 自定义全局异常类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthException extends Exception {

    private Integer code;

    private String message;
}
