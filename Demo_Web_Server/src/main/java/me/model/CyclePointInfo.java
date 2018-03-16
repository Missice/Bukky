package me.model;
import lombok.Data;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

@Data
public class CyclePointInfo{
    String CycleUserId;                   // 用户的ID
    String CycleStartDate;   //开始的时间
    JSONArray CyclePointMessage;  //直接存储传进来的信息
   public CyclePointInfo(String id, String date,JSONArray Message){
        CycleUserId=id;
       CycleStartDate=date;
        CyclePointMessage=Message;
    }
}

    /*
    int CyclekmFlag;                   // 对应 tinyint
    double Cyclealtitude;              // 海拔高度
    double Cyclelongitude;             // 经度
    double Cyclelatitude;              // 纬度
    String Cycletimestamp;             // 2017-01-01 11:11:11*/
