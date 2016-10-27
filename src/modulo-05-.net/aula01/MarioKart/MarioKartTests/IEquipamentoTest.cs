using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;

namespace MarioKartTests
{
    [TestClass]
    public class IEquipamentoTest
    {
        [TestMethod]
        public void criaEquipamentoMotorABaseDeLuvas()
        {
            IEquipamento equipamento = new MotorABaseDeLuva();

            Assert.AreEqual(3, equipamento.BonusEquipamento);
        }

        [TestMethod]
        public void criaEquipamento()
        {
            IEquipamento equipamento = new PneusDeCouroDeDragao();

            Assert.AreEqual(2, equipamento.BonusEquipamento);
        }
    }
}
