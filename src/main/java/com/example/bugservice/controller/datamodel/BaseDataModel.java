package com.example.bugservice.controller.datamodel;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public class BaseDataModel<T extends Serializable> implements Serializable {

    private T id;

    public BaseDataModel() {
    }

}
