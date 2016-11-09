using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class NomeMenorQueDoisCaracteresException : Exception
    {
        public NomeMenorQueDoisCaracteresException(string message) : base (message) { }
    }
}
