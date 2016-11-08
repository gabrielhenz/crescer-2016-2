using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class ListaDePersonagensModel
    {
        public ListaDePersonagensModel(List<Personagem> listaDePersonagens)
        {
            ListaDePersonagens = listaDePersonagens;
        }
        public List<Personagem> ListaDePersonagens { get; set; }
    }
}