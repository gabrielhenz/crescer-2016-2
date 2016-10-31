using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {
        public UltraPack(IEquipamento equipamento)
        {
            this.Equipamento = equipamento;
        }

        private IEquipamento Equipamento;

        public int BonusEquipamento
        {
            get
            {
                double bonusNestedEquipamento = this.Equipamento.BonusEquipamento;
                int bonusTotal = Convert.ToInt32(Math.Ceiling(bonusNestedEquipamento * 1.20));

                return bonusTotal;
            }
        }

    }
}
