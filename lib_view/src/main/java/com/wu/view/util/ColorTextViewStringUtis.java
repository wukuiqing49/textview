package com.wu.view.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wkq
 * @date 2022年04月19日 14:43
 * @des
 */

public class ColorTextViewStringUtis {

   static public Matcher getMatcher(String keywords){
      return Pattern.compile("[^|\\?*<\":>+\\[\\]/']+").matcher(keywords);
    }

}
