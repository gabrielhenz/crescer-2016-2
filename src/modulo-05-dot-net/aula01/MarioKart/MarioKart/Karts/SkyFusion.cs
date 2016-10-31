using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;
using MarioKart.Equipamentos;

namespace MarioKart.Karts
{
    public class SkyFusion : Kart, IEquipamento
    {
        public SkyFusion(Corredor corredor) : base(corredor)
        {
        }

        public int BonusEquipamento
        {
            get
            {
                int bonusPorQuantidadeDeEquipamentos= this.Equipamentos.Count;

                int bonusPorNivelDeHabilidade;
                NivelDeHabilidade nivelDeHabilidade = this.Corredor.NivelDeHabilidade;

                if (nivelDeHabilidade.Equals(NivelDeHabilidade.Noob))
                {
                    bonusPorNivelDeHabilidade = 1;
                }
                else if (nivelDeHabilidade.Equals(NivelDeHabilidade.Mediano))
                {
                    bonusPorNivelDeHabilidade = 2;
                }
                else
                {
                    bonusPorNivelDeHabilidade = 3;
                }

                int somaTotal = bonusPorQuantidadeDeEquipamentos + bonusPorNivelDeHabilidade;

                if (this.Velocidade > 12)
                {
                    somaTotal += 5;
                }

                return somaTotal;
            }
        }

        public override int Velocidade
        {
            get
            {
                return base.Velocidade;
            }
        }
    }
}
