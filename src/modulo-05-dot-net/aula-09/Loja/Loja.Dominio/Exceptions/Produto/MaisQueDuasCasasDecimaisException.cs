using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions.Produto
{
    public class MaisQueDuasCasasDecimaisException : Exception
    {
        public MaisQueDuasCasasDecimaisException(string message) : base(message) { }
    }
}
