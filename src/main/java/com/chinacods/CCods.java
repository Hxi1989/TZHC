package com.chinacods;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hx
 * @version 1.0
 * @date 2021/5/7 11:40
 */
public class CCods {

    public static void main(String[] args) {
        CCods cc = new CCods();
//        cc.getByOrgSocialNbr("",1);
        System.out.println("登记管理部门："+cc.getByCode("91430105183767369W",1));
        System.out.println("机构类别："+cc.getByCode("91430105183767369W",2));
    }

    /* 根据统一社会信用代码获取登记管理部门或机构类别
	 *
     * @param orgSocialNbr 统一社会信用代码
	 * @param num 1：登记管理部门；2：机构类别
	 * @return
             */
    public String getByCode(String orgSocialNbr, int num) {
        String result = "";
        if ("".equals(ValidateUtil.UnifiedSocialCreditCode(orgSocialNbr))) {
            Map<String, Map<String, String>> map = new HashMap<String, Map<String,String>>();
            Map<String, String> organ = new HashMap<String, String>();
            organ.put("0", "机构编制");
            organ.put("1", "机关");
            organ.put("2", "事业单位");
            organ.put("3", "中央编办直接管理机构编制的群众团体");
            organ.put("9", "其他");
            map.put("1", organ);
            Map<String, String> diplomacy = new HashMap<String, String>();
            diplomacy.put("0", "外交");
            diplomacy.put("1", "外国常住新闻机构");
            diplomacy.put("9", "其他");
            map.put("2", diplomacy);
            Map<String, String> judicial = new HashMap<String, String>();
            judicial.put("0", "司法行政");
            judicial.put("1", "律师执业机构");
            judicial.put("2", "公证处");
            judicial.put("3", "基层法律服务所");
            judicial.put("4", "司法鉴定机构");
            judicial.put("5", "仲裁委员会");
            judicial.put("9", "其他");
            map.put("3", judicial);
            Map<String, String> culture = new HashMap<String, String>();
            culture.put("0", "文化");
            culture.put("1", "外国在华文化中心");
            culture.put("9", "其他");
            map.put("4", culture);
            Map<String, String> civil = new HashMap<String, String>();
            civil.put("0", "民政");
            civil.put("1", "社会团体");
            civil.put("2", "民办非企业单位");
            civil.put("3", "基金会");
            civil.put("9", "其他");
            map.put("5", civil);
            Map<String, String> tour = new HashMap<String, String>();
            tour.put("0", "旅游");
            tour.put("1", "外国旅游部门常驻代表机构");
            tour.put("2", "港澳台地区旅游部门常驻内地（大陆）代表机构");
            tour.put("9", "其他");
            map.put("6", tour);
            Map<String, String> religion = new HashMap<String, String>();
            religion.put("0", "宗教");
            religion.put("1", "宗教活动场所");
            religion.put("2", "宗教院校");
            religion.put("9", "其他");
            map.put("7", religion);
            Map<String, String> tradeUnion = new HashMap<String, String>();
            tradeUnion.put("0", "工会");
            tradeUnion.put("1", "基层工会");
            tradeUnion.put("9", "其他");
            map.put("8", tradeUnion);
            Map<String, String> business = new HashMap<String, String>();
            business.put("0", "工商");
            business.put("1", "企业");
            business.put("2", "个体工商户");
            business.put("3", "农民专业合作社");
            map.put("9", business);
            Map<String, String> CMC = new HashMap<String, String>();
            CMC.put("0", "中央军委改革和编制办公室");
            CMC.put("1", "军队事业单位");
            CMC.put("9", "其他");
            map.put("A", CMC);
            Map<String, String> agriculture = new HashMap<String, String>();
            agriculture.put("0", "农业");
            agriculture.put("1", "组级集体经济组织");
            agriculture.put("2", "村级集体经济组织");
            agriculture.put("3", "乡镇级集体经济组织");
            agriculture.put("9", "其他");
            map.put("N", agriculture);
            Map<String, String> other = new HashMap<String, String>();
            other.put("0", "其他");
            other.put("1", "其他");
            map.put("Y", other);

            if (num == 1) {
                result = map.get(orgSocialNbr.charAt(0) + "").get("0");
            } else {
                result = map.get(orgSocialNbr.charAt(0) + "").get(orgSocialNbr.charAt(1) + "");
            }

        }
        return result;
    }

}
