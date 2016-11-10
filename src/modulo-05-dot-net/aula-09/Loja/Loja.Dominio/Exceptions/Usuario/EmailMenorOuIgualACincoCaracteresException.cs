using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions.Usuario
{
    public class EmailMenorOuIgualACincoCaracteresException : Exception
    {
        public EmailMenorOuIgualACincoCaracteresException (string message) : base (message) { }
    }
}
