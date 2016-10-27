using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Corredores;
using MarioKart.Equipamentos;

namespace MarioKartTests
{
    [TestClass]
    public class KartTest
    {
        [TestMethod]
        public void criaKartComPneusDeCouroDeDragaoECorredorMedianoETestaAVelocidade()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            
            kart.Equipar(new PneusDeCouroDeDragao());

            Assert.AreEqual(10, kart.Velocidade);
        }
    }
}
