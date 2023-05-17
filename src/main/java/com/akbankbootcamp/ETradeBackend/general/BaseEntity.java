package com.akbankbootcamp.ETradeBackend.general;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable, BaseEntityModel {

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
    public BaseAdditionalFields getBaseAdditionalFields() {
        return baseAdditionalFields;
    }

    public void setBaseAdditionalFields(BaseAdditionalFields baseAdditionalFields) {
        this.baseAdditionalFields = baseAdditionalFields;
    }

}
