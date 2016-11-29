package com.mycompany.temaaula4.entity;

import com.mycompany.temaaula4.entity.Client;
import com.mycompany.temaaula4.entity.ContractValue;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T15:51:23")
@StaticMetamodel(Contract.class)
public class Contract_ { 

    public static volatile SingularAttribute<Contract, String> nmContract;
    public static volatile SingularAttribute<Contract, Client> clientIdClient;
    public static volatile SingularAttribute<Contract, ContractValue> contractValue;
    public static volatile SingularAttribute<Contract, String> dsState;
    public static volatile SingularAttribute<Contract, BigDecimal> idContract;
    public static volatile SingularAttribute<Contract, String> dsDescription;
    public static volatile SingularAttribute<Contract, String> dsWebsite;

}