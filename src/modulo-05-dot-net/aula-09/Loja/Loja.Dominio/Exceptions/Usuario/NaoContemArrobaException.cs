using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions.Usuario
{
    public class NaoContemArrobaException : Exception
    {
        public NaoContemArrobaException(string message) : base(message) { }
    }
}
