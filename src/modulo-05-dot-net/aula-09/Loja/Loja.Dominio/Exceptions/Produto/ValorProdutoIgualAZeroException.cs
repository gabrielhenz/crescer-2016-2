using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions
{
    public class ValorProdutoIgualAZeroException : Exception
    {
        public ValorProdutoIgualAZeroException(string message) : base(message) { }
    }
}
