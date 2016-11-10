using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class UsuarioLogadoModel
    {
        public UsuarioLogadoModel(int id, string nome)
        {
            this.Id = id;
            this.Nome = nome;
        }

        public int Id { get; private set; }

        public string Nome { get; private set; }
    }
}