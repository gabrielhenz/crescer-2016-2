using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;

namespace MarioKart.Karts
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor corredor) : base(corredor) { }

        public override int Velocidade
        {
            get
            {
                int quantidadeDeEquipamentos = this.Equipamentos.Count;
                return (quantidadeDeEquipamentos >= 1) ? base.Velocidade + 2 : base.Velocidade;
            }
        }
    }
}
