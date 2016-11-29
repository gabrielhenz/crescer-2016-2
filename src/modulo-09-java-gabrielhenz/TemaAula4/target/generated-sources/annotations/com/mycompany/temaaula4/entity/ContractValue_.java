package com.mycompany.temaaula4.entity;

import com.mycompany.temaaula4.entity.Contract;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T15:51:23")
@StaticMetamodel(ContractValue.class)
public class ContractValue_ { 

    public static volatile SingularAttribute<ContractValue, String> dsPeriodicity;
    public static volatile SingularAttribute<ContractValue, BigDecimal> vlMonthlyUsd;
    public static volatile SingularAttribute<ContractValue, String> dsCoin;
    public static volatile SingularAttribute<ContractValue, BigDecimal> idContractValue;
    public static volatile SingularAttribute<ContractValue, Contract> contractIdContract;
    public static volatile SingularAttribute<ContractValue, BigDecimal> vlAmountContractValue;

}