using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests.Mocks
{
    public class ProdutoRepositorioMock : IProdutoRepositorio
    {
        private IList<Produto> produtos;

        public ProdutoRepositorioMock()
        {
            this.produtos = new List<Produto>();
            this.produtos.Add(
                new Produto(
                    1, 
                    "Livro - Harry Potter e a Criança Amaldiçoada (Livro 8) - Capa Dura", 
                    64.50m));
        }

        public Produto BuscarPorId(int id)
        {
            return produtos.First(p => p.Id == id);
        }

        public List<Produto> BuscarPorNome(string nome)
        {
            return produtos.Where(p => p.Nome.Equals(nome)).ToList();
        }

        public void Criar(Produto produto)
        {
            produtos.Add(produto);
        }

        public void Editar(Produto produto)
        {
            produtos[produto.Id - 1] = produto;
        }

        public void Excluir(Produto produto)
        {
            produtos.RemoveAt(produto.Id - 1);
        }

        public List<Produto> ListarProdutos()
        {
            return produtos.ToList();
        }
    }
}
