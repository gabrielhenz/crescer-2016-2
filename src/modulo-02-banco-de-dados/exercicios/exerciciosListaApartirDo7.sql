-- 7) Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
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
/*Select e.NomeEmpregado as empregado
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
From Empregado as e;*/


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


-- 9)