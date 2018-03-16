package me.model;

import lombok.Data;

@Data
public class CycleFan{
    String CycleUserId;                           // 用户的ID
    int Cycleaction;  //进行的操作，是0删除还是1增加
    String CyclelikeId;  //关注的对象的ID，在这里CycleusrID就是CycleFan的粉丝
    int flag;  //1为数据存在，0为假删操作，如果为
}