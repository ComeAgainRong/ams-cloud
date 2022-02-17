package com.ams.auth.comm.enums;

import lombok.Getter;

/**
 * @ClassName : { PasswordEncoderTypeEnum }
 * @Author : {whisper}
 * @Date : {Created in 15:42 2022/1/29}
 */
public enum PasswordEncoderTypeEnum {

    BCRYPT("{bcrypt}","BCRYPT加密"),
    NOOP("{noop}","无加密明文");

    @Getter
    private String prefix;

    PasswordEncoderTypeEnum(String prefix, String desc){
        this.prefix=prefix;
    }
}
