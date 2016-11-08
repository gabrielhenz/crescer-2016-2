using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RepositorioEF
{
    public class UsuarioRepositorio : BaseRepository, IUsuarioRepositorio
    {
        public void Criar(Usuario usuario)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Usuario>(usuario).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public Usuario BuscarPorId(int id)
        {
            using (var context = new DatabaseContext())
            {
                Usuario usuarioAchado = context.Usuario.FirstOrDefault(u => u.Id == id); 
                //.Include("Role").FirstOrDefault(u => u.Id == id);

                return usuarioAchado;
            }
        }

        public void Atualizar(Usuario usuario)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Usuario>(usuario).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

        public Usuario BuscarUsuarioAutenticado(string login, string senha)
        {
            using (var context = new DatabaseContext())
            {
                return context.Usuario.FirstOrDefault(u => u.Login == login && u.Senha == senha);
            }
        }
    }
}
