-- página 15, 2º slide
-- 1) Crie a tabela CidadeAux a partir de uma cópia da tabela Cidade. Considere todos os registros existentes.
Select * into CidadeAux from Cidade;

-- 2) Limpe a tabela CidadeAux (Truncate table CidadeAux). E em seguida insira todas os registros da tabela Cidade nesta auxiliar.
Truncate table CidadeAux;
Insert into CidadeAux select * from Cidade;

-- 3) Crie uma tabela para armazenar informações de produtos
-- Devem ter os seguintes atributos:
-- Código de identificação; Nome curto, Nome descritivo, Data da criação, Local no estoque, Quantidade e Preço.
Create table Produto(
	 IDProduto		int			  not null
	,NomeCurto		varchar(50)	  not null
	,NomeDescritivo varchar(100)
	,DataDaCriacao	datetime default getdate()	not null
	,LocalNoEstoque	varchar(30)	  not null
	,Quantidade		decimal(10,3) not null
	,Preco			decimal(10,2) not null
);
Alter table Produto add constraint PK_Produto primary key (IDProduto);

create index 
-- 4) Cadastre 2 produtos nesta tabela
Insert into Produto 
	(
	 IDProduto
	,NomeCurto
	,NomeDescritivo
	,LocalNoEstoque
	,Quantidade
	,Preco
	)
values
	(
	1
	,'Estojo'
	,'Estojo Papa Goiaba - Since 1992'
	,'Esteio'
	,1
	,20.99
	)
	,(
	2
	,'Notebook'
	,'Notebook da DELL, intel core i3.'
	,'São Leopoldo'
	,25
	,1500.00
	);


--------------------------------------------------------------------------------------------------
-- página 30, 2º slide
-- 1) Faça uma consulta (query) que retorne o nome dos empregados exibindo em ordem de admissão.
Select NomeEmpregado from Empregado order by DataAdmissao asc;
									-- order by 1 asc;

-- 2) Faça uma consulta que retorne o nome dos empregados e o salário anual,
-- onde o cargo seja Atendente ou que o salário anual seja inferior a R$18.500,00.
Select NomeEmpregado, Salario * 12 as "Salário Anual"
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

