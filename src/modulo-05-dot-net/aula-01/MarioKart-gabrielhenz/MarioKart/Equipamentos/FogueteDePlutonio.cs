using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Exceptions;

namespace MarioKart.Equipamentos
{
    public class FogueteDePlutonio : NivelDeEquipamentoException, IEquipamento
    {
        public FogueteDePlutonio(int nivelEquipamento = 2)
        {
            if( nivelEquipamento < 1 || nivelEquipamento > 5)
            {
                throw new NivelDeEquipamentoException();
            }
            else
            {
                this.NivelEquipamento = nivelEquipamento;
            }
        }

        private int NivelEquipamento;

        public int BonusEquipamento
        {
            get
            {
                return this.NivelEquipamento;
            }
        }
    }
}
