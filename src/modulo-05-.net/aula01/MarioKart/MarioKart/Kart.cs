using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;

namespace MarioKart
{
    public class Kart
    {
        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            this.Equipamentos = new List<IEquipamento>();
        }

        public Corredor Corredor { get; private set; }

        public List<IEquipamento> Equipamentos { get; private set; }

        public int Velocidade
        {
            get
            {
                int somaDosBonusDeTodosOsEquipamentos = 0;
                foreach (IEquipamento equipamento in Equipamentos)
                {
                    somaDosBonusDeTodosOsEquipamentos += equipamento.BonusEquipamento;
                }

                int bonusDeHabilidadeDoCorredor;
                NivelDeHabilidade nivelDeHabilidadeDoCorredor = Corredor.NivelDeHabilidade;
                if (nivelDeHabilidadeDoCorredor.Equals(NivelDeHabilidade.Noob))
                {
                    bonusDeHabilidadeDoCorredor = 3;
                }
                else if (nivelDeHabilidadeDoCorredor.Equals(NivelDeHabilidade.Mediano))
                {
                    bonusDeHabilidadeDoCorredor = 5;
                }
                else
                {
                    bonusDeHabilidadeDoCorredor = 6;
                }

                int quantidadeDeEquipamentosNoKart = Equipamentos.Count;

                int somaTotal =
                    3
                    + somaDosBonusDeTodosOsEquipamentos
                    + bonusDeHabilidadeDoCorredor
                    + quantidadeDeEquipamentosNoKart;

                return somaTotal;
            }
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }
    }
}
