using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Usuario
    {
        public Usuario(int id, string login, string senha, string nome) : this(login, senha, nome)
        {
            this.Id = id;
        }

        public Usuario(string login, string senha, string nome)
        {
            this.Login = login;
            this.Senha = senha;
            this.Nome = nome;
        }

        public int Id { get; private set; }
        public string Login { get; private set; }
        public string Senha { get; private set; }
        public string Nome { get; private set; }
        public override string ToString()
        {
            return $"{Id};{Login};{Senha};{Nome}";
        }
    }

}
