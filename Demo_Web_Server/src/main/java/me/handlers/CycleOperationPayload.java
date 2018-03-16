package me.handlers;

import lombok.Data;

@Data
public class CycleOperationPayload {
    private String name;
    private String status;
    public CycleOperationPayload(String name,String status){
        this.name=name;
        this.status=status;
    }
}
