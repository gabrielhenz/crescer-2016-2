using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class NomeComNunesException : Exception
    {
        public NomeComNunesException (string mensgagem = "Não é permitido cadastrar persongens overpowered.") 
            : base(mensgagem) { }
    }
}
