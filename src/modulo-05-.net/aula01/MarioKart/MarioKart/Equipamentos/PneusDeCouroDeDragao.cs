﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class PneusDeCouroDeDragao : IEquipamento
    {
        public int BonusEquipamento
        {
            get
            {
                return 2;
            }
        }
    }
}