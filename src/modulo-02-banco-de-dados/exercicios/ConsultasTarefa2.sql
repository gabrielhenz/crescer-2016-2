-- 1)
select empregado, count(empregado) as total_Participacoes_Projeto
	from projeto 
	group by empregado
	having count(empregado) > 1;
-- somente no order by posso usar o Alias.

-- 2)
select distinct projeto from projeto where (valorfaturado - valorrealizado) > 0;

-- 3)
select projeto from projeto where (valorfaturado - valorrealizado) <= 0;

-- 4)
select distinct empregado as "nome empregado",
case
	when charindex(' ', empregado) = 0
		then empregado
		else substring(empregado, 1, charindex(' ', empregado))
		end as "primeiro nome"
from projeto;