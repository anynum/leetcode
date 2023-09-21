package com.anynum.demo.regex;

public class RegexTest {
//    public static void main(String[] args) {
////        String text2 = "*本产品不限流量，每日高速流量300MB，之后降速为128kbps <br>*支持热点分享 <br>*本产品覆盖的国家地区及网络运营商如下：";
//        String text2 = "<br>*支持热点分享 <br>*本产品覆盖的国家地区及网络运营商如下：<br>美国运营商为AT&T，网络为4G，APN：drei.at；<br>日本运营商为SoftBank，网络为4G，APN：plus.4g 用户名：plus 密码：4g；<br>韩国运营商为SKT，网络为4G，APN：internet；<br>越南运营商为Viettel，网络为3G/4G，APN：internet；<br>香港(中华人民共和国)运营商为3，网络为4G，APN：internet；<br>澳门(中华人民共和国)运营商为CTM，网络为3G/4G，APN：internet；<br>柬埔寨运营商为Metfone，网络为4G，APN：internet；<br>老挝运营商为Unitel，网络为3G/4G，APN：3gnet；<br>台湾(中华人民共和国)运营商为Chunghwa，网络为3G/4G，APN：internet；<br>马来西亚运营商为DiGi，网络为3G/4G，APN：internet；<br>澳大利亚运营商为Optus，网络为3G/4G，APN：mobiledata；<br>印度尼西亚运营商为XL，网络为3G/4G，APN：internet；<br>菲律宾运营商为SMART，网络为4G，APN：mobile.three.com.hk；<br>泰国运营商为Dtac，网络为4G，APN：internet；<br>新加坡运营商为SingTel，网络为3G/4G，APN：cmhk；<br>新西兰运营商为Vodafone，网络为3G/4G，APN：mobiledata；";
//
//        int i = text2.indexOf("网络运营商如下：");
//        System.out.println("i = " + i);
//        if (i != -1 && i + 12 < text2.length()) {
//            String substring = text2.substring(i + 12).replace("<br>", "\n");
//            System.out.println("substring = " + substring);
//        } else {
//            System.out.println("i = " + i);
//        }
//    }


    public static void main(String[] args) {
        String claimCode = "claimCode";
        String claimQrCodeUrl = "claimQrCodeUrl";
        String content = "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <style>\n" +
                "      html,body{\n" +
                "        font-size:14px;\n" +
                "      }\n" +
                "      .warp{\n" +
                "        max-width:750px;\n" +
                "        margin:0 auto;\n" +
                "        padding:30px 20px;\n" +
                "        min-height:100vh;\n" +
                "        background-color:#FFFFFF;\n" +
                "      }\n" +
                "      .QR-image img{\n" +
                "        width:100%;\n" +
                "        height:100%;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div class=\"warp\">'\n" +
                "      <p>尊敬的用户</p>\n" +
                "      <p>您已成功订购"+ 1 + "件商品，自取码为<b style=\"font-size:18px;\">" + claimCode + "</b>，请您到指定自提点取货，\n" +
                "        自提点列表：<a href=\"https://www.billionconnect.com/cs/pick/stations\">https://www.billionconnect.com/cs/pick/stations</a> ,节假日请关注自提点值班时间。\n" +
                "      </p>\n" +
                "      <p>取货时请您出示自提二维码：<a href=\"" +claimQrCodeUrl + "\">" + claimQrCodeUrl + "</a></p>\n" +
                "      <img src=\""+ claimQrCodeUrl +"\" style=\"width:300px;\"/>\n" +
                "      <img src=\"https://op-flow-public.oss-cn-hangzhou.aliyuncs.com/imgs/esim.png\" style=\"width:300px;\"/>\n" +
                "      <br>\n" +
                "      <br>\n" +
                "      <p> Dear Customer,</p>\n" +
                "      <p >You have purchased "+ 1 + "product(s). The pick-up code is <b style=\"font-size:18px;\">"+claimCode +" </b>.\n" +
                "        Please pick up the product(s) at the designated pick-up site.\n" +
                "        You can refer to <a href=\"https://www.billionconnect.com/cs/pick/stations\">https://www.billionconnect.com/cs/pick/stations</a> the list of the pick-up sites.\n" +
                "        If you need to pick up during holidays, it is recommended to check the holiday opening hours of the pick-up site before you go. The QR Code is needed when you pick up the product: \n" +
                "        <a href=\""+claimQrCodeUrl + "\">"+claimQrCodeUrl+"</a>\n" +
                "      </p>\n" +
                "      <img src=\""+claimQrCodeUrl+"\" style=\"width:300px;\"/>\n" +
                "      <img src=\"https://op-flow-public.oss-cn-hangzhou.aliyuncs.com/imgs/esim.png\" style=\"width:300px;\"/>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>";

        System.out.println("content = " + content);
    }
}
