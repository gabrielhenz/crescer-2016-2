using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        public Usuario BuscarPorEmail(string email)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Usuario.FirstOrDefault(u => u.Email.Equals(email));
            }
        }

        public void Criar(Usuario usuario)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Usuario>(usuario).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public void Editar(Usuario usuario)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Usuario>(usuario).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

        public void Excluir(Usuario usuario)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Usuario>(usuario).State = EntityState.Deleted;
                context.SaveChanges();
            }
        }

        public Usuario BuscarPorId(int id)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Usuario.First(u => u.Id == id);
            }
        }
    }
}
