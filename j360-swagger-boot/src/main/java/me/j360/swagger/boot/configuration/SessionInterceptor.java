package me.j360.swagger.boot.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import me.j360.swagger.boot.helper.AntPathMatcher;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: min_xu
 * @date: 2018/1/18 上午11:41
 * 说明：定义拦截器
 */

@Slf4j
public class SessionInterceptor implements HandlerInterceptor {


    public SessionInterceptor(String secret) {
        algorithm = Algorithm.HMAC256(secret);
        pathMatcher = new AntPathMatcher();
    }

    private Algorithm algorithm;
    private AntPathMatcher pathMatcher;


    private static final String Authorization = "Authorization";
    //Auth 定义jwt内容
    public static final String JWT_AUD_GUEST = "guest";
    public static final String JWT_AUD_USET = "user";
    public static final String JWT_ISSUER = "J360";

    //GUEST对应的访问URL
    public static final String[] JWT_VTM = {"/api/biz/**"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String authorization = request.getHeader(Authorization);
        if (StringUtils.isEmpty(authorization)) {
            throw new RuntimeException("401");
        }
        if(StringUtils.isEmpty(authorization) || ! authorization.startsWith("Bearer ")){
            throw new RuntimeException("401");
        }
        String token = authorization.substring(7);
        //sign check
        String sub;
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(JWT_ISSUER)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            sub = jwt.getSubject();
            List<String> aud = jwt.getAudience();
            boolean access = false;
            if (aud.contains(JWT_AUD_GUEST)) {
                //url check
                for (String GUEST : JWT_VTM) {
                    if (pathMatcher.match(GUEST, request.getRequestURI())) {
                        access = true;
                    }
                }
            } else if (aud.contains(JWT_AUD_USET)) {
                access = true;

                //check user status
            }
            if (!access) {
                throw new RuntimeException("403");
            }
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            throw new RuntimeException("403");
        }
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
