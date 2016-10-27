using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Corredores;

namespace MarioKartTests
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void criaCorredorComNomeDeYoshiENivelDeHabilidadeMediano()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);

            Assert.AreEqual("Yoshi", corredor.Nome);
            Assert.AreEqual(NivelDeHabilidade.Mediano, corredor.NivelDeHabilidade);
        }
    }
}
