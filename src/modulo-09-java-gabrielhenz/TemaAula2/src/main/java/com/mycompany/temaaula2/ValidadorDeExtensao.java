/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula2;

//código do site: 
//http://www.mkyong.com/regular-expressions/how-to-validate-image-file-extension-with-regular-expression/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorDeExtensao {
    
   private Pattern pattern;
   private Matcher matcher;

   private static final String EXTENSION_PATTERN =
                "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|csv|txt))$)";

   public ValidadorDeExtensao(){
	  pattern = Pattern.compile(EXTENSION_PATTERN);
   }

   /**
   * Validate image with regular expression
   * @param image image for validation
   * @return true valid image, false invalid image
   */
   public boolean validar(final String path){

	  matcher = pattern.matcher(path);
	  return matcher.matches();

   }

}
