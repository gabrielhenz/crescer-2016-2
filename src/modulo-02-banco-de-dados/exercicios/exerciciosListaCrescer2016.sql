-- 1) Liste o total de pedidos realizados no m�s de setembro de 2016.
Select count(IDPedido)
From Pedido
Where month(DataPedido) = 9 and 
	  year(DataPedido) = 2016;

-- 2) Liste quais os produtos que utilizam o material de IDMaterial = 15836.
Select Nome
From Produto as p
Inner join ProdutoMaterial as pm
	on p.IDProduto = pm.IDProduto
Where pm.IDMaterial = 15836;


-- Prova real: outputs 3.
Select count(1)
From ProdutoMaterial
Where IDProduto IN (Select IDProduto
					From Produto
					Where Nome IN('Abs Pos Parto Brasfa',
					              'Abs Always S Abas L',
								  'Abobrinha Brasil Sel'))
and IDMaterial = 15836;


-- 3) Liste todos os clientes que tenham o LTDA no nome ou razao social. 
Select Nome as cliente
From Cliente
Where Nome like '%LTDA%' or
	  RazaoSocial like '%LTDA%';


/*
4) Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
Nome: Galocha Maragato 
Pre�o de custo: 35.67 
Pre�o de venda: 77.95 
Situa��o: A  
*/
Insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
Values ('Galocha Maragato', 35.67, 77.95, 'A');
--Select * from Produto where Nome = 'Galocha Maragato';


/*
5) Identifique e liste os produtos que n�o tiveram nenhum pedido, 
considere os relacionamentos no modelo de dados, pois n�o h� relacionamento direto entre Produto e Pedido 
(ser� preciso relacionar PedidoItem). 
Obs.: o produto criado anteriormente dever� ser listado (apenas este) 
*/
Select *
From Produto as p
Left join PedidoItem as pitem
	On p.IDProduto = pitem.IDProduto
Where pitem.IDProduto IS NULL;


/*
6) Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero 
de clientes (tabela Cliente), liste tamb�m qual o Estado possu� o menor n�mero de clientes. 
*/
Select
(Select top(1) with ties c.UF
From Cidade as c
Inner join Cliente as cl
	On cl.IDCidade = c.IDCidade
Group by UF
Order by count(1) DESC) as "estado com maior numero de clientes",
(Select top(1) with ties c.UF
From Cidade as c
Inner join Cliente as cl
	On cl.IDCidade = c.IDCidade
Group by UF
Order by count(1) ASC) as "estado com menor numero de clientes";


-- Exercicio 7)
Select IDPedido,
	   DataEntrega,
	   ValorPedido,
	   (Select count(1)
	   From PedidoItem as pitem
	   Where pitem.IDPedido = p.IDPedido
	   ) as "quantidade de itens"
From Pedido as p
Where month(DataEntrega) = 10
and   year(DataEntrega) = 2016;

