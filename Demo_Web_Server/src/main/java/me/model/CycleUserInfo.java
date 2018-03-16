package me.model;
import com.sun.javafx.beans.IDProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import lombok.Data;
import net.sf.json.JSON;

@Data
public class CycleUserInfo{
  @Id @GeneratedValue
  String CycleUserId;  //维持的用户的唯一标识
  String CyclelogInType; //登录的类型
  String CyclelogInID; //登陆的用户的名字
  JSON  CycleUserMessage;//用来存储用户的ID
  public CycleUserInfo(String id,String type,String logInID, JSON Message){
    CycleUserId = id;
    CyclelogInType=type;
    CyclelogInID=logInID;
    CycleUserMessage=Message;
  }

  public CycleUserInfo() {
  }
}
  /*
   String CyclelogInName;   //登陆的用户的ID
  String CyclelogInUserhead; //登陆的用户的URL
*/



