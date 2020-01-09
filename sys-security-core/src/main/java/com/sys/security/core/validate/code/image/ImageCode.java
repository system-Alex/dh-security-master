/**
 * 
 */
package com.sys.security.core.validate.code.image;


import com.sys.security.core.validate.code.ValidateCode;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @author alex
 *
 */
@Getter
@Setter
public class ImageCode extends ValidateCode implements Serializable {


	private static final long serialVersionUID = 2755593916496658203L;
	private BufferedImage image;
	
	public ImageCode(BufferedImage image, String code, int expireIn){
		super(code, expireIn);
		this.image = image;
	}
	
	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
		super(code, expireTime);
		this.image = image;
	}


}
