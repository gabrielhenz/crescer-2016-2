package com.mycompany.temaaula4.entity;

import com.mycompany.temaaula4.entity.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T15:51:23")
@StaticMetamodel(Servico.class)
public class Servico_ { 

    public static volatile SingularAttribute<Servico, Usuario> usuarioIdUsuario;
    public static volatile SingularAttribute<Servico, String> dsDescricao;
    public static volatile SingularAttribute<Servico, String> dsPeriodicidade;
    public static volatile SingularAttribute<Servico, String> dsSimboloMoeda;
    public static volatile SingularAttribute<Servico, String> nmServico;
    public static volatile SingularAttribute<Servico, BigDecimal> idServico;
    public static volatile SingularAttribute<Servico, BigDecimal> vlTotalServico;
    public static volatile SingularAttribute<Servico, String> dsSituacao;
    public static volatile SingularAttribute<Servico, String> dsWebsite;
    public static volatile SingularAttribute<Servico, BigDecimal> vlMensalUsd;

}