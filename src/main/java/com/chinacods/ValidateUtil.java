package com.chinacods;

/**
 * @author hx
 * @version 1.0
 * @date 2021/5/7 11:53
 */
public class ValidateUtil {
    public static String UnifiedSocialCreditCode(String orgSocialNbr) {
        if(orgSocialNbr.length()<18){
            return "统一社会信用代码不正确";
        }else{
            return "";
        }
    }
}
