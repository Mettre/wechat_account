package com.mettre.account.jwt;

import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mettre.account.enum_.ResultEnum;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.Key;
import java.util.Date;

public class JwtHelper {

    private static Logger logger = LoggerFactory.getLogger(JwtHelper.class);

    /**
     * 校验Token
     *
     * @param jwt
     * @param httpRequest
     * @return
     */
//    https://blog.csdn.net/dushiwodecuo/article/details/78180701
    public static int checkToken(String jwt, HttpServletRequest httpRequest) {
        if (!StringUtils.isBlank(jwt)) {
            if (jwt.split("\\.").length == 3) {
                logger.info("jwt:" + jwt);
                String[] split = jwt.split("\\.");
                String content = split[1];
                String s = Base64Codec.BASE64URL.decodeToString(content);
                logger.info("s:" + s);
                String sign = split[2];
                logger.info("sign:" + sign);
                try {
                    TokenObject tokenObject = new ObjectMapper().readValue(s, TokenObject.class);
                    long nowMillis = System.currentTimeMillis();
                    Date now = new Date(nowMillis);
                    long expiresSecond = (long) jsonObject1.get("expiresSecond");
                } catch (IOException e) {
                    e.printStackTrace();
                }



                //判断是否过期
                if (now.getTime() > expiresSecond)
                    return 2;


                TokenObject o = (TokenObject) JSONObject.toBean(jsonObject1, TokenObject.class);
                if (o != null) {
                    String project = o.getProject();
                    if (!StaticInfo.PROJECT.equals(project))
                        return 0;
                }
                String jwtByStr = createJWTByObj(o);
                String s2 = jwtByStr.split("\\.")[2];
                logger.info("s2:" + s2);
                if (sign.equals(s2)) {
                    return 1;
                } else
                    return 0;
            }
        }
        return 0;
    }

    /**
     * 获取用户id
     *
     * @param jwt
     * @return
     */
    public static int getIdByJWT(String jwt) {
        if (!StringUtils.isBlank(jwt)) {
            if (jwt.split("\\.").length == 3) {
                logger.info("jwt:" + jwt);
                String[] split = jwt.split("\\.");
                String content = split[1];
                String s = Base64Codec.BASE64URL.decodeToString(content);
                JSONObject jsonObject1 = JSONObject.fromObject(s);
                TokenObject o = (TokenObject) JSONObject.toBean(jsonObject1, TokenObject.class);
                return o.getaId();
            }
        }
        return 0;
    }

    /**
     * 获取客户信息
     *
     * @param request
     * @return
     * @throws CustomException
     */
    public static int getIdByRequest(HttpServletRequest request) throws CustomException {
        int i = 0;
        String auth = request.getHeader("Authorization");
        if ((auth != null) && (auth.length() > 6)) {
            String HeadStr = auth.substring(0, 5).toLowerCase();
            if (HeadStr.compareTo("basic") == 0) {
                auth = auth.substring(6, auth.length());
                i = JwtHelper.getIdByJWT(auth);
            }
        }
        if (i == 0)
            throw new CustomException(ResultEnum.PERMISSION_DENIED);
        return i;
    }

    public static String createJWTByObj(TokenObject tokenObject) {
        String jsonStr = "";
        try {
            jsonStr = new ObjectMapper().writeValueAsString(tokenObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(tokenObject.getBase64Secret());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setPayload(jsonStr)
                .signWith(signatureAlgorithm, signingKey);

        //生成JWT
        return builder.compact();
    }
}
