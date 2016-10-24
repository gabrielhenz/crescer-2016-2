/*
1) Fa�a uma consulta que traga os clientes que mais compraram (frequ�ncia), filtrando por estado e considerando
apenas os �ltimos 3 meses.
*/
SELECT cd.UF, 
	   cl.IDCliente, 
	   cl.Nome as Nome_Cliente, 
	   count(pd.IDPedido) as quantidadeDePedidos
FROM cliente as cl
INNER JOIN cidade as cd 
	ON cd.IDCidade = cl.IDCidade
INNER JOIN pedido as pd
	ON pd.IDCliente = cl.IDCliente
WHERE month(pd.DataPedido) >= (month(getdate()) - 2)
GROUP BY  cd.UF,cl.IDCliente, cl.Nome
ORDER BY cd.UF;


/*
2) Fa�a uma consulta que liste as cidades duplicadas. Ap�s identifique e liste os clientes que utilizam estas cidades
(apenas as cidades duplicadas).
*/
SELECT cl.IDCliente, cl.Nome as cliente, cd.Nome, cd.UF
FROM cliente as cl
INNER JOIN cidade as cd
	ON cd.IDCidade = cl.IDCidade
HAVING count(cd.IDCidade) > 0;
