-- 1) Liste o total de pedidos realizados no mês de setembro de 2016.
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
4) Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
Nome: Galocha Maragato 
Preço de custo: 35.67 
Preço de venda: 77.95 
Situação: A  
*/
Insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
Values ('Galocha Maragato', 35.67, 77.95, 'A');
--Select * from Produto where Nome = 'Galocha Maragato';


/*
5) Identifique e liste os produtos que não tiveram nenhum pedido, 
considere os relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto e Pedido 
(será preciso relacionar PedidoItem). 
Obs.: o produto criado anteriormente deverá ser listado (apenas este) 
*/
Select *
From Produto as p
Left join PedidoItem as pitem
	On p.IDProduto = pitem.IDProduto
Where pitem.IDProduto IS NULL;


/*
6) Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número 
de clientes (tabela Cliente), liste também qual o Estado possuí o menor número de clientes. 
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
-- a)
Select p.IDPedido, 
	   p.DataEntrega, 
	   p.ValorPedido, 
	   pitem.Quantidade, 
	   c.Nome as cliente
From Pedido as p
Inner join Cliente as c 
	on c.IDCliente = p.IDCliente
Inner join PedidoItem as pitem 
	on pitem.IDPedido = p.IDPedido
Inner join Produto as pr 
	on pr.IDProduto = pitem.IDProduto
Inner join ProdutoMaterial as pm
	on pm.IDProduto = pr.IDProduto
Where month(DataEntrega) = 10
And	  year(DataEntrega) = 2016
And pm.IDMaterial in (14650, 15703, 15836, 16003, 16604, 17226);


/*8) Dentro da atual estrutura, cada produto é composto por 1 ou vários materiais (tabela ProdutoMaterial).
 Identifique se existe algum produto sem material relacionado.
Obs.: o produto criado anteriormente deverá ser listado.*/
Select p.IDProduto
From Produto as p
Left join ProdutoMaterial as pm
	On pm.IDProduto = p.IDProduto
Where pm.IDProduto IS NULL;
-- existem 2 produtos sem material relacionado


-- 9) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
Select  top(1) with ties substring(nome, 1, charindex(' ', nome) - 1) as "primeiro nome mais popular",
		count(1) as "quantidade de clientes com o mesmo nome"
From Cliente
Group by substring(nome, 1, charindex(' ', nome) - 1)
having count(1) > 1
order by "quantidade de clientes com o mesmo nome" DESC;


-- Exercicio 10)
Update Produto
Set Situacao = 'F'
Where IDProduto in (Select p.IDProduto 
					From Produto as p
					Inner join ProdutoMaterial as pm
						On pm.IDProduto = p.IDProduto
					Where pm.IDMaterial in (14650, 
					                  15703, 
									  15836, 
									  16003, 
									  16604, 
									  17226));

Update Produto
Set Situacao = 'Q'
Where Situacao NOT LIKE 'F'
And IDProduto in (Select pr.IDProduto
				  From Produto as pr
				  Left join PedidoItem as pitem on pitem.IDProduto = pr.IDProduto
				  Inner join Pedido as pd on pd.IDPedido = pitem.IDPedido
				  Where month(DataPedido) < month(getdate()) - 2);

Update Produto
Set Situacao = 'A'
Where Situacao NOT LIKE 'F'
And Situacao NOT LIKE 'Q';

