package com.enroy.easy.job.admin.biz;

import java.util.HashMap;
import java.util.Map;

/**
 * 存放在token中的信息
 *
 * @author zhuchao
 */
public class TokenData {
  protected static final String KEY_ISSUED_AT = "iat";
  protected static final String KEY_ISSUER = "iss";
  protected static final String KEY_SUBJECT = "sub";
  protected static final String KEY_AUDIENCE = "aud";
  protected static final String KEY_EXPIRE = "exp";

  public static final String USER_ID = "user_id";

  private Map<String, Object> map = new HashMap();

  public TokenData() {
  }

  public TokenData(Map<String, Object> map) {
    this.map = map;
  }

  public Map getMap() {
    return map;
  }

  public TokenData put(String key, Object value) {
    this.map.put(key, value);
    return this;
  }

  public TokenData putAll(Map map) {
    this.map.putAll(map);
    return this;
  }

  public Object get(String key) {
    return this.map.get(key);
  }

  /**
   * 签发时间，即 RFC7519中的iat
   */
  public Integer getIssuedAt() {
    return (Integer) map.get(KEY_ISSUED_AT);
  }

  public Integer getExpire() {
    return (Integer) map.get(KEY_EXPIRE);
  }

  public String toString() {
    return map.toString();
  }

  public String getToString(String key) {
    return (String) this.map.get(key);
  }
}
