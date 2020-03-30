package com.enroy.easy.job.admin.biz;

import lombok.Data;

/**
 * @author zhuchao
 */
@Data
public class TokenProps {
  /** cookie的名字 */
  private static final String DEFAULT_COOKIE_NAME = "_rpg_";
  /** 过期时间，单位:s */
  private int expiresIn = 30 * 60;
  /** 刷新时间，单位：s */
  private int refreshIn = 10 * 60;
  /** 签名用的私钥 */
  private String secret;
  /** 存放的cookie名 */
  private String cookieName = DEFAULT_COOKIE_NAME;

}
