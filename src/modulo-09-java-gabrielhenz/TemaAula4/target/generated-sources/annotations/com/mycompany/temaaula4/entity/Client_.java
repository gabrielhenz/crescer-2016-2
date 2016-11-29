package com.mycompany.temaaula4.entity;

import com.mycompany.temaaula4.entity.Contract;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T15:51:23")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, BigDecimal> idClient;
    public static volatile SingularAttribute<Client, String> dsEmail;
    public static volatile SingularAttribute<Client, String> dsState;
    public static volatile SingularAttribute<Client, String> dsUserName;
    public static volatile ListAttribute<Client, Contract> contractList;
    public static volatile SingularAttribute<Client, String> dsPassword;
    public static volatile SingularAttribute<Client, String> dsPreferredCoin;
    public static volatile SingularAttribute<Client, String> nmClient;
    public static volatile SingularAttribute<Client, String> tpPermission;

}