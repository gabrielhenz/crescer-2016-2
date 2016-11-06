using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FakeItEasy;

namespace StreetFighter.Testes.Dominio
{
    [TestClass]
    public class PersonagemTest
    {
        [TestMethod]
        public void CriaUmPersonagemEChamaToString()
        {
            string esperada = "0;http://peppapig.jpg;Peppa pig;8 de abril de 2000;185;79,95;BR;Nenhum;False";
            Personagem personagem = new Personagem(0, "http://peppapig.jpg", "Peppa pig", new DateTime(2000, 4, 8), 185, 79.95, "BR", "Nenhum", false);
            Assert.AreEqual(esperada, personagem.ToString());
        }
    }
}
