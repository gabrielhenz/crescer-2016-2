using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public void Criar(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public void Editar(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

        public void Excluir(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Deleted;
                context.SaveChanges();
            }
        }

        public List<Produto> ListarProdutos()
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.ToList();
            }
        }

        public List<Produto> BuscarPorNome(string nome)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.Where(p => p.Nome.Equals(nome)).ToList();
            }
        }

        public Produto BuscarPorId(int id)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.First(p => p.Id == id);
            }
        }
    }
}
