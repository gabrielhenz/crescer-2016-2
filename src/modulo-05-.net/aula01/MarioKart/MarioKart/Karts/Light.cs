using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;

namespace MarioKart.Karts
{
    public class Light : Kart
    {
        public Light(Corredor corredor) : base(corredor) { }

        public override int Velocidade
        {
            get
            {
                int velocidade = base.Velocidade;
                NivelDeHabilidade nivelDeHabilidade = this.Corredor.NivelDeHabilidade;

                if (nivelDeHabilidade.Equals(NivelDeHabilidade.Noob))
                {
                    velocidade += 3;
                }

                if (nivelDeHabilidade.Equals(NivelDeHabilidade.Profissional)){
                    velocidade--;
                }

                return velocidade;
            }
        }
    }
}
