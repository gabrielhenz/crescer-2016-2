using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class NomeProdutoIgualException : Exception
    {
        public NomeProdutoIgualException(string message) : base (message) { }
    }
}
