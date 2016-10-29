using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Exceptions
{
    public class NivelDeEquipamentoException : Exception {
        public NivelDeEquipamentoException
            (string message = "O nível do equipamento deve ser entre 1 e 5") 
            : base(message) { }
    }
    
}
