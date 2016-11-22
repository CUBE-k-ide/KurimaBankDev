package cubesystem.kurimabank.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sayaka-kurima on 2016/09/13.
 */
public class Info2 {
        public String list1 = "";
        public String list2 = "";
        public String list3 = "";

        private static Info _instance = new Info();
        public static Info getInstance(){
            return _instance;
        }
        /**
         * その他の場合、詳細情報が入力されているかどうかチェックする
         */
        //public static boolean isBlank(String detail) {
        //return (str == null || Info.trimSpace(str.trim()).length() == 0);
        //}
        // 全角スペース対応用
        private static String trimSpace(String orgStr) {
            char[] value = orgStr.toCharArray();
            int len = value.length;
            int st = 0;
            char[] val = value;

            while ((st < len) && (val[st] <= ' ' || val[st] == '　')) {
                st++;
            }
            while ((st < len) && (val[len - 1] <= ' ' || val[len - 1] == '　')) {
                len--;
            }

            return ((st>0) || (len<value.length)) ? orgStr.substring(st,len):orgStr;
        }
    }

