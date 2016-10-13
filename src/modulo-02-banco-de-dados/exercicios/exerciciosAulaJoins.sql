-- 1)
select nomeempregado, datediff(month, dataadmissao, '2000/12/31') as "total meses trabalhados até 31/12/200"
from empregado
where dataadmissao between '1980/05/01' and '1982/01/20';

-- 2)
select top(1)cargo as "cargo com mais empregados"
from empregado
group by cargo
order by count(cargo) desc;
--offset 0 rows fetch next 1 rows only

-- 3)
select uf, count(idcidade) as "quantidade de cidades"
from cidade
group by uf
order by "quantidade de cidades" desc;

-- 4)
select nome as cidade, uf
from cidade
group by nome, uf
having count(nome) > 1 and count(uf) > 1;

-- 5)
select top(1)idassociado + 1 as "proximo IDAssociado"
from associado
order by idassociado desc;

-- 6)
select nomeempregado, salario,
	case
		when salario < 1164.00 then '0%'
		when salario between 1164.00 and 2326.00 then '15%'
		else '27,3%'
	end as "percentual a ser descontado do IR"
from empregado;