using Loja.Dominio.Exceptions;
using Loja.Dominio.Exceptions.Produto;
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
            int count = BitConverter.GetBytes(decimal.GetBits(produto.Valor)[3])[2];

            if (count > 2)
                throw new MaisQueDuasCasasDecimaisException("Não pode cadastrar um produto de valor com mais de duas casas decimais.");

            if (produtoRepositorio.BuscarPorNome(produto.Nome).Count > 0)
                throw new NomeProdutoIgualException("Não pode cadastrar um produto com nome igual");

            if (produto.Nome.Length < 2)
                throw new NomeProdutoMenorQueDoisCaracteresException("Não pode cadastrar um produto com nome menor que dois caracteres.");

            if (produto.Valor <= 0)
                throw new ValorProdutoIgualAZeroException("Não pode cadastrar um prouto com o valor igual ou menor que zero.");

            if (produto.Id == 0)
                produtoRepositorio.Criar(produto);
            else
                produtoRepositorio.Editar(produto);    
        }

        public void Excluir(int id)
        {
            Produto produto = produtoRepositorio.BuscarPorId(id);
            produtoRepositorio.Excluir(produto);
        }

        public List<Produto> ListarProdutos()
        {
            return produtoRepositorio.ListarProdutos();
        }

        public Produto BuscarPorId(int id)
        {
            return produtoRepositorio.BuscarPorId(id);
        }
    }
}
