using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests.Mocks
{
    public class UsuarioRepositorioMock : IUsuarioRepositorio
    {
        private IList<Usuario> usuarios;

        public UsuarioRepositorioMock()
        {
            this.usuarios = new List<Usuario>();
            this.usuarios.Add(new Usuario(1, "goku@bol.com", "abc123"));
        }

        public Usuario BuscarPorEmail(string email)
        {
            return this.usuarios.FirstOrDefault(u => u.Email.Equals(email));
        }

        public void Criar(Usuario usuario)
        {
            usuarios.Add(usuario);
        }

        public void Editar(Usuario usuario)
        {
            usuarios[usuario.Id - 1] = usuario;
        }

        public void Excluir(Usuario usuario)
        {
            usuarios.RemoveAt(usuario.Id - 1);
        }
    }
}
