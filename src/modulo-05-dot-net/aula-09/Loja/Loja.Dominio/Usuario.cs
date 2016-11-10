using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class Usuario
    {
        public Usuario() { }

        public Usuario(int id, string email, string senha) : this(email, senha)
        {
            this.Id = id;
        }

        public Usuario(string email, string senha)
        {
            this.Email = email;
            this.Senha = senha;
        }

        public int Id { get; set; }

        public string Email { get; set; }

        public string Senha { get; set; }
    }
}
