using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;
using MarioKart.Exceptions;

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
        public void criaEquipamentoPneusDeCouroDeDragao()
        {
            IEquipamento equipamento = new PneusDeCouroDeDragao();

            Assert.AreEqual(2, equipamento.BonusEquipamento);
        }

        [TestMethod]
        public void criaEquipamentoFogueteDePlutonioComNivelEquipamentoPadrao()
        {
            IEquipamento equipamento = new FogueteDePlutonio();

            Assert.AreEqual(2, equipamento.BonusEquipamento);
        }

        [TestMethod]
        [ExpectedException (typeof (NivelDeEquipamentoException))]
        public void criaEquipamentoFogueteDePlutonioComNivelEquipamentoMenorQueUm()
        {
            var equipamento = new FogueteDePlutonio(0);
        }

        [TestMethod]
        [ExpectedException(typeof(NivelDeEquipamentoException))]
        public void criaEquipamentoFogueteDePlutonioComNivelEquipamentoMaiorQueCinco()
        {
            var equipamento = new FogueteDePlutonio(6);
        }

        [TestMethod]
        public void criaEquipamentoUltraPackComFogueteDePlutonio()
        {
            var equipamento = new UltraPack(new FogueteDePlutonio());

            Assert.AreEqual(3, equipamento.BonusEquipamento);
        }

        [TestMethod]
        public void criaEquipamentoUltraPackComUltraPack()
        {
            var equipamento = new UltraPack(new UltraPack(new FogueteDePlutonio()));

            Assert.AreEqual(4, equipamento.BonusEquipamento);
        }
    }
}
