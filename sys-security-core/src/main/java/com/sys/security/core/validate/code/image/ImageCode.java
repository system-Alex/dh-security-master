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
 * ImageCode对象没有实现Serializable 接口，
 * 且属性 --- BufferedImage对象，也没有实现Serializable 接口，因此将该对象存到redis里时会报出序列化错误。
 *
 * 经过分析可知，我们只需要把验证码和过期时间放到redis里就行了，因为图形验证码验证的是验证码，不是图形
 * 所以没必要把BufferedImage对象存到session和redis里。
 */
@Getter
@Setter
public class ImageCode extends ValidateCode implements Serializable {

    private static final long serialVersionUID = -6087517175974386523L;

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }


}
