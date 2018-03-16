package me.model;
import java.util.List;
import java.util.Optional;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

public interface Model{
   /* // CycleBaseAddress表的成员部分
    List<CycleBaseAddress> CycleBaseAddressGetAll();                        // 得到所有BaseAddress对象组成的链表
    Optional<CycleBaseAddress> CycleBaseAddressGet(String CycleUserID);           // 根据userID查询BaseAddress
    void CycleBaseAddressCreate(String CycleUserID, int Cycleba);                 // 根据userID删除BaseAddress
    void CycleBaseAddressDelete(String CycleUserID);                           // 根据userID删除BaseAddress
    void CycleBaseAddressUpdate(String CycleUserID, int CyclenewBA);              // 根据userID更新BaseAddress
    boolean CycleBaseAddressExist(String CycleUserID);                         // 根据userID检查BaseAddress是否存在*/

    // CyclePointInfo表的成员部分

    void CyclePointInfoCreate(String CycleUserI,String date,JSONArray CyclePointMessage);
    CyclePointInfo CyclePointInfoGet(String CycleUserID,String date);
    void CyclePointInfoDelete(String CycleUserID, String date);

    // CycleGroupingSituation表的成员部分
    void CycleGroupingSituationCreate(String id,String date,JSONArray GroupMessage);
    List<CycleGroupingSituation> CycleGroupingSituationGet(String CycleUserID);
    void CycleGroupingSituationDelete(String CycleUserID, String date);

    //CycleUserInfo表的成员部分。
    CycleUserInfo CycleUserInfoGetUserID(String CyclelogInType,String CycleLogInID,JSON Messages);
    CycleUserInfo CycleUserInfoGetUserMessage(String CycleUserID);

    //解决微博的粉丝的增删操作
    List<String> CycleGetLike(String CycleUserID);
    List<String> CycleGetFan(String CycleUserID);
    void CycleAddLike(String CycleUserID, String CyclelikeID);
    void CycleDelLike(String CycleUserID, String CyclelikeID);

    //ouath 安全验证操作
    List <CycleKeyEntity> CycleGetAccessToken(String CycleUserID);
    boolean CycleIsAccessToken(String AccessToken);
}
