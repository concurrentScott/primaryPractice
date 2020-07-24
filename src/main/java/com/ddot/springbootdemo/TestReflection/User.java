package com.ddot.springbootdemo.TestReflection;

public class User {

  private String userId;
  private String userName;
  private Integer age;



  public User(String userId, String userName, Integer age) {
    this.userId = userId;
    this.userName = userName;
    this.age = age;
  }

  public User() {

  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getUserNames(String abu) {
    return userName;
  }


  @Override
  public String toString() {
    return "User{" +
      "userId='" + userId + '\'' +
      ", userName='" + userName + '\'' +
      ", age=" + age +
      '}';
  }
}

class SonUser extends User{
  private String sonId;

  public SonUser(String sonId) {
    super(sonId,"1",1);
    this.sonId = sonId;
  }
  public SonUser() {
    super();
  }

  @Override
  public String toString() {
    return "SonUser{" +
            "sonId='" + sonId + '\'' +
            '}';
  }
}

