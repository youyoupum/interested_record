package com.happyrecord.servecenter.interestedrecordserve.utils;

public class BaseContext {
//  public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
  public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

  public static void setCurrentId(Integer id) {
    threadLocal.set(id);
  }

//  public static Long getCurrentId() {
//    return threadLocal.get();
//  }
  public static Integer getCurrentId() {
    return threadLocal.get();
  }



  public static void removeCurrentId() {
    threadLocal.remove();
  }

}
