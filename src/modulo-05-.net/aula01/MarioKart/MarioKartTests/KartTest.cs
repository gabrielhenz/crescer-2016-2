﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Corredores;
using MarioKart.Equipamentos;
using MarioKart.Karts;

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

        [TestMethod]
        public void criaKartDoTipoSonnarEVerificaVelocidade()
        {
            var kart = new Sonnar(new Corredor("Mario", NivelDeHabilidade.Profissional));

            kart.Equipar(new MotorABaseDeLuva());

            Assert.AreEqual(15, kart.Velocidade);
        }

        [TestMethod]
        public void criaKartDoTipoLightComCorredorNoobEVerificaVelocidade()
        {
            var kart = new Light(new Corredor("Mario", NivelDeHabilidade.Noob));

            Assert.AreEqual(9, kart.Velocidade);
        }

        [TestMethod]
        public void criaKartDoTipoLightComCorredorProfissionalEVerificaVelocidade()
        {
            var kart = new Light(new Corredor("Mario", NivelDeHabilidade.Profissional));

            Assert.AreEqual(8, kart.Velocidade);
        }

        [TestMethod]
        public void criaKartDoTipoDinamEVerificaVelocidade()
        {
            var kart = new Dinam(new Corredor("Mario", NivelDeHabilidade.Profissional));

            kart.Equipar(new PneusDeCouroDeDragao());

            Assert.AreEqual(19, kart.Velocidade);
        }
    }
}
