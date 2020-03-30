package com.enroy.easy.job.admin.biz;

/**
 * 存放Token数据，供线程内共享使用
 *
 * @author zhuchao
 */
public class TokenContext {

  private static final ThreadLocal<TokenData> CONTEXT = new ThreadLocal<TokenData>();

  public static void set(TokenData data) {
    CONTEXT.set(data);
  }

  public static TokenData get() {
    return CONTEXT.get();
  }

  public static void remove() {
    CONTEXT.remove();
  }
}
