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

        public virtual int Velocidade
        {
            get
            {
                int somaDosBonusDeTodosOsEquipamentos = 0;
                foreach (IEquipamento equipamento in Equipamentos)
                {
                    somaDosBonusDeTodosOsEquipamentos += equipamento.BonusEquipamento;
                }

                int somaTotal =
                    3
                    + somaDosBonusDeTodosOsEquipamentos
                    + bonusHabilidadeCorredor();

                return somaTotal;
            }
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        public int bonusHabilidadeCorredor ()
        {
            int bonusHabilidadeCorredor;
            NivelDeHabilidade nivelDeHabilidadeDoCorredor = this.Corredor.NivelDeHabilidade;
            if (nivelDeHabilidadeDoCorredor.Equals(NivelDeHabilidade.Noob))
            {
                bonusHabilidadeCorredor = 3;
            }
            else if (nivelDeHabilidadeDoCorredor.Equals(NivelDeHabilidade.Mediano))
            {
                bonusHabilidadeCorredor = 5;
            }
            else
            {
                int quantidadeDeEquipamentosNoKart = Equipamentos.Count;
                bonusHabilidadeCorredor = 6 + quantidadeDeEquipamentosNoKart;
            }

            return bonusHabilidadeCorredor;
        }
    }
}
