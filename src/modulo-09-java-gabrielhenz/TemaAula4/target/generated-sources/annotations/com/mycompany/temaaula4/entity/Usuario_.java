package com.mycompany.temaaula4.entity;

import com.mycompany.temaaula4.entity.Servico;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T15:51:23")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Servico> servicoList;
    public static volatile SingularAttribute<Usuario, String> dsEmail;
    public static volatile SingularAttribute<Usuario, String> dsUserName;
    public static volatile SingularAttribute<Usuario, BigDecimal> idUsuario;
    public static volatile SingularAttribute<Usuario, String> dsSituacao;
    public static volatile SingularAttribute<Usuario, String> nmUsuario;
    public static volatile SingularAttribute<Usuario, String> dsSenha;
    public static volatile SingularAttribute<Usuario, String> tpPermissao;

}