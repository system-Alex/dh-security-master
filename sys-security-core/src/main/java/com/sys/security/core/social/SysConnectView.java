/**
 *
 */
package com.sys.security.core.social;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author alex
 * 由于微信，QQ，微博等解绑和绑定都想用这个视图，但providerId不可能一样
 * 所以这里不能直接用@Component注解将其写死
 */
public class SysConnectView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        response.setContentType("text/html;charset=UTF-8");
        //如果map（Model对象）里有Connection对象，则表示绑定，否则表示解绑
        if (model.get("connection") == null) {
            response.getWriter().write("<h3>解绑成功</h3>");
        } else {
            response.getWriter().write("<h3>绑定成功</h3>");
        }

    }

}
