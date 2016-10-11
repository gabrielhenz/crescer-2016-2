-- 1) Faça uma consulta (query) que retorne o nome dos empregados exibindo em ordem de admissão.
Select NomeEmpregado from Empregado order by DataAdmissao asc;

-- 2) Faça uma consulta que retorne o nome dos empregados e o salário anual,
-- onde o cargo seja Atendente ou que o salário anual seja inferior a R$18.500,00.
Select NomeEmpregado, Salario
From EmpregadoWhere 
Where Cargo like 'Atendente' 
	or Salario < 18500.00;
	
-- 3) Retornar o ID da cidade de Uberlândia.
Select IDCidade
From Cidade
Where Nome like 'Uberlândia';

-- 4) Exibir todas as cidades (ID e nome) do estado do Rio Grande do Sul.
Select IDCidade, Nome
From Cidade
Where UF like 'RS';

