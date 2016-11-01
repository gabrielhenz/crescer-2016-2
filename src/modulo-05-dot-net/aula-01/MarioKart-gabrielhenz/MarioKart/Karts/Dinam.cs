using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;

namespace MarioKart.Karts
{
    public class Dinam : Kart
    {
        public Dinam(Corredor corredor) : base(corredor) { }

        public override int Velocidade
        {
            get
            {
                //bonus de habilidade do corredor dobrado
                return base.Velocidade + this.BonusHabilidadeCorredor();
            }
        }
    }
}
