package me.model;

import lombok.Data;

@Data
public class CycleBaseAddress{
    String CycleUserID;                           // 用户的ID
    int CycleBaseAddress;                   // 用户的基址
    int Flag;  //1为数据存在，0为假删操作，如果为0
}