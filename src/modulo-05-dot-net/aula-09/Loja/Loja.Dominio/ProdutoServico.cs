using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }

        public void Salvar(Produto produto)
        {
            if (produtoRepositorio.BuscarPorNome(produto.Nome).Count > 0)
            {
                throw new NomeIgualException("Não pode cadastrar um produto com nome igual");
            }

            if(produto.Nome.Length < 2)
            {
                throw new NomeMenorQueDoisCaracteresException("Não pode cadastrar um produto com nome menor que dois caracteres.");
            }

            if (produto.Id == 0)
                produtoRepositorio.Criar(produto);
            else
                produtoRepositorio.Editar(produto);    
        }

        public void Excluir(Produto produto)
        {
            produtoRepositorio.Excluir(produto);
        }

        public List<Produto> ListarProdutos()
        {
            return produtoRepositorio.ListarProdutos();
        }
    }
}
