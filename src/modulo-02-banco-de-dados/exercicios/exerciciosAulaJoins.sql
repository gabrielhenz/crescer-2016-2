-- 1) Faça uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982
-- Exibir também o total de meses de trabalho até a data de 31/12/2000.
select nomeempregado, datediff(month, dataadmissao, '2000/12/31') as "total meses trabalhados até 31/12/200"
from empregado
where dataadmissao between '1980/05/01' and '1982/01/20';

-- 2) Qual o cargo (tabela empregado) tem mais empregados?
select top(1) with ties cargo as "cargo com mais empregados"
from empregado
group by cargo
order by "cargo com mais empregados" desc;
--offset 0 rows fetch next 1 rows only
--with ties: com empates

-- 3) Liste a quantidade de cidades agrupando por UF. Quantas cidades cada estado possui?
select uf, count(idcidade) as "quantidade de cidades"
from cidade
group by uf
order by "quantidade de cidades" desc;

-- 4) Liste as cidades que possuem o mesmo nome e UF (cidades duplicadas).
select nome as cidade, uf
from cidade
group by nome, uf
having count(1) > 1;
--count(nome) > 1 and count(uf) > 1  É DESNECESSÁRIO.


-- 5) Identifique qual deve ser o próximo ID para a criação de um novo registro
-- na tabela Associado (maior + 1).
select top(1) isnull(idassociado,0) + 1 as "proximo IDAssociado"
from associado
order by idassociado desc;

-- 6) Faça uma consulta que mostre o nome do empregado, o Salario e o percentual a ser 
-- descontado do Imposto de renda.
-- Até 1164.00 = 0%
-- De 1164.00 a 2326.00 = 15%
-- Acima de 2326.00 = 27.5%.
select nomeempregado, salario,
	case
		when salario < 1164.00 then '0%'
		when salario <= 2326.00 then '15%'
		else '27,3%'
	end as "percentual a ser descontado do IR"
from empregado;