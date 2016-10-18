-- 7) Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
-- com 10 registros (nao mostra null)
Select e.NomeEmpregado as empregado
	  ,de.NomeDepartamento as "departamento do empregado"
	  ,g.NomeEmpregado as gerente
	  ,dg.NomeDepartamento as "departamento do gerente"
From Empregado as e
Inner join Empregado as g
	On e.IDGerente = g.IDEmpregado
Inner join Departamento as de
	On e.IDDepartamento = de.IDDepartamento
Inner join Departamento as dg
	On g.IDDepartamento = dg.IDDepartamento;

-- com 15 registros (mostra null)
Select e.NomeEmpregado as empregado
	  ,(Select de.NomeDepartamento 
	    from Departamento as de
		where de.IDDepartamento = e.IDDepartamento) as "departamento do empregado"
	  ,(Select g.NomeEmpregado 
	    from Empregado as g 
		where g.IDEmpregado = e.IDGerente) as gerente
	  ,(Select dg.NomeDepartamento 
	    from Empregado as g, Departamento as dg
		where g.IDEmpregado = e.IDGerente
		and dg.IDDepartamento = g.IDDepartamento)
From Empregado as e;

-- outra forma de mostrar os nulos
Select e.NomeEmpregado as empregado
	  ,d.NomeDepartamento as "departamento do empregado"
	  ,g.NomeEmpregado as gerente
	  ,d.NomeDepartamento as "departamento do gerente"
From Empregado as e
left join Empregado as g
	On e.IDGerente = g.IDEmpregado
left join Departamento as d
	On e.IDDepartamento = d.IDDepartamento;



-- 8) Faça uma cópia da tabela Empregado e altere o salário de todos os empregados (Empregado) que
-- que o departamento fique na localidade de SAO PAULO, faça um reajuste de 14,5%.
Select *
Into EmpregadoCopia
From Empregado;

Update EmpregadoCopia
Set Salario = Salario + Salario*0.145
Where IDDepartamento IN (Select IDDepartamento
						 From Departamento
						 Where Localizacao = 'SAO PAULO')
go


-- 9) Liste a diferança que representará o reajuste aplicado no item anterior no somatório dos salários de 
-- todos os empregados.
Select sum(c.salario) as ValorAnterior , 
       sum(e.salario) as ValorNovo, 
     sum(e.salario) - sum(c.salario) as Diferenca
From Empregado as e, EmpregadoCopia as c
Where e.IDEmpregado = c.IDEmpregado;


-- 10) Liste o departamento com o empregado de maior salário.
-- exibindo os empregados
-- distinct nao é legal
Select /*distinct*/ NomeDepartamento, NomeEmpregado, Salario
From Departamento as d
Inner join Empregado as e
	On e.IDDepartamento = d.IDDepartamento
Where e.Salario = (Select max(Salario)
				   From Empregado
				   Where IDDepartamento IS NOT NULL);

-- exibindo somente o departamento
Select IDDepartamento, NomeDepartamento 
From   Departamento dep 
Where  exists (select 1 
               from   Empregado emp 
         Where  emp.IDDepartamento = dep.IDDepartamento 
         and    emp.Salario        = (select max(Salario) 
                                      from   empregado 
                      where  IDDepartamento is not null)
         );