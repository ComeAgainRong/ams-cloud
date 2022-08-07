package com.ams.common.constan;

/**
 * @ClassName : { GlobalConastants }
 * @Author : {whisper}
 * @Date : {Created in 15:30 2022/1/19}
 */
public interface GlobalConstants {

    String URL_PERM_ROLES_KEY = "system:perm_roles_rule:url:";
    String ROLE_SELECT="roleLists";
    Integer STATUS_ON=1;
    Integer STATUS_OFF=0;

    //user 默认密码
    String USER_DEFAULT_PASSWORD="123456";
    Long ROOT_MENU_ID = -1L;
    String ADMIN_URL_PERM = "%s:/%s%s";
}
