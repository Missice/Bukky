package me.model;
import lombok.Data;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

@Data
public class CycleGroupingSituation{
    String CycleUserId;
    String CycleStartdate;
    JSONArray GroupMessage;//直接用json来每一个Group的数据
    public CycleGroupingSituation(String UsingID,String cycleStartdate,JSONArray groupMessage){
        CycleUserId = UsingID;
        CycleStartdate=cycleStartdate;
        GroupMessage=groupMessage;

    };
}
/*String Cycledate;
    int CyclebeginIndex;
    int CycleendIndex;
    int CycleallTime;
    double CycleallLength;
    int Cyclemood;
    int Cycleweather;
    int Cycleroad;*/
