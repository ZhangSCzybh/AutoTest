package com.yolocast.qa.zsc.Constant;


import cn.hutool.json.JSONObject;
import com.yolocast.qa.zsc.utils.ErrorEnum;
import com.yolocast.qa.zsc.BaseTest;
import org.testng.Assert;

public class CommonUtil {


    /**
     *
     * @author zhangsc
     * @date 2022/4/26 下午3:55
     * @param result
     * @param params
     * @param Url
     * @param scene
     */
    public static void assertAvailable(JSONObject result, String params, String Url, String scene){
        //状态码异常判断
        try {
            if (result.isEmpty() || result == null) {
                String wrong = String.format(Config.availableInfo, Config.Pro, scene, ErrorEnum.ISFAILED.getMsg(), Url, params, result);
                BaseTest.caveat(wrong);
                Assert.fail(wrong);
            }
            int code = (int) result.get("code");
            if (code != 200) {
                String wrong = String.format(Config.availableInfo, Config.Pro, scene, ErrorEnum.ISCODE.getMsg(), Url, params, result);
                BaseTest.caveat(wrong);
                Assert.fail(wrong);
            }
            if (!result.get("success").toString().equals("true")) {
                String wrong = String.format(Config.availableInfo, Config.Pro, scene, ErrorEnum.ISNOSUCCESS.getMsg(), Url, params, result);
                BaseTest.caveat(wrong);
                Assert.fail(wrong);
            }
        } catch (Exception e) {
            Assert.fail(String.format(Config.availableInfo, Config.Pro, scene, ErrorEnum.ISFAILED.getMsg(), Url, params, result + "\n" + e.getMessage()));
        }


    }

}
